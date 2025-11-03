package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDetailsDto;
import com.doctorapp.model.HospitalDto;
import com.doctorapp.repository.IHospitalRepository;
@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	private IHospitalRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public void addHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		repository.save(hospital);
	}

	@Override
	public void updateHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		repository.save(hospital);
	}

	@Override
	public void deleteHospital(int hospitalId) {
		repository.deleteById(hospitalId);

	}

	@Override
	public HospitalDto getById(int hospitalId) {
		Optional<Hospital> opt =  repository.findById(hospitalId);
		if(opt.isEmpty()) {
			throw new RuntimeException("invalid id");
		}
		Hospital hospital = opt.get();
		return mapper.map(hospital, HospitalDto.class);
	}

	@Override
	public List<HospitalDto> getAll() {
		List<Hospital> hospitals = repository.findAll();
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getBySpecialityType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getByDoctorSpeciality(String speciality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getBySpecialityExp(String speciality, int experience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getBySpecialityFees(String speciality, double fees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getByDoctorLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getByDoctorAvailability(LocalTime availability) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDetailsDto> getByHospitalType(String type) {
		List<HospitalDetailsDto> hospitals = repository.findByType(type);
		return hospitals;
	}

}
