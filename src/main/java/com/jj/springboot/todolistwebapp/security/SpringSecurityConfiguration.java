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
        // 비밀번호 인코딩을 위한 함수 정의
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        // 사용자 세부 정보 생성
        UserDetails userDetails = User.builder()
                .username("jj")
                .password("1234") // 비밀번호 인코딩
                .roles("USER", "ADMIN")
                .build();

        // InMemoryUserDetailsManager 빈 생성하여 사용자 세부 정보 반환
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder 빈 생성하여 반환
        return new BCryptPasswordEncoder();
    }
}