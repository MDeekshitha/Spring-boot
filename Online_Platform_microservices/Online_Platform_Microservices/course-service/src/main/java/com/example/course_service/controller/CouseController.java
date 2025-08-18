package com.example.course_service.controller;

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

import com.example.course_service.dto.CourseWithTeacher;
import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;	
	

@RestController
@RequestMapping("/api/courses")
	public class CouseController {
	@Autowired
	CourseService courseService;


	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses(); 
		}

//	@GetMapping("/{id}")
//	public Optional<Course> getCourseById(@PathVariable Long id) {
//		return courseService.getCourseById(id); 
//		}

	@PostMapping
	public Course createCourse(@RequestBody Course course) { 
		return courseService.createCourse(course); 
		}
	
	@GetMapping("/{id}/withteacher")
    public CourseWithTeacher getCourseWithTeacher(@PathVariable Long id) {
        return courseService.getCourseWithTeacher(id);
    }
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
//		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
		System.out.println(" inside getCourseById");
		Course assessment = courseService.getCourseById(id);
		if (assessment == null) {
			// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return new ResponseEntity<Course>(assessment, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable Long id) {
		Course existingCourse = courseService.getCourseById(id);
		existingCourse.setName(course.getName());
		existingCourse.setTeacherId(course.getTeacherId());
		existingCourse.setDescription(course.getDescription());

		Course result = courseService.saveCourse(existingCourse);

		return result;
	}
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return "Course deleted with this " + id;
	}
}

