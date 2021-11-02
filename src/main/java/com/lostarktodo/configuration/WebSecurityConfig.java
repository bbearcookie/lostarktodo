package com.lostarktodo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/account/login", "/account/register", "/hello", "/plugin/bootstrap-5.1.3-dist/**", "/css/**").permitAll() // 이 페이지나 경로들은 권한이 없어도 모두가 접근할 수 있게끔 함.
				.anyRequest().authenticated() // 그 외의 페이지는 인증(로그인)이 되어있어야 접근가능.
				.and()
			.formLogin()
				.loginPage("/account/login") // 접근 권한 없는 페이지에 접근하면 자동으로 /login 페이지로 리다이렉션시킴. 거기서 로그인 성공하면 권한 없던 페이지에 다시 이동.
				.permitAll() // 권한 없는 사용자도 /login 페이지에는 접근 가능하게끔 함.
				.and()
			.logout()
				.permitAll(); // 로그 아웃 또한 권한 없는 누구나 가능.
	}
	
	// 스프링에서 인증 처리를 할 때 비밀번호를 알아서 암호화 하도록 설정
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .passwordEncoder(passwordEncoder())
	      // 인증 처리
	      .usersByUsernameQuery("select userid, password "
	        + "from user "
	        + "where userid = ?"); // ? 파라미터에는 알아서 username이 들어감.
	      // 권한 처리
//	      .authoritiesByUsernameQuery("select email,authority "
//	        + "from Roles "
//	        + "where email = ?");
	}
	
	// 평문을 암호화 해주는 빈 객체 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}