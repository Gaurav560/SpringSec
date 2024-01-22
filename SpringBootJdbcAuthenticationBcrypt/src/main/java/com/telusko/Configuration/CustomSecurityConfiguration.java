package com.telusko.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration  {

	
	  @Autowired
	  private Environment env;
	 

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                .csrf((csrf) -> csrf.disable());
            http.
                cors( (cors) ->  cors.disable());    

            http
                .sessionManagement((sessionManagement) -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );


            http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/items/**").hasAnyRole("ADMIN", "USER")
           

                .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("ADMIN" )


                .requestMatchers(HttpMethod.GET, "/freeitems/**").permitAll()

                .anyRequest().authenticated()

            )
          
          .httpBasic(httpConf -> httpConf.realmName(env.getProperty("app.realm"))

         
                );

            return http.build();
        } 




        @Bean
        public DaoAuthenticationProvider authenticationProvider(JdbcDaoImpl userDetailsService, PasswordEncoder encoder){
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            provider.setPasswordEncoder(encoder);
            return provider;    
        }


        @Bean
        public JdbcDaoImpl userDetailsService(DataSource dataSource) {
            JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
            if (dataSource != null) {
                jdbcDaoImpl.setDataSource(dataSource);
            } else {
                throw new RuntimeException("DataSource is null!");
            }
            return jdbcDaoImpl;
        } 
        

        @Bean
        public PasswordEncoder encoder() {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder;
        }

}

