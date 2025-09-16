package com.example.greetings;

import org.springframework.stereotype.Component;

@Component
public class GreetingsImpl implements IGreetings{

	@Override
	public String welcomeUser(String name) {
		return "Welcome "+name;
	}

}
