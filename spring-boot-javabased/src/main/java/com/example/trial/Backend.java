package com.example.trial;

import java.util.Arrays;
import java.util.List;

public class Backend implements ICourse{

	@Override
	public List<String> showCourses() {
		return Arrays.asList("spring","java","microservices");
	}

}
