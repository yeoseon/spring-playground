package me.yeoseon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {        // WebMvcConfigurer를 통해, 기존에 Springboot가 제공하는 모든 Configurable한 옵션을 쓰면서, 추가로 넣을 수 있다.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors")        // "/**"로 하면 모든 API를 다 CORS로 띄우겠다.는 말임
                .allowedOrigins("http://localhost:8081");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")      // 반드시 '/'로 끝나야 한다.  
                .setCachePeriod(20);
    }
}
