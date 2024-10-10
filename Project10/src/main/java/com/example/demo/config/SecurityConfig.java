package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration //스프링 설정 클래스
@EnableWebSecurity //보안 설정
public class SecurityConfig {
	//로그인 인증 처리를 위한 필터 체인
	//필터 체인을 커스텀하여 생성하고 빈으로 등록
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		//메뉴별 접근 권한 설정
		//회원가입: 아무나 접근 가능
		http.authorizeRequests()
			.requestMatchers("/register").permitAll() //모든사용자 접근 허용
			.requestMatchers("/assets/*", "/css/*", "/js/*").permitAll()
			.requestMatchers("/").authenticated()
			.requestMatchers("/board/*").hasAnyRole("ADMIN", "USER")
			.requestMatchers("/comment/*").hasAnyRole("ADMIN", "USER")
			.requestMatchers("/member/*").hasRole("ADMIN");
		
		
		//로그인 폼 화면 설정
		//로그인화면과 로그인 처리 주소 설정
		//로그인 성공 시 이동할 주소 설정
		http.formLogin()
						.loginPage("/customlogin")
						.loginProcessingUrl("/login")
										//람다식 함수로 구현 
						.successHandler((HttpServletRequest request, 
										HttpServletResponse response, 
										Authentication authentication)->{
										//로그인 성공시 메인화면으로 이동
										response.sendRedirect("/");
							});
		

		//로그아웃 설정
		http.logout();
		// csrf 설정 (get외에 post, put, delete 허용)
		http.csrf().disable();
		
		return http.build();
	}
	
	//회원가입시 사용자 패스워드를 암호화하는데 사용할 인코더
	//BCrypt: 암호화 알고리즘의 종류 (단방향) 복호화가 안되는 알고리즘
	@Bean // 빈을 생성하여 컨테이너에 저장
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
