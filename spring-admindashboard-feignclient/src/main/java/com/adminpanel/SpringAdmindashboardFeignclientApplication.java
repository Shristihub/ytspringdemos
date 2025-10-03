package com.adminpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringAdmindashboardFeignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdmindashboardFeignclientApplication.class, args);
	}

}
