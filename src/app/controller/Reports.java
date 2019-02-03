package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.domain.Branch;
import app.domain.Department;
import app.reports.BranchReport;
import app.reports.DepartmentReport;
import app.reports.EmployeeReport;
import app.reports.Ireports;
import app.reports.StrategyReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Reports implements Initializable{
	@FXML TableView tbl1;
	@FXML Label lblCaption;
	 StrategyReport r=new StrategyReport();
	
	public Reports(Ireports ir) {
			 r.SetStrategy(ir);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 //lblCaption.setText("Employee Report");
		 
		 tbl1=r.getStrategy(tbl1,lblCaption);
	}
	
}