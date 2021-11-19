package com.lostarktodo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lostarktodo.security.AccountAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	// 이 파일들은 권한이 없어도 접근할 수 있어야함.
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/plugin/**", "/css/**", "/icon/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // rest 방식 post, put, patch 등이 403 error로 막히길래 등록해둔 설정
			.authorizeRequests()
				.antMatchers("/account/login", "/account/register", "/hello", "/test").permitAll() // 이 경로들은 권한이 없어도 모두가 접근할 수 있게끔 함.
				.anyRequest().authenticated() // 그 외의 페이지는 인증(로그인)이 되어있어야 접근가능.
				.and()
			.formLogin()
				.loginPage("/account/login") // 접근 권한 없는 페이지에 접근하면 자동으로 /login 페이지로 리다이렉션시킴. 거기서 로그인 성공하면 권한 없던 페이지에 다시 이동.
                .successForwardUrl("/account/login/success") // 로그인 성공시 이 URL에 POST 요청을 하게됨.
                .failureForwardUrl("/account/login/failure") // 로그인 실패 URL을 설정함
				.permitAll() // 누구에게나 접근 가능하게끔 함.
				.and()
			.logout()
				.logoutSuccessUrl("/account/login") // 로그아웃 성공시 URL
				.permitAll(); // 로그 아웃 또한 권한 없는 누구나 가능.
	}
	
	// 실제로 인증이 일어나는 provider를 커스터마이징한 AuthenticationProvider로 등록시켜주는 설정. 해당 설정을통해 인증과정을 직접 구현해줄 수 있음.
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(accountAuthenticationProvider());
    }
	
	// 평문을 암호화 해주는 빈 객체 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	// 인증 로직을 담은 provider 빈 객체 등록
    @Bean
    public AuthenticationProvider accountAuthenticationProvider() {
        return new AccountAuthenticationProvider();
    }
}