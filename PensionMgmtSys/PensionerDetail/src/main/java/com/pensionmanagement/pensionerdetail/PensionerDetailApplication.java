package com.pensionmanagement.pensionerdetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableFeignClients
public class PensionerDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailApplication.class, args);
	}

}
