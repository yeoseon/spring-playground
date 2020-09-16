package org.springframework.samples.petclinic.owner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 기존의 서블릿 개발 방식
 *  이 서블릿을 Override를 통해 구현한 후, web.xml을 통해 특정 요청 (/owner/create)이 들어오면
 *  Get이나 Post에 따라 이 메소드를 수행시켜주는 방식으로 개발했다.
 *  하지만 Spring에서는 더이상 이런 클래스를 만들어 설정하지 않는다.
 *  Spring에서는 (OwnerController 참고) @GetMapping 이나 @PostMapping라는 어노테이션을 이용하여 수행한다.
 */
public class OwnerCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
