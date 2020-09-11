package me.yeoseon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    YeoseonProperties yeoseonProperties;

    @Value("${yeoseon.name}")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===============");
        System.out.println(yeoseonProperties.getName());
        System.out.println(yeoseonProperties.getAge());
        System.out.println("===============");
    }
}
