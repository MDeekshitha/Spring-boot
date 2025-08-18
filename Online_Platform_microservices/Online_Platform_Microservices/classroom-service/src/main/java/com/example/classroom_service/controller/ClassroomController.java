package com.example.classroom_service.controller;

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

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
	
	 @Autowired
	    private ClassroomService classroomService;

	  @GetMapping
	    public List<Classroom> getAllClassrooms() {
	        return classroomService.getAllClassrooms();
	    }

	  @GetMapping("/{id}")
		public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
//			String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//			System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
			System.out.println(" inside getAssessmentById");
			Classroom classroom = classroomService.getClassroomById(id);
			if (classroom == null) {
				// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
			}
			return new ResponseEntity<Classroom>(classroom, HttpStatus.OK);
		}
	    
	    @PostMapping
	    public Classroom createClassroom(@RequestBody Classroom classroom) {
	        return classroomService.saveClassroom(classroom);
	    }
	    @PutMapping("/{id}")
		public Classroom updateClassroom(@RequestBody Classroom classroom, @PathVariable Long id) {
	    	Classroom existingClassroom = classroomService.getClassroomById(id);
			existingClassroom.setCourseName(classroom.getCourseName());
			existingClassroom.setCourseId(classroom.getCourseId());
			existingClassroom.setSchedule(classroom.getSchedule());
			existingClassroom.setTeacherId(classroom.getTeacherId());

			Classroom result = classroomService.saveClassroom(existingClassroom);

			return result;
		}
		@DeleteMapping("/{id}")
		public String deleteClassroom(@PathVariable Long id) {
			classroomService.deleteClassroom(id);
			return "Classroom deleted with this " + id;
		}
}
