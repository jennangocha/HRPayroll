package app.business;

import java.util.HashMap;
import java.util.Map;

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
		PayslipDataDirector director=new PayslipDataDirector(new DefaultPayslipDataBuilder());
	 
		director.constructPayslipData(e,period, new EmpGroup1PayrollCalStrategyFactory());
		
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
