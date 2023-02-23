package com.had.selfhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.had.selfhelp.dao.PatientRepository;
import com.had.selfhelp.dao.QuestionnaireRepo;
import com.had.selfhelp.dao.Questionnaire_Response_Repo;
import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Questionnaire;
import com.had.selfhelp.entity.Questionnaire_response;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	private Questionnaire_Response_Repo responseRepository;
	private QuestionnaireRepo questionRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepository, Questionnaire_Response_Repo theQuestionnaire_Response_Repo, QuestionnaireRepo theQuestionnaireRepo) {
		patientRepository = thePatientRepository;
		responseRepository = theQuestionnaire_Response_Repo;
		questionRepository = theQuestionnaireRepo;
	}
	
	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);
	}

	@Override
	public void saveResponses(List<Questionnaire_response> patientResponse, int patient_id) {
		Patient thePatient = patientRepository.getReferenceById(patient_id);
		for(Questionnaire_response res : patientResponse) {
			res.setPatient(thePatient);
			responseRepository.save(res);
		}
	}

	@Override
	public List<Questionnaire> getQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public List<Questionnaire_response> getResponses(int patientId) {
		return responseRepository.findByPatient(patientRepository.getReferenceById(patientId));
	}

}
