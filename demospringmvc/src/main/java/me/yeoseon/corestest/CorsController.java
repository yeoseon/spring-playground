package me.yeoseon.corestest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    @CrossOrigin(origins = {"http://localhost:8081"})       //이렇게 설정하면 CORS를 사용할 수 있다.
    @GetMapping("/cors")
    public String hello() {
        return "hello";
    }
}
