package app.business;

import java.util.HashMap;
import java.util.Map;

import app.domain.*; 

public class PayslipVisitorImpl implements IPayslipVisitor {

	private Map<String, APayslipComponent> payslipsCol = new HashMap<String, APayslipComponent>();
	
	@Override
	public void visit(HourlyEmployee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SalariedEmployee e) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, APayslipComponent> getPayslipCol() {
		return payslipsCol;
	}

}
