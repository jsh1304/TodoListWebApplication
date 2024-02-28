package com.jj.springboot.todolistwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 1. 알맞은 Controller 메서드 식별 : login -> LoginController.gotoLoginPage
 * 2. Controller 메서드 실행 -> data를 model에 put한다. view name 리턴한다.
 * 3. 알맞은 뷰를 식별 -> 디스패처 서블릿은 뷰 리졸버를 사용
 * 4. 뷰를 실행
 * **/
@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoLoginPage(ModelMap model) {
        model.put("name", "jj");
        return "welcome";
    }

    /**
     * "/login" 엔드포인트에 대한 POST 요청을 처리
     * 사용자 자격 증명을 확인하고 인증이 성공하면 환영 페이지로 리디렉션
     * 그렇지 않으면 로그인 페이지에 오류 메시지를 표시
     */

}
