package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.greetings.IGreetings;
import com.example.trial.ICourse;

@SpringBootApplication
public class SpringBootJavabasedApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavabasedApplication.class, args);
	}
	@Autowired
	@Qualifier("greeter")
	private IGreetings greetings;
	
	@Autowired
	@Qualifier("backend")
	private ICourse course;  // ICourse course = new Frontend();
	
	@Override
	public void run(String... args) throws Exception {
		String message = greetings.welcomeUser("Sri");
		System.out.println(message);
		
		course.showCourses().forEach(System.out::println);
	}

}
