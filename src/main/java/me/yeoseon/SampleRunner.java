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

    @Autowired
    private String hello;

    @Value("${yeoseon.name}")   // 다음과 같이 사용하면 Type-Safe 하지 않다.
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===============");
        System.out.println(hello);
        System.out.println(yeoseonProperties.getName());
        System.out.println(yeoseonProperties.getAge());
        System.out.println(yeoseonProperties.getSesseionTimeout());
        System.out.println("===============");
    }
}
