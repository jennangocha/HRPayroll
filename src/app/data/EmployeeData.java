package app.data;

import java.time.LocalDate;
import app.domain.Address;
import app.domain.Branch;
import app.domain.Department;
import app.domain.Employee;
import app.domain.HourlyEmployee;
import app.domain.SalariedEmployee;
import app.service.EmployeeServiceImpl;

public class EmployeeData {
	public static void load() {
		
		EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
		
		Employee emp1 = new SalariedEmployee("EMP111", "Employee1", "LN", "1234567", "1213546576", "employee1@gmail.com",
				LocalDate.of(1980, 1, 1), "123456789", "Developer", LocalDate.of(2018, 1, 1), null, false, true,
				new Address(), new Department("1", "Development"), new Branch("1", "Fairfield branch"), new Double(500000));
		Employee emp2 = new HourlyEmployee("EMP112", "Employee2", "LN2", "1234567", "1213546576", "employee2@gmail.com",
				LocalDate.of(1980, 1, 1), "123456789", "Developer", LocalDate.of(2018, 1, 1), null, false, false,
				new Address(), new Department("1", "Development"), new Branch("2", "Ottumwa brach"), new Double(200000));
		
		Employee emp3 = new HourlyEmployee("EMP113", "Employee3", "LN3", "1234567", "1213546576", "employee3@gmail.com",
				LocalDate.of(1980, 1, 1), "123456789", "Developer", LocalDate.of(2018, 1, 1), null, false, false,
				new Address(), new Department("1", "Development"), new Branch("2", "Ottumwa brach"), new Double(200000));
		
		
		empService.addNewEmployee(emp1);
		empService.addNewEmployee(emp2);
		empService.addNewEmployee(emp3);

	}
}
