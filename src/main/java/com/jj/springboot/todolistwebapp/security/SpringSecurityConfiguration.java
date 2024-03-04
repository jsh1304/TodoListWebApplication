package com.jj.springboot.todolistwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;


@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        // 사용자 세부 정보 생성
        UserDetails userDetails1 = createNewUser("jj", "1234");
        UserDetails userDetails2 = createNewUser("qq", "1234");

        // InMemoryUserDetailsManager 빈 생성하여 사용자 세부 정보 반환
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        // 비밀번호 인코딩을 위한 함수 정의
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        // 사용자 세부 정보 생성
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password) // 비밀번호 인코딩
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder 빈 생성하여 반환
        return new BCryptPasswordEncoder();
    }
}