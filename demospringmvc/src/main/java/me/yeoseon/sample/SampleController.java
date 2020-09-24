package me.yeoseon.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample/hello")
    public String hello(Model model) {
        model.addAttribute("name", "yeoseon");
        return "sampleHello";     // 응답의 본문이 아님. @RestController가 아닌 @Controller이기 떄문에
    }


}
