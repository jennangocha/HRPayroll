package app.business;

import java.util.Map;

import app.business.prototype.PayslipData;
/*Owner: Jmmy*/
public interface IPaySlipWriter {

	public void write(Map<String, PayslipData> data,String exportPath);
	 
	public String getWriterName();
}
