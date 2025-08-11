package com.demo.service;

import java.util.List;

import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;
import com.demo.model.Department;

	public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao dao=new DepartmentDaoImpl();
	@Override
	public List<Department> getDepartment(){
		return dao.getDepartment();
	}
	@Override
	public int addDepartment(Department department) {
		return dao.addDepartment(department);
	}
	@Override
	public int updateDepartment(Department department) {
		return dao.updateDepartment(department);
	}
	@Override
	public int deleteById(Department department) {
		// TODO Auto-generated method stub
		return dao.deleteById(department);
	}
	@Override
	public void searchById(Department dept) {
		// TODO Auto-generated method stub
		
	}
}
