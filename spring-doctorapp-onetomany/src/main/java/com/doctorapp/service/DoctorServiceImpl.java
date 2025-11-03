package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.DoctorDto;
import com.doctorapp.model.IDoctorInfo;
import com.doctorapp.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	@Autowired
	private IDoctorRepository doctorRepository;
	@Autowired
    private ModelMapper mapper;
	@Override
	public List<DoctorDto> getAllDoctors(String speciality, LocalTime availabilty) {
    	List<Doctor> doctors =  doctorRepository.findAllDoctors(speciality, availabilty);
    	return doctors.stream().map(doctor-> mapper.map(doctor, DoctorDto.class)).toList();
	}

	@Override
	public List<IDoctorInfo> getByAvailability(String doctorname) {
		return doctorRepository.findByAvailability(doctorname);
	}

}
