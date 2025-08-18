package com.example.classroom_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.repository.ClassroomRepository;

@Service
public class ClassroomService {
	
	
	 @Autowired
	    private ClassroomRepository classroomRepository;
	 
	 public List<Classroom> getAllClassrooms() {
	        return classroomRepository.findAll();
	    }
	    public Classroom saveClassroom(Classroom classroom) {
	        return classroomRepository.save(classroom);
	    }
	    public void deleteClassroom(Long id) {
			// TODO Auto-generated method stub
			classroomRepository.deleteById(id);
		}
	    public Classroom getClassroomById(Long id)  {
			// TODO Auto-generated method stub
			Optional<Classroom> clas = classroomRepository.findById(id);
			if(clas.isPresent())
				return classroomRepository.findById(id).get();
			else
				return null;
			//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
}
