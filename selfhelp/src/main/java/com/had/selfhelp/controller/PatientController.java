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
import com.had.selfhelp.entity.Questionnaire;
import com.had.selfhelp.entity.Questionnaire_response;
import com.had.selfhelp.service.DoctorService;
import com.had.selfhelp.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private PatientService patientService;
	private DoctorService doctorService;
	
	@Autowired
	public PatientController(PatientService thePatientService,DoctorService theDoctorService) {
		patientService = thePatientService;
		doctorService = theDoctorService;
	}
	
	
	@PostMapping("/")
	public Patient addPatient(@RequestBody Patient thePatient) {
		thePatient.setPatient_id(0);
		Doctor theDoctor = doctorService.findById(1);
		thePatient.setDoctor(theDoctor);
		patientService.save(thePatient);
		return thePatient;
	}
	
	@PostMapping("/responses/{patientId}")
	public void addResponses(@RequestBody List<Questionnaire_response> response, @PathVariable(name = "patientId") int patient_id) {
		patientService.saveResponses(response, patient_id);
	}
	
	@GetMapping("/questions")
	public List<Questionnaire> getQuestions() {
		return patientService.getQuestions();
	}
	
	@GetMapping("/responses/{patientId}")
	public List<Questionnaire_response> getResponses(@PathVariable(name = "patientId") int patientId) {
		return patientService.getResponses(patientId);
	}
}
