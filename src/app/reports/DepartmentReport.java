package app.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

}
