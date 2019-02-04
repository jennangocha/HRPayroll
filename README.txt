TEAM 1

PHYO LIN TUN (ID: 986702)

Responsible for developing "Generate Payslip" use case for Payroll framework.Design and develop Payslip data creation framework that is easy to extend by application developer. Find a most suitable design solution to solve frequent changes in payroll calculation strategy for different type of employee. Develop GUI and linked up with the framework to demonstrate extendibility. Delivered complete UML for "Generate Payslip" use case.
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