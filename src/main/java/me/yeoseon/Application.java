package me.yeoseon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// @EnableConfigurationProperties(YeoseonProperties.class) // 이렇게 등록하지 않고, 해당 Properties 클래스를 Bean으로만 등록해주면 자동으로 해당 어노테이션으로 설정된다.
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
