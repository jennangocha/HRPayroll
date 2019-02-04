package app.service;

import java.util.List;

import app.domain.Employee;

public interface IEmployeeService {
	
	public void addNewEmployee(Employee emp);
	public Employee getEmployeeById(String employeeCode);
	public List<Employee> getAllEmployee();
	public List<Employee> getAllEmployee(String Department,String Branch,String query);
}
