package app.business.visitor;

import java.util.HashMap;
import java.util.Map;

import app.business.IPayslipPeriod;
import app.business.abstractFactory.PayrollCalStraFactoryCommEmp;
import app.business.abstractFactory.PayrollCalStraFactoryHourEmp;
import app.business.abstractFactory.PayrollCalStraFactorySalEmp;
import app.business.builder.PayslipDataBuilder;
import app.business.builder.PayslipDataDirector;
import app.business.prototype.PayslipData;
import app.domain.*; 
/*Owner: Jmmy*/
public class PayslipDataVisitor implements IPayslipVisitor {

	private Map<String, PayslipData> payslipsCol = new HashMap<String, PayslipData>();
	private IPayslipPeriod period;
 
	public PayslipDataVisitor(IPayslipPeriod visitPeriod) {
		this.period=visitPeriod;
	}
	
	@Override
	public void visit(HourlyEmployee e) {
		// TODO Auto-generated method stub
		PayslipDataDirector director=new PayslipDataDirector(new PayslipDataBuilder());
	 
		director.constructPayslipData(e,period, new PayrollCalStraFactoryHourEmp());
		
		payslipsCol.put(e.getEmpCode(), director.getPayslipData());
	}

	@Override
	public void visit(SalariedEmployee e) {
		// TODO Auto-generated method stub
		PayslipDataDirector director=new PayslipDataDirector(new PayslipDataBuilder());
		 
		director.constructPayslipData(e,period, new PayrollCalStraFactorySalEmp());
		
		payslipsCol.put(e.getEmpCode(), director.getPayslipData());
	}	
	
	@Override
	public void visit(CommissionedEmployee e) {
		// TODO Auto-generated method stub
		PayslipDataDirector director=new PayslipDataDirector(new PayslipDataBuilder());
		 
		director.constructPayslipData(e,period, new PayrollCalStraFactoryCommEmp());
		
		payslipsCol.put(e.getEmpCode(), director.getPayslipData());
	}
	
	public Map<String, PayslipData> getPayslipCol() {
		return payslipsCol;
	}

	

}
