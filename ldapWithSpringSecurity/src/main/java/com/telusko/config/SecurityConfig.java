package com.telusko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	
	}
	
	@Bean
	public AuthenticationManager authenticationManager(BaseLdapPathContextSource source) {
		LdapBindAuthenticationManagerFactory factory=new LdapBindAuthenticationManagerFactory(source);
		factory.setUserDnPatterns("cn={0}");
		return factory.createAuthenticationManager();
	}
}
