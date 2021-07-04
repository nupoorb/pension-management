package com.pensionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.pensionmanagement.LocalRibbonClientConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableEurekaClient
@RibbonClient(name = "authorization-app", configuration = LocalRibbonClientConfiguration.class)
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}


}
