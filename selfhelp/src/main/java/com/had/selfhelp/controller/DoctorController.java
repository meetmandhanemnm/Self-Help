package com.had.selfhelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.had.selfhelp.entity.Doctor;
import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private DoctorService doctorService;
	
	@Autowired
	public DoctorController(DoctorService theDoctorService) {
		doctorService = theDoctorService;
	}
	
	@PostMapping("/")
	public Doctor addDoctor(@RequestBody Doctor theDoctor) {
		theDoctor.setDoctor_id(0);
		doctorService.save(theDoctor);
		return theDoctor;
	}
	
	@GetMapping("/patient/{doctorId}")
	public List<Patient> getPatientList(@PathVariable(name = "doctorId") int doctorId) {
		return doctorService.findPatients(doctorId);
	}
}
