package com.had.selfhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.had.selfhelp.dao.DoctorRepository;
import com.had.selfhelp.entity.Doctor;
import com.had.selfhelp.entity.Patient;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
		doctorRepository = theDoctorRepository;
	}
	
	@Override
	public void save(Doctor theDoctor) {
		doctorRepository.save(theDoctor);
	}

	@Override
	public Doctor findById(int theId) {
		return doctorRepository.getReferenceById(theId);
	}

	@Override
	public List<Patient> findPatients(int theId) {
		Doctor theDoctor = doctorRepository.getReferenceById(theId);
		return theDoctor.getPatients();
	}

}