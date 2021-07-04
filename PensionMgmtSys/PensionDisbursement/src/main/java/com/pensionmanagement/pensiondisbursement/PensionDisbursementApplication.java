package com.pensionmanagement.pensiondisbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
public class PensionDisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionDisbursementApplication.class, args);
	}



}
