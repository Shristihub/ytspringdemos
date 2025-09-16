package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.DbConfig;
import com.example.service.INotification;

@SpringBootApplication   
public class SpringBootConfigdemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootConfigdemoApplication.class, args);
	}
	
	@Autowired
	@Qualifier("smsNotification")
	private INotification notification;
	
	@Autowired
	private DbConfig dbConfig;

	@Override
	public void run(String... args) throws Exception {
		notification.sendNotification();
		dbConfig.connectDB();
	}
}







  

