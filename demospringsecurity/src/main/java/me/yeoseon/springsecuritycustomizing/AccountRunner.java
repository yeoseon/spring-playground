package me.yeoseon.springsecuritycustomizing;

import me.yeoseon.springsecuritycustomizing.account.Account;
import me.yeoseon.springsecuritycustomizing.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account yeoseon = accountService.createAccount("yeoseon", "12345");
    }
}
