package com.pensionmanagement.authentication.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/**").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.anyRequest().permitAll();
	}

}
