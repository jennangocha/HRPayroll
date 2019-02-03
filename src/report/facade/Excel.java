package report.facade;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	public void createExcel(String[] column,String[][] data,String title) {
		try {
			String filename=title.replace(" ", "_");
	         String filepath="download\\"+filename+".xls";
	         int k=1;
	         String temp="";
	         while(k<50) {
		         File f = new File(filepath);
		         if(f.exists() && !f.isDirectory()) { 
		        	 temp=filename+k;
		        	 filepath="download\\"+temp+".xls";
		        	 k++;
		         }
		         else break;
	         }
            filename = filepath ;
            
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");  
            
            int numColumns = column.length;
            
            HSSFRow rowhead = sheet.createRow((short)0);
            for (int i = 0; i < numColumns; i++) {
            	rowhead.createCell(i).setCellValue(column[i]);
            }
            
            for (int i = 0; i < data.length; i++) {
            	 HSSFRow row = sheet.createRow((short)(i+1));
            	 for (int j = 0; j < numColumns; j++) {	               
	                row.createCell(j).setCellValue(data[i][j]);
            	 }
           }

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            if (Desktop.isDesktopSupported()) {
        	    try {
        	        File myFile = new File(filepath);
        	        Desktop.getDesktop().open(myFile);
        	    } catch (IOException ex) {
        	        // no application registered for PDFs
        	    }
        	}
            System.out.println("Your excel file has been generated!");
		 } catch ( Exception ex ) {
	            System.out.println(ex);
	        }
	}
}
