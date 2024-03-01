package com.jj.springboot.todolistwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
