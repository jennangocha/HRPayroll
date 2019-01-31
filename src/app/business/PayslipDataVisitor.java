package app.business;

import java.util.HashMap;
import java.util.Map;

import app.domain.*; 

public class PayslipDataVisitor implements IPayslipVisitor {

	private Map<String, PayslipData> payslipsCol = new HashMap<String, PayslipData>();
	
	@Override
	public void visit(HourlyEmployee e) {
		// TODO Auto-generated method stub
		PayslipDataDirector director=new PayslipDataDirector(new DefaultPayslipDataBuilder());
	 
		director.constructPayslipData(e, new EmpGroup1PayrollCalStrategyFactory());
		
		payslipsCol.put(e.getEmpCode(), director.getPayslipData());
	}

	@Override
	public void visit(SalariedEmployee e) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, PayslipData> getPayslipCol() {
		return payslipsCol;
	}

}
