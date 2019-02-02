package app.reports;

import java.util.ArrayList;
import java.util.List;

import app.domain.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.Database;

public class DepartmentReport implements Ireports{

	@Override
	public TableView getReport(TableView tbl1,Label lblCaption) {
		// TODO Auto-generated method stub
		TableColumn departmentCode = new TableColumn("Department Code");
        TableColumn departmentName = new TableColumn("Department Name");
        
        lblCaption.setText("Department Report");
        
        tbl1.getColumns().addAll(departmentCode, departmentName);
        
        Database db=new Database();
		db.getdata("select * from employee");
		
        
        departmentName.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        departmentCode.setCellValueFactory(new PropertyValueFactory<>("departmentCode"));
        List list = new ArrayList();
        list.add(new Department("1","2"));
        ObservableList data = FXCollections.observableList(list);
        tbl1.setItems(data);
        return tbl1;
	}

}
