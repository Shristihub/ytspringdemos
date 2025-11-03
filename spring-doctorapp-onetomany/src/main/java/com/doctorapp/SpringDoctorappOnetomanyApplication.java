package com.doctorapp;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.AddressDto;
import com.doctorapp.model.DoctorDto;
import com.doctorapp.model.HospitalDto;
import com.doctorapp.model.HospitalType;
import com.doctorapp.model.Speciality;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.IHospitalService;

@SpringBootApplication
public class SpringDoctorappOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappOnetomanyApplication.class, args);
	}
	@Autowired
	private IHospitalService hospitalService;
	@Autowired
	private IDoctorService doctorService;
	@Override
	public void run(String... args) throws Exception {
//		AddressDto address1 = new AddressDto(null,"Alwarpet","Chennai","TN");
//		
//		List<LocalTime> availability  = 
//			Arrays.asList(LocalTime.of(14,0),LocalTime.of(15, 0),LocalTime.of(16, 0));
//		DoctorDto doctor1 = 
//		 new DoctorDto(null,"Mohan","mohan@gmail.com",1800,20,Speciality.INTERNAL.getSpeciality(),address1,availability);
//		AddressDto address2 = new AddressDto(null,"Adyar","Chennai","TN");
//		DoctorDto doctor2 = 
//				 new DoctorDto(null,"Pornima","pornima@gmail.com",800,10,Speciality.PHYSICIAN.getSpeciality(),address2,availability);
//		AddressDto address3 = new AddressDto(null,"Mylapore","Chennai","TN");
//		List<LocalTime> availability3  = 
//				Arrays.asList(LocalTime.of(17,0),LocalTime.of(18, 0),LocalTime.of(19, 0)) ;
//		DoctorDto doctor3 = 
//				 new DoctorDto(null,"Ravi","ravi@gmail.com",800,12,Speciality.INTERNAL.getSpeciality(),address3,availability3);
//						
//		
//		Set<DoctorDto> doctors = new HashSet<>(Arrays.asList(doctor1,doctor2,doctor3));
//		HospitalDto hospital =  new HospitalDto(null, "Mohans Hospital",HospitalType.dia.getHospitalType(), "Chennai",doctors );
//		hospitalService.addHospital(hospital);
		
		AddressDto address1 = new AddressDto(null,"Adyar","Chennai","TN");
		
		List<LocalTime> availability  = 
			Arrays.asList(LocalTime.of(14,0),LocalTime.of(15, 0),LocalTime.of(16, 0));
		DoctorDto doctor1 = 
		 new DoctorDto(null,"Kumaran","kumu@gmail.com",1800,20,Speciality.NEURO.getSpeciality(),address1,availability);
		AddressDto address2 = new AddressDto(null,"Adyar","Chennai","TN");
		DoctorDto doctor2 = 
				 new DoctorDto(null,"Harini","harini@gmail.com",800,10,Speciality.PHYSICIAN.getSpeciality(),address2,availability);
		AddressDto address3 = new AddressDto(null,"Alwarpet","Chennai","TN");
		List<LocalTime> availability3  = 
				Arrays.asList(LocalTime.of(17,0),LocalTime.of(18, 0),LocalTime.of(19, 0)) ;
		DoctorDto doctor3 = 
				 new DoctorDto(null,"Mridhu","mridhu@gmail.com",800,12,Speciality.INTERNAL.getSpeciality(),address3,availability3);
						
		
		Set<DoctorDto> doctors = new HashSet<>(Arrays.asList(doctor1,doctor2,doctor3));
		HospitalDto hospital =  new HospitalDto(null, "Vijaya Hospital",HospitalType.child.getHospitalType(), "Chennai",doctors );
//		hospitalService.addHospital(hospital);
		
		hospitalService.getAll().forEach(System.out::println);
		//projections
		hospitalService.getByHospitalType("CHILDREN\'S HOSPITAL").forEach(System.out::println);
		
		System.out.println();
		//projections
		doctorService.getAllDoctors("General Physician", LocalTime.of(16, 0))
		.forEach(System.out::println);
		System.out.println();
		doctorService.getByAvailability("Mridhu").forEach(System.out::println);
		
	}

}












