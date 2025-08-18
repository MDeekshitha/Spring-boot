package com.example.assessment_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment_service.feign.NotificationClient;
import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.repository.AssessmentRepository;

@Service
public class AssessmentService {
	

    @Autowired
     AssessmentRepository assessmentRepository;

    @Autowired
    NotificationClient notificationClient;
    
    
    public Assessment submitAssessment(Assessment assessment) {
    	Assessment saved = assessmentRepository.save(assessment);
    	
    	String notificationMessage = "Assessment Submitted:" + assessment.getTitle() +","+assessment.getDescription();
    	notificationClient.sendNotification(notificationMessage);
    	
    	return saved;
    }
    public Assessment saveAssessment(Assessment assessment) {
		// TODO Auto-generated method stub
    	Assessment a =assessmentRepository.save(assessment);
		return a;
	}
	public List<Assessment> getAllAssessments() {
		// TODO Auto-generated method stub
		return assessmentRepository.findAll();
	}

	public Assessment getAssessmentById(Long id)  {
		// TODO Auto-generated method stub
		Optional<Assessment> assess = assessmentRepository.findById(id);
		if(assess.isPresent())
			return assessmentRepository.findById(id).get();
		else
			return null;
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
	}

	public void deleteAssessment(Long id) {
		// TODO Auto-generated method stub
		assessmentRepository.deleteById(id);
	}

}
