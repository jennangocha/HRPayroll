package app.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.domain.Branch;
import app.domain.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.Database;

public class BranchReport implements Ireports{

	@Override
	public TableView getReport(TableView tbl1,Label lblCaption) {
		// TODO Auto-generated method stub
		 	TableColumn branchName = new TableColumn("Branch Name");
	        TableColumn branchCode = new TableColumn("Branch Code");
	       
	        lblCaption.setText("Branch Report");
	        tbl1.getColumns().addAll(branchName,branchCode);
	        branchCode.setCellValueFactory(new PropertyValueFactory<>("branchCode"));
	        branchName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
	       
	       
	        Database db=new Database();
	        List<Map<String, String>> obj=db.getdata("select * from branch");
	        
	        List<Branch> list = new ArrayList<Branch>();
	        
	        String[] temp=new String[2];
	        for(int i=0;i<obj.size();i++){
	        	temp[0]=obj.get(i).get("branchCode").toString();
	        	temp[1]=obj.get(i).get("branchName").toString();
	        	list.add(new Branch(temp[0],temp[1]));
	        }
	        
	        
	        ObservableList data = FXCollections.observableList(list);
	        tbl1.setItems(data);
        return tbl1;
	}

}
