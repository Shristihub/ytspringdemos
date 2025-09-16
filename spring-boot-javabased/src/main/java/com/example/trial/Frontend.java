package com.example.trial;

import java.util.Arrays;
import java.util.List;

public class Frontend implements ICourse{

	@Override
	public List<String> showCourses() {
		return Arrays.asList("HTML","CSS","javascript");
	}

}
