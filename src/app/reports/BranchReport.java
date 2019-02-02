package app.reports;

import java.util.ArrayList;
import java.util.List;

import app.domain.Branch;
import app.domain.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
	       
	        List list = new ArrayList();
	        list.add(new Branch("1","Dhaka"));
	        list.add(new Branch("2","Chittagong"));
	        list.add(new Branch("3","2"));
	        list.add(new Branch("4","2"));
	        
	        ObservableList data = FXCollections.observableList(list);
	        tbl1.setItems(data);
        return tbl1;
	}

}
