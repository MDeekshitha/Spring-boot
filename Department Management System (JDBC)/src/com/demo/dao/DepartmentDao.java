package com.demo.dao;

import java.util.List;

import com.demo.model.Department;

public interface DepartmentDao {
	List<Department> getDepartment();
	int addDepartment(Department department);
	int updateDepartment(Department department);
	int deleteById(Department department);
	void searchById(Department department);
}
