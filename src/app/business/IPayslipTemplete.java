package app.business;

import java.util.Map;

import app.domain.PayslipData;

public interface IPayslipTemplete {

	public void print(Map<String, PayslipData> data,String exportPath);
}
