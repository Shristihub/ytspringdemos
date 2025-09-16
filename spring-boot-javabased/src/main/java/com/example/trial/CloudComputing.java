package com.example.trial;

import java.util.Arrays;
import java.util.List;

public class CloudComputing implements ICourse{

	@Override
	public List<String> showCourses() {
		return Arrays.asList("aws","gcp","azure");
	}

}
