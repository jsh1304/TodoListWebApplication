package com.jj.springboot.todolistwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("jj");
        boolean isValidPassword = password.equalsIgnoreCase("1234");

        return isValidUserName && isValidPassword;
    }
}
