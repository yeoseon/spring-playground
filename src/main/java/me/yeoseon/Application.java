package me.yeoseon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello Test Project");

        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
