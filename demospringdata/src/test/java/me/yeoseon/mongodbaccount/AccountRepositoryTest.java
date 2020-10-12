package me.yeoseon.mongodbaccount;

import me.yeoseon.mongdbaccount.Account;
import me.yeoseon.mongdbaccount.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setUsername("yeoseon");
        account.setEmail("devyyskr@gmail.com");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        assertThat(byId).isNotNull();
        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail.get().getUsername()).isEqualTo("yeoseon");
    }
}
