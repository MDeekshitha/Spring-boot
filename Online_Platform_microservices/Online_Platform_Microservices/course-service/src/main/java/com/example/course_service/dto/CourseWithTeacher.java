package com.example.course_service.dto;

public class CourseWithTeacher {

	 private Long id;
	    private String name;
	    private String description;
	    private UserDTO teacher;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public UserDTO getTeacher() {
			return teacher;
		}
		public void setTeacher(UserDTO teacher) {
			this.teacher = teacher;
		}
	    
	    
}
