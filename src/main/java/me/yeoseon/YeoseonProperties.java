package me.yeoseon;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@ConfigurationProperties("yeoseon")
@Validated  // 프로퍼티 값 검증을 수행할 수 있다. (@NotEmpty 등의 어노테이션 이용)
public class YeoseonProperties {

    @NotEmpty
    private String name;
    private int age;
    private String fullName;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sesseionTimeout = Duration.ofSeconds(30);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Duration getSesseionTimeout() {
        return sesseionTimeout;
    }

    public void setSesseionTimeout(Duration sesseionTimeout) {
        this.sesseionTimeout = sesseionTimeout;
    }

}
