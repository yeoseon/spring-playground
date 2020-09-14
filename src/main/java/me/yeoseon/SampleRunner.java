package me.yeoseon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Autowired
    YeoseonProperties yeoseonProperties;

    @Autowired
    private String hello;

    @Value("${yeoseon.name}")   // 다음과 같이 사용하면 Type-Safe 하지 않다.
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("===============");
        logger.debug(hello);
        logger.debug(yeoseonProperties.getName());
        logger.debug("===============");
    }
}
