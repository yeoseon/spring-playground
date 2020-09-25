package me.yeoseon.exceptiontest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exception")
    public String exception() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)       // ExceptionController 내에서 Exception이 발생하면, 나는 이 Handler를 사용하겠다.
    public @ResponseBody AppError sampleError(SampleException e) {  // Exception 클래스를 직접 받아와서 사용할 수도 있다.
        // 이 App에 특화된 Erorr 내용을 담고 있는 객체가 있다면 이렇게 받아올 수 있다. 평소에는 ResponseEntity와 같은 객체로 받아올 수도 있다.
        AppError appError = new AppError();

        //Error가 발생할 경우, 내용을 채워서 반환한다.
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }
}
