package com.jj.springboot.todolistwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        auth -> auth.anyRequest().authenticated()) // 모든 요청을 인증된 사용자만 허용
                .formLogin(withDefaults()) // 기본 로그인 폼 사용
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .headers(headers -> headers.frameOptions(options ->
                        options.disable())); // X-Frame-Options 비활성화

        /**
         * CSRF(Cross-Site Request Forgery)는 웹사이트가 사용자의 의도와는 무관하게 악의적인 요청을 수행하도록 만드는 보안 취약점
         * X-Frame-Options은 웹사이트가 다른 사이트의 <iframe>이나 <frame> 내에서 렌더링되는 것을 제어하는 HTTP 응답 헤더
         * **/
        return http.build(); // SecurityFilterChain 빌드하여 반환
    }
}