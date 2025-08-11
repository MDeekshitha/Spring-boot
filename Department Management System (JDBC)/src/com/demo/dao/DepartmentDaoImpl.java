package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.DepartmentException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.model.Department;
import com.demo.util.DbUtil;

public class DepartmentDaoImpl implements DepartmentDao{
	private Connection con = DbUtil.getConnection();
	public List<Department> getDepartment() {
		List<Department> departments=new ArrayList<Department>();
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from department");
			while(rs.next()) {
				Department dept=new Department();
				dept.setDeptId(rs.getInt(1));
				dept.setDeptName(rs.getString(2));
				dept.setDeptLocation(rs.getString(3));
				departments.add(dept);
			}
			
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		
		return departments;
	}
	@Override
	public int addDepartment(Department department){
		int rowsAffected=0;
		try {
			PreparedStatement stat= con.prepareStatement("insert into department values(?,?,?)");
			stat.setInt(1,department.getDeptId());
			stat.setString(2, department.getDeptName());
			stat.setString(3, department.getDeptLocation());
			rowsAffected = stat.executeUpdate();
		}catch(SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		return rowsAffected;
	}
	@Override
	public int updateDepartment(Department department) {
	    int rowsUpdated = 0;
	    try {
	        PreparedStatement stat = con.prepareStatement("UPDATE department SET DeptName = ?, DeptLocation = ? WHERE DeptId = ?");
	        stat.setString(1, department.getDeptName());
	        stat.setString(2, department.getDeptLocation());
	        stat.setInt(3, department.getDeptId());
	        rowsUpdated = stat.executeUpdate();
	    } catch (SQLException e) {
	        throw new DepartmentException("Update failed: " + e.getMessage());
	    }
	    return rowsUpdated;
	}

	@Override
	public int deleteById(Department department)throws DepartmentNotFoundException{
		int rowDeleted=0;
		try {
			PreparedStatement stat= con.prepareStatement("Delete from department where DeptId=?");
			stat.setInt(1,department.getDeptId());
			rowDeleted=stat.executeUpdate();
		}catch(SQLException | DepartmentNotFoundException e) {
			throw new DepartmentException(e.getMessage());
		}
		return rowDeleted;
	}
	@Override
	public void searchById(Department department)throws DepartmentNotFoundException{
		try {
		 PreparedStatement ps = con.prepareStatement("SELECT DeptName,DeptLocation FROM department WHERE DeptId = ?");
	     ps.setInt(1, department.getDeptId());
	     ResultSet rs = ps.executeQuery();
	     if(rs.next()) {
//			department = new Department();
			department.setDeptName(rs.getString(2));
			department.setDeptLocation(rs.getString(3));
		}else {
			throw new DepartmentNotFoundException("Department with ID " + department.getDeptId() + " not found.");
		}
		} catch (SQLException | DepartmentNotFoundException e) {
			throw new DepartmentException(e.getMessage());
		}
	}
}
