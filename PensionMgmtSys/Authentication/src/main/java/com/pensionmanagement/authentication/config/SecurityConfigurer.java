package com.pensionmanagement.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pensionmanagement.authentication.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/**").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.anyRequest().permitAll();
	}
//
//	@Autowired
//	MyUserDetailsService userDetailsService;
//	
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
////		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ configure");
////		super.configure(auth);
////		auth.userDetailsService(userDetailsService);
//	}
//
//	/**
//	 *Provides authorization
//	 *@param HttpSecurity
//	 *
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ configure");
//
////  		http.csrf().disable()
////		.authorizeRequests().antMatchers("/auth/**","/login","/validate").permitAll()
////		.anyRequest().authenticated()
////		.and().exceptionHandling().and().sessionManagement()
////		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		System.out.println();
//		return null;
////		return super.authenticationManagerBean();
//	}
//	
//
//	/**
//	 *This method is used to configure web security
//	 *For example to ignore certain requests.
//	 *@param WebSecurity
//	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		System.out.println();
//
//		web.ignoring().antMatchers("/auth/login","/h2-console/**","/v2/api-docs","/configuration/ui",
//				"/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**","/auth/swagger");
//	}
//	
//


}
