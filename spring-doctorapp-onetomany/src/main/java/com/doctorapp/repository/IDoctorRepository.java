package com.doctorapp.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Hospital;
import com.doctorapp.model.IDoctorInfo;

public interface IDoctorRepository extends JpaRepository<Hospital, Integer>{

	@Query("""
			from Doctor d join d.availability a where d.speciality=?1 and
			a=?2
			""")
	List<Doctor> findAllDoctors(String speciality, LocalTime availabilty);
	
	@Query("""
			select distinct a from Doctor d join d.availability a
			where d.doctorName=?1
			""")
	List<IDoctorInfo> findByAvailability(String doctorname);
}




