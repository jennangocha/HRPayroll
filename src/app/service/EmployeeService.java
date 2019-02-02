package app.service;

import app.dao.DataAccessImpl;
import app.dao.IDataAccess;
import app.domain.Employee;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	
	private IDataAccess<String, Employee> dataAccess = new DataAccessImpl<String, Employee>();
	
	private EmployeeService() {}
	
	public static EmployeeService getInstance() { 
		return instance; 
	}
	
	public Employee addNewUser(Employee emp) {
		String employeeName = emp.getFirstName() + emp.getLastName();
		return dataAccess.add(employeeName, emp);
	}
	
	public Employee getEmployeeById(String employeeCode) {
		return dataAccess.get(employeeCode);
	}
}
