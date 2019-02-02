package app.reports;

import java.util.ArrayList;
import java.util.List;

import app.data.EmployeeData;
import app.domain.Department;
import app.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeReport implements Ireports{

	@Override
	public TableView getReport(TableView tbl1,Label lblCaption) {
		// TODO Auto-generated method stub
		
		
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

}
