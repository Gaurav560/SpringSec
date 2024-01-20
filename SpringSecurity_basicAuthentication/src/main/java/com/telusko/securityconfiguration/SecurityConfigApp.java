package com.telusko.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	static {
		System.out.println("SecurityConfigApp.class is loading.");
	}
	
	public SecurityConfigApp() {
		System.out.println("SecurityConfigApp.SecurityConfigApp()");
	}
	
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfigApp.userDefinedFilter()");
		
		http.authorizeHttpRequests(request ->request
				.requestMatchers("/login","/bank/","/bank/about","/bank/transfer")
				.permitAll()
				.anyRequest()
				.authenticated())
		        .formLogin(Customizer.withDefaults()
	            );
		
		
		return http.build();
	}
}
