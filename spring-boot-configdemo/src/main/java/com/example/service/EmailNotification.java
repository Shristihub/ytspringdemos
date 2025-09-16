package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements INotification {
  
	@Value("${notification.email.username}")
	private String username;
	@Value("${notification.email.to}")
	private String to;
	@Value("${notification.email.subject}")
	private String subject;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public void sendNotification() {
		System.out.println("From: "+username);
		System.out.println("To: "+to);
		System.out.println("Subject: "+subject);
	}
	
	
	
}
