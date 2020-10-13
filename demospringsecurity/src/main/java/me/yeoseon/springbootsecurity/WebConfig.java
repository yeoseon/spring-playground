package me.yeoseon.springbootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 이렇게 추가하면 url 에 맞는 view 이름이 호출된다.
     * 즉 현재 구현되어 있는 HomeController의 hello를 구현할 필요 없다는 말이다.
     * 단순 url에 맞는 view 이름만 호출할 때에는 이 방법을 쓰는 것도 간단한 방법이다.
     * 하지만 보통 그러지 않으니..
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
    }
}
