package app.data;

import java.util.ArrayList;
import java.util.List;

import app.domain.Department;

public class DepartmentData {
	
	public static List<Department> loadData() {
		Department dept1 = new Department("1", "Financial");
		Department dept2 = new Department("2", "Accounting");
		Department dept3 = new Department("3", "Human Resources");
		Department dept4 = new Department("4", "Administration");
		Department dept5 = new Department ("5", "Development");
		Department dept6 = new Department ("6", "Sales");
		List<Department> listOfDepartment = new ArrayList<Department>();
		listOfDepartment.add(dept1);
		listOfDepartment.add(dept2);
		listOfDepartment.add(dept3);
		listOfDepartment.add(dept4);
		listOfDepartment.add(dept5);
		listOfDepartment.add(dept6);
		return listOfDepartment;
	}
}
