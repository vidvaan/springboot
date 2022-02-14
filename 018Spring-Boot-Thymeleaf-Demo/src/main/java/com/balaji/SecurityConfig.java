package com.balaji;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;

	

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/reg","/saveUser").permitAll() // #4
	        .anyRequest().authenticated() // 7
	        .and()
	    .formLogin();  // #8
	        
	  }
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("balaji").password("{noop}balaji1234").roles("USER");
		// auth.inMemoryAuthentication().withUser("suresh").password("{noop}suresh1234").roles("ADMIN");

		
		auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder())
		.dataSource(dataSource)
		.usersByUsernameQuery("select email, password, enable from users where email=?")
		.authoritiesByUsernameQuery("select email, role from users where email=?");
		
	}

}
