/**
 * 
 */
package app.business.abstractFactory;

import java.time.LocalDate;
import app.domain.Employee;

/**
 * @author luungochabui
 *
 */
public interface EmployeeFactory {
	public Employee createEmployee(String jobType,String empCode, String firstName, String lastName,  String phone, String email,
			LocalDate dateOfBirth, String ssn, String position, LocalDate joinDate, LocalDate resignDate, Boolean isRegign,
			String street, String city, String zipcode, String state, String country, String department, String branch, Double salary);
}
