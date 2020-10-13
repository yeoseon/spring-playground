package me.yeoseon.springsecuritycustomizing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/customizing/hello")
    public String hello() {
        return "custom_hello";
    }

    @GetMapping("/customizing/my")
    public String my() {
        return "custom_my";
    }
}
