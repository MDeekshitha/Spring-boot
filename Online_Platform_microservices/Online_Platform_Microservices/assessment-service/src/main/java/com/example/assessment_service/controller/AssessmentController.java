package com.example.assessment_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.service.AssessmentService;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	@PostMapping
	 public Assessment submitAssignment(@RequestBody Assessment assignment) {
	 return assessmentService.submitAssessment(assignment);
	 }
	@GetMapping
	public List<Assessment> getAllAssessment() {
		return assessmentService.getAllAssessments();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Assessment> getAssessmentById(@PathVariable Long id) {
//		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
		System.out.println(" inside getAssessmentById");
		Assessment assessment = assessmentService.getAssessmentById(id);
		if (assessment == null) {
			// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return new ResponseEntity<Assessment>(assessment, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Assessment updateAssessment(@RequestBody Assessment assessment, @PathVariable Long id) {
		Assessment existingAssessment = assessmentService.getAssessmentById(id);
		existingAssessment.setStudentId(assessment.getStudentId());
		existingAssessment.setTitle(assessment.getTitle());
		existingAssessment.setDescription(assessment.getDescription());

		Assessment result = assessmentService.saveAssessment(existingAssessment);

		return result;
	}
	@DeleteMapping("/{id}")
	public String deleteAssessment(@PathVariable Long id) {
		assessmentService.deleteAssessment(id);
		return "Assessment deleted with this " + id;
	}
}
