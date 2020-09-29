package me.yeoseon.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest        // 슬라이싱 테스트 Annotation을 사용하여, 해당되는 Class만 Bean으로 등록하여 사용한다. - 이때는 인메모리 데이터베이스가 필요하다.
//@SpringBootTest   // Integration 테스트 : @SpringBootApplication 어노테이션을 찾아서 Applicaiton 내의 모든 Bean이 다 등록된다. 권장하지 않는다.
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        // 비어있는 테스트 - Bean이 잘 등록이 되었는지 확인

        try(Connection connection = dataSource.getConnection()) {
            //H2를 테스트에서 사용하는지 확인
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
    }

    @Test
    public void accountTest() throws SQLException {
        Account account = new Account();

        account.setUsername("yeoseon");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount.getId()).isNotNull();

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotEmpty();

        Optional<Account> notExistingAccount = accountRepository.findByUsername("celine");
        assertThat(notExistingAccount).isEmpty();
    }
}
