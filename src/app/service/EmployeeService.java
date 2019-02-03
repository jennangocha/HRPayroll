package app.service;

import java.util.List;
import java.util.stream.Collectors;

import app.domain.Employee;
import app.repository.DataAccessImpl;
import app.repository.IDataAccess;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	
	private IDataAccess<String, Employee> dataAccess = new DataAccessImpl<String, Employee>();
	
	private EmployeeService() {}
	
	public static EmployeeService getInstance() { 
		return instance; 
	}
	
	public void addNewEmployee(Employee emp) {
		 dataAccess.add(emp.getEmpCode(), emp);
	}
	
	public Employee getEmployeeById(String employeeCode) {
		return dataAccess.get(employeeCode);
	}
	
	public List<Employee> getAllEmployee(){
		return dataAccess.getAll();
	}
	
	public List<Employee> getAllEmployee(String Department,String Branch,String query){
		
		System.out.println("All employee in db count: "+ getAllEmployee().size());
		 
		List<Employee> list=getAllEmployee()
				.stream()
				.filter(x->x.getFirstName().toUpperCase().contains(query.toUpperCase()) || x.getLastName().toUpperCase().contains(query.toUpperCase()) || x.getEmpCode().toUpperCase().contains(query.toUpperCase()))
				.collect(Collectors.toList());
		 
		if(Department=="" && Branch=="")
			return list;
		
		if(Department!="" )
		list=list.stream()
				.filter(x->x.getDepartment().getDepartmentName().toUpperCase().contains(Department.toUpperCase()) || x.getDepartment().getDepartmentCode().toUpperCase().contains(Department.toUpperCase()))
				.collect(Collectors.toList());
		
		if(Branch=="")
			return list;
	 
		return list=list.stream()
				.filter(x->x.getBranch().getBranchName().toUpperCase().contains(Branch.toUpperCase()) || x.getBranch().getBranchCode().toUpperCase().contains(Branch.toUpperCase()))
				.collect(Collectors.toList());
		
	}
}
