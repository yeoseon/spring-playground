package me.yeoseon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
@Order(2)
public class MySQLRunner implements ApplicationRunner {
    // JDBC 의존성 추가시 아래 2개의 객체를 바로 사용할 수 있다.
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("[MySQL Database Configuration]");
            System.out.println(dataSource.getClass());  // 어떤 DBCP를 사용하는지 보기 위해
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());
            System.out.println("-----------------------------------------------------------------");
            //원래는 Transaction 처리를 해줘야 한다.
            //테이블 생성
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
//            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        // jdbcTamplate을 사용할 경우 위의 많은 줄을 아래와 같이 간결하고 안전하게 (try-catch 처리가 알아서 됨) sql을 사용할 수 있다.
        // 에러시, 가독성이 더 높은 메시지를 확인할 수 있다.
        // 위 try 내부보다는, 이 jdbcTamplate을 사용하자.
//        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'yeoseon')");
    }
}
