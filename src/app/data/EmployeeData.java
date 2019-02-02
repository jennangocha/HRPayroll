package app.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import app.domain.Address;
import app.domain.Branch;
import app.domain.Department;
import app.domain.Employee;
import app.domain.HourlyEmployee;
import app.domain.SalariedEmployee;
import app.service.EmployeeService;

public class EmployeeData {
	public static void load() {
		EmployeeService empService = EmployeeService.getInstance();
		Employee emp1 = new SalariedEmployee("EMP111", "Employee1", "LN", "1234567", "1213546576", "employee1@gmail.com",
				LocalDate.of(1980, 1, 1), "123456789", "Developer", LocalDate.of(2018, 1, 1), null, false, true,
				new Address(), new Department("1", "Development"), new Branch());
		Employee emp2 = new HourlyEmployee("EMP112", "Employee2", "LN2", "1234567", "1213546576", "employee2@gmail.com",
				LocalDate.of(1980, 1, 1), "123456789", "Developer", LocalDate.of(2018, 1, 1), null, false, false,
				new Address(), new Department("1", "Development"), new Branch());
		empService.addNewUser(emp1);
		empService.addNewUser(emp2);

	}
}
