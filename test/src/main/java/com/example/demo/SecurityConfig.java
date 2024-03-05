package com.example.demo;//パッケージの宣言

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
              .authorizeHttpRequests(authz -> authz //httpセキュリティを用いたセキュリティ設定群
            		.requestMatchers("/**").permitAll()//すべてのリクエストを許可する /**はすべてのリンク、permitAllは認可不要のアクセス許可
            );
        return http.build();
    }    
}