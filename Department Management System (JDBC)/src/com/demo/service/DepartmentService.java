package com.demo.service;

import java.util.List;

import com.demo.model.Department;

public interface DepartmentService {
	List<Department> getDepartment();
		int addDepartment(Department department);
		int updateDepartment(Department department);
		int deleteById(Department department);
		void searchById(Department dept);
}
