package app.business.abstractFactory;

import java.time.LocalDate;
import app.domain.Address;
import app.domain.Branch;
import app.domain.CommissionedEmployee;
import app.domain.Department;
import app.domain.Employee;
import app.domain.HourlyEmployee;
import app.domain.JobType;
import app.domain.SalariedEmployee;
import app.service.AddressServiceImpl;
import app.service.BranchListServiceImpl;
import app.service.DepartmentListServiceImpl;
import app.service.IAddressService;
import app.service.IBranchListService;
import app.service.IDepartmentListService;

public class EmployeeFactoryImpl implements EmployeeFactory {

	private static EmployeeFactory empFactory = new EmployeeFactoryImpl();
	private IAddressService addressService = new AddressServiceImpl();
	private IDepartmentListService departmentService = new DepartmentListServiceImpl();
	private IBranchListService branchService = new BranchListServiceImpl();
	
	public EmployeeFactoryImpl() {
	}

	@Override
	public Employee createEmployee(String jobType, String empCode, String firstName, String lastName,
			String phone, String email, LocalDate dateOfBirth, String ssn, String position, LocalDate joinDate,
			LocalDate resignDate, Boolean isRegign, String street, String city, String zipcode, String state, String country, String departmentName, String branchName,
			Double salary) {
		
		Employee employee = null;
		Address address = addressService.createAddress(street, city, zipcode, state, country);
		Department department = departmentService.getDepartmentByName(departmentName);
		Branch branch = branchService.getBranchByName(branchName);
		
		if (jobType.equals(JobType.SALARIED_EMPLOYEE.getJobType())) {
			employee = new SalariedEmployee(empCode, firstName, lastName, zipcode, phone, email, dateOfBirth, ssn,
					position, joinDate, resignDate, isRegign, true, address, department, branch, salary);
		} else if (jobType.equals(JobType.COMMISSIONED_EMPLOYEE.getJobType())) {
			employee = new CommissionedEmployee(empCode, firstName, lastName, zipcode, phone, email, dateOfBirth, ssn,
					position, joinDate, resignDate, isRegign, false, address, department, branch, salary);
		} else if (jobType.equals(JobType.HOURLY_EMPLOYEE.getJobType())) {
			employee = new HourlyEmployee(empCode, firstName, lastName, zipcode, phone, email, dateOfBirth, ssn,
					position, joinDate, resignDate, isRegign, false, address, department, branch, salary);
		}

		return employee;
	}

	public static EmployeeFactory getFactory() {
		return empFactory;
	}

}
