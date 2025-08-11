package com.demo.client;

import java.util.List;
import java.util.Scanner;

import com.demo.exception.DepartmentException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.model.Department;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;

public class ClientApp {
	private static Scanner sc = new Scanner(System.in);
	private static DepartmentService service = new DepartmentServiceImpl();
	public static void main(String[] args) {
		System.out.println("1. Add Department: ");
		System.out.println("2. Get Department by Id: ");
		System.out.println("3. Get all Deaprtments: ");
		System.out.println("4. Update Department");
		System.out.println("5. Delete Department By Id:");
		System.out.println("6. Exit");
		int choice= sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			addDepartment();
			break;
		case 2: 
			searchById();
			break;
		case 3:
			displayDepartments();
			break;
		case 4: 
			updateDepartment();
			break;
		case 5:
			deleteById();
			break;
		case 6:
			System.exit(choice);
			break;
		default:
			System.out.println("Invalid Input.");
			break;
		}	
	}
	public static void addDepartment() {
		System.out.println("Enter Department Id:");
		Department dept = new Department();
		dept.setDeptId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter Department Name:");
		dept.setDeptName(sc.nextLine());
		System.out.println("Enter department Loaction:");
		dept.setDeptLocation(sc.nextLine());
		service.addDepartment(dept);
		System.out.println("Department with id " +dept.getDeptId()+" added successfully");
	}
	
	public static void searchById() {
		System.out.println("Enter Department Id:");
		Department dept = new Department();
		dept.setDeptId(sc.nextInt());
		try {
	        service.searchById(dept);
	        System.out.println("Department ID: " + dept.getDeptId());
	        System.out.println("Department Name: " + dept.getDeptName());
	        System.out.println("Department Location: " + dept.getDeptLocation());
	    } catch (DepartmentNotFoundException e) {
	        System.out.println(e.getMessage());
	    } catch (DepartmentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	public static void displayDepartments() {
		List<Department> departments = service.getDepartment();
		for(Department department: departments) {
			System.out.println(department);
		}
	}
	public static void updateDepartment() {
		System.out.println("Enter Department Id:");
		Department dept = new Department();
		dept.setDeptId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter Department Name:");
		dept.setDeptName(sc.nextLine());
		System.out.println("Enter department Loaction:");
		dept.setDeptLocation(sc.nextLine());
		try {
	        int updated = service.updateDepartment(dept);
	        if (updated > 0) {
	            System.out.println("Department with ID " + dept.getDeptId() + " updated successfully.");
	        } else {
	            System.out.println("No department found with ID " + dept.getDeptId());
	        }
	    } catch (DepartmentException e) {
	        System.out.println("Update failed: " + e.getMessage());
	    }
		
	}
	public static void deleteById() {
		System.out.println("Enter Department Id:");
		Department dept = new Department();
		dept.setDeptId(sc.nextInt());
		service.deleteById(dept);
		System.out.println("Department by id" +dept.getDeptId()+" Deleted successfully");
	}
}
