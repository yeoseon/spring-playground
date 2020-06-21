package me.yeoseon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @SpringBootApplication은 아래 3개의 어노테이션으로 구성된다.
//* ```@SpringBootConfiguration```
//* ```@ComponentScan```
//* ```@EnableAutoConfiguration```
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
