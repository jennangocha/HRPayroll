package app.business;

import java.util.ArrayList;
import java.util.List;

import app.domain.Employee;
import app.service.EmployeeServiceImpl;
import app.service.IEmployeeService;

public class EmployeeTableDataLoader {
	
	private static IEmployeeService empService = EmployeeServiceImpl.getInstance();

	public EmployeeTableDataLoader() {
	}
	
	public static List<EmployeeView> getAllEmployee() {
		List<Employee> list = empService.getAllEmployee();
		List<EmployeeView> l = new ArrayList<EmployeeView>();
		EmployeeView eView;
		for(Employee e : list) {
				 eView = new EmployeeView(e.getEmpCode(), e.getFirstName(),e.getAddress().getStreet(), e.getPhone(), e.getBasicSalary().toString(), e.getEmail(), e.getDepartment().getDepartmentName(), e.getBranch().getBranchName());
			l.add(eView);
		}
		return l;
		
	}

}
