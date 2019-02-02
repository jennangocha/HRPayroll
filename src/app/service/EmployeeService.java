package app.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Employee> getAllEmployee(){
		return dataAccess.getAll();
	}
	
	public List<Employee> getAllEmployee(String Department,String Branch,String query){
		
		System.out.println("getall"+ getAllEmployee().size());
		
		List<Employee> list=getAllEmployee()
				.stream()
				.filter(x->x.getFirstName().contains(query) || x.getLastName().contains(query) || x.getEmpCode().contains(query))
				.collect(Collectors.toList());
		
		System.out.println("list count" + list.size());
		
		if(Department=="" && Branch=="")
			return list;
		
		if(Department!="" )
		list=list.stream()
				.filter(x->x.getDepartment().getDepartmentName().contains(Department) || x.getDepartment().getDepartmentCode().contains(Department))
				.collect(Collectors.toList());
		
		if(Branch=="")
			return list;
		
		return list=list.stream()
				.filter(x->x.getBranch().getBranchName().contains(Branch) || x.getBranch().getBranchCode().contains(Branch))
				.collect(Collectors.toList());
		
	}
}
