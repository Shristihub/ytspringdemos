package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.greetings.GreetingsImpl;
import com.example.greetings.IGreetings;
import com.example.trial.Backend;
import com.example.trial.CloudComputing;
import com.example.trial.Frontend;
import com.example.trial.ICourse;

@Configuration
public class AppConfig {

	//bean definition- method annotated with @Bean
	// method name is the spring bean name
	
	@Bean
	IGreetings greeter(){
		return new GreetingsImpl();
	}
	@Bean
	ICourse backend(){
		return new Backend();
	}
	@Bean
	@Primary
	ICourse frontend(){
		return new Frontend();
	}
	
	@Bean
	ICourse cloudComputing(){
		return new CloudComputing();
	}
	
	
	
	
	
	
	
	
}
