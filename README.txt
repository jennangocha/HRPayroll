TEAM 1

PHYO LIN TUN (ID: 986702)

Responsible for developing "Generate Payslip" use case for Payroll framework.Design and develop Payslip data creation framework that is easy to extend by application developer. Find a most suitable design solution to solve frequent changes in payroll calculation strategy for different type of employee. Develop GUI and linked up with the framework to demonstrate extendibility. Delivered complete UML for "Generate Payslip" use case.

Participants (Design Pattern)
1.	Proxy (IPayslipGenerator, PayslipGeneratorProxy, PayslipGenerator)
	Point of access to the framework and generated the payslip data in hashmap format. 
	User validation and varifcation.
	
2.	Builder (IPayslipDataBuilder, PayslipDataBuilder, PayslipDataDirector)
	Responsible to build the generic Payslip data based on defined payslip calculation strategies for different employee type.
	Provide hook method for extension.

3.	Visitor (IEmployeePayslip, IPayslipVisitor, PayslipDataVisitor)
	To link different payslip calculation strategies with payslip data builder for different type of employee.

4.	Abstract factory (IPayrollCalculationStrategyFactory, PayrollCalStraFactoryCommEmp, PayrollCalStraFactorySalEmp, PayrollCalStraFactorySalEmp)
	Define collections of payslip calculation strategies for different employee type.

5.	Prototype (IPrototype, PayslipData)
	Create cloneable payslip data.

6.	Singleton (PayslipGenerator)
	Create thread safe payslip data generating engine.

7.	Strategy (IEarningStrategy, EarningStrategySalEmpBonus, IDeductionStrategy, DeductionStrategyLeaveEmp, IBasicPayStrategy, BasicPayStrategyCommEmp, BasicPayStrategySalEmp, BasicPayStrategyHourEmp)
	Payslip calculation implementations.

--------------

CHINMOY KANTI DHAR (ID: 983926)
Responsible for developing "Report Module" use case for Payroll framework. Design and developed report creation framework which is easy to use and extend.
Used Design Pattern:
	1. Singleton - created the connection String for db connection
	2. Factory - to choose the export report type(excel,PDF)
	3. Strategy - to display four type report (Branch, Department, Employee, Salary) data in a same window
	4. Template - to create different types of Payslip PDF 
	5. Facade - used to create pdf and excel object based
	6. Adapter - for database
	
----------------
Luu Ngoc Ha Bui (ID: 986638)
Responsible for developing "Employee Management" use case for Payroll framework. Design and developed structure of Payroll system includes domain data, repository, service, business, controller, view, and implement creation framework for Employee Management
Used design pattern:
1. Singleton
2. Factory Method
3. Prototype