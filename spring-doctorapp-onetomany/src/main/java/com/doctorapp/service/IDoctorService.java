package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import com.doctorapp.model.DoctorDto;
import com.doctorapp.model.IDoctorInfo;

public interface IDoctorService {

	List<DoctorDto> getAllDoctors(String speciality, LocalTime availabilty);
	// queries for fetching availabilty
	// projection
	List<IDoctorInfo> getByAvailability(String doctorname);
}
