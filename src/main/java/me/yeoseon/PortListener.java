package me.yeoseon;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {
    // 웹 서버가 초기화(생성)되면, 이 이벤트 리스너가 호출이 된다.
    // 아래 메소드 부분의 콜백이 호출된다.
    // 여기서 Port를 읽어오도록 해준다.
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent servletWebServerInitializedEvent) {
        // 웹 서버 어플리케이션 컨텐스트를 먼저 얻는다.
        ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();
        // 웹 서버 어플리케이션 컨텍스트이기 때문에 웹 서버를 알 수 있고, 포트를 알 수 있다.
        System.out.println(applicationContext.getWebServer().getPort());
    }
}
