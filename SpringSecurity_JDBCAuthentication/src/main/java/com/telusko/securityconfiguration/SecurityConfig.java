package com.telusko.securityconfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;


	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	    
	        auth.jdbcAuthentication()
	            .passwordEncoder(new BCryptPasswordEncoder())
	            .dataSource(dataSource)
	            .usersByUsernameQuery("select username,password,enabled from users where username=?")
	            .authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	   
	}

	
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		//The order of the request matchers is important:
		//First we protected /api/user/**
		//Then we protected /api/admin/**
		//Then we allow public access to /api
		//All the rest is denied
		http.authorizeHttpRequests((authz) -> authz
						.requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole("USER","ADMIN")
						.requestMatchers(HttpMethod.GET, "/api/admin/**").hasRole("ADMIN")
						.requestMatchers("/api").permitAll()
						.requestMatchers("/api/*").permitAll()
						.anyRequest().authenticated())
				.formLogin(withDefaults())
				.csrf(CsrfConfigurer::disable)
				.cors(CorsConfigurer::disable);
		return http.build();
	}
}
