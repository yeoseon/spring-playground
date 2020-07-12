package me.yeoseon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SampleListener implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //JVM 옵션은 무시한다.
        Arrays.stream(args).forEach(System.out::println);
    }
}
