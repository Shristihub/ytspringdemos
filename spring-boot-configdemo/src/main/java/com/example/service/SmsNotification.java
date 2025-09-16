package com.example.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "notification.sms")
public class SmsNotification implements INotification {
	
	private String sender;
	private long mobileNumber;
	private String message;
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void sendNotification() {
		System.out.println("Sender: "+sender);
		System.out.println("Mobile: "+mobileNumber);
		System.out.println("Message: "+message);

	}

}
