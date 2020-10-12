package me.yeoseon;

import me.yeoseon.mongdbaccount.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application {

    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 이번엔 여기에 Runner를 만들어 보자.
    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();

            account.setEmail("devyyskr@gmail.com");
            account.setUsername("yeoseon");

            mongoTemplate.insert(account);
        };
    }
}
