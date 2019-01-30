package app.business;

import java.util.HashMap;
import java.util.Map;

import app.domain.*; 

public class PayslipVisitorImpl implements IPayslipVisitor {

	private Map<String, PayslipDataComponent> payslipsCol = new HashMap<String, PayslipDataComponent>();
	
	@Override
	public void visit(HourlyEmployee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SalariedEmployee e) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, PayslipDataComponent> getPayslipCol() {
		return payslipsCol;
	}

}
