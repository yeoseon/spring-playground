package me.yeoseon.sample;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import me.yeoseon.sample.SampleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebClient webClient;        // MockMvc와 함께 둘다 사용이 가능하다.

    @Test
    public void hello() throws Exception {
        // MockMvc를 이용한 테스트
        mockMvc.perform(get("/sample/hello"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("sampleHello"))
                .andExpect(model().attribute("name", is("yeoseon")))      // 모델 이름 : yeoseon, 뷰 이름 : hello
                .andExpect(content().string(containsString("yeoseon")));      // Rendering 된 View 결과도 확인할 수 있다.

        // HtmlUnit을 이용한 View의 단위 테스트
        HtmlPage page = webClient.getPage("/sample/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");     // HtmlHeading 타입으로 맨 첫번째 h1을 가져온다. Object 등 다양한 타입으로도 가져올 수 있다.
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("yeoseon");
    }
}
