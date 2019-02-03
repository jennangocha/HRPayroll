package reports.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;

import app.domain.Department;
import db.adapter.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import report.facade.PDF;
import reports.factory.ExportFactory;
import reports.factory.ExportReport;

public class DepartmentReport implements Ireports{

	@Override
	public TableView getReport(TableView tbl1,Label lblCaption) {
		// TODO Auto-generated method stub
		TableColumn departmentCode = new TableColumn("Department Code");
        TableColumn departmentName = new TableColumn("Department Name");
        
        lblCaption.setText("Department Report");
        
        tbl1.getColumns().addAll(departmentCode, departmentName);
        
        Database db=new Database();
        List<Map<String, String>> obj=db.getdata("select * from department");
		
        System.out.println(obj);
        
        departmentName.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        departmentCode.setCellValueFactory(new PropertyValueFactory<>("departmentCode"));
        List<Department> list = new ArrayList<Department>();
        
        String[] temp=new String[2];
        for(int i=0;i<obj.size();i++){
        	temp[0]=obj.get(i).get("departmentCode").toString();
        	temp[1]=obj.get(i).get("departmentName").toString();
        	list.add(new Department(temp[0],temp[1]));
        }
        ObservableList data = FXCollections.observableList(list);
        tbl1.setItems(data);
        return tbl1;
	}
	public void getExportReport(String name) {
		String[] column= {"Department Name","Department Code"};
		Database db=new Database();
		String[][] data=db.getdataString("select * from department");	 
	   
		String title="Department Report";
		ExportFactory factory=new ExportFactory();
		ExportReport rpt=factory.getReport(name);
		rpt.export(column, data, title);
	}
}
