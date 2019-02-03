package reports.strategy;

import java.util.ArrayList;
import java.util.List;

import app.data.EmployeeData;
import app.domain.Department;
import app.service.EmployeeService;
import db.adapter.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import report.facade.PDF;

public class EmployeeReport implements Ireports{

	@Override
	public TableView getReport(TableView tbl1,Label lblCaption) {
		// TODO Auto-generated method stub
		
		lblCaption.setText("Employee Report");
        TableColumn empCode = new TableColumn("Employee Code");
        TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("First Name");
        TableColumn position =new TableColumn("Designation");
        TableColumn department =new TableColumn("Department");
        TableColumn branch =new TableColumn("Branch");
        
        EmployeeService empService = EmployeeService.getInstance();
       
        tbl1.getColumns().addAll(empCode, firstName,lastName,position,department,branch);
        
        
        empCode.setCellValueFactory(new PropertyValueFactory<>("empCode"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        department.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        branch.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        
        List list = new ArrayList();
        for(int i=0;i< empService.getAllEmployee().size();i++) {
        	list.add(empService.getAllEmployee().get(i));
        	
        }
        
        ObservableList data = FXCollections.observableList(list);
        tbl1.setItems(data);
        return tbl1;
	}
	public void getPdf() {
		String[] column= {"Branch Name","Branch Code"};
		Database db=new Database();
		String[][] data=db.getdataString("select * from branch");	 
	   
		String title="Branch Report";
		PDF p=new PDF();
		p.createPDF(column, data, title);
	}
}
