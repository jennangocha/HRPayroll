package reports.factory;

import report.facade.Excel;

public class ExportExcel implements ExportReport{

	@Override
	public void export(String[] column,String[][] data,String title) {
		// TODO Auto-generated method stub
		//System.out.println("excel");
		Excel ex=new Excel();
		ex.createExcel(column, data, title);
	}

}
