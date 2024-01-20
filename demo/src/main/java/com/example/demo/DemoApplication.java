package com.example.demo;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	This will use an in-memory user details manager for the sake of simplicity
	Users are:
		user/user -> can access /api/user and has the USER role
		admin/admin -> can access /api/admin and has the USER and ADMIN ROLE
	 */
	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		//The order of the request matchers is important:
		//First we protected /api/user/**
		//Then we protected /api/admin/**
		//Then we allow public access to /api
		//All the rest is denied
		http.authorizeHttpRequests((authz) -> authz
						.requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole("USER")
						.requestMatchers(HttpMethod.GET, "/api/admin/**").hasAnyRole("ADMIN")
						.requestMatchers("/api").permitAll()
						.requestMatchers("/api/*").permitAll()
						.anyRequest().authenticated())
				.formLogin(withDefaults())

				.csrf(CsrfConfigurer::disable);
		return http.build();
	}

}
