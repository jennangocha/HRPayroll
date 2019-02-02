package app.gui;

import java.io.IOException;
import java.time.LocalDate;

import app.controller.Reports;
import app.domain.User;
import app.reports.BranchReport;
import app.reports.DepartmentReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage; 
/*Owner: Jmmy*/
public class GenerateReport  extends Stage  {

	private User user;
	
	private Button empReport=new Button("Employee Report");
	private Button deptReport=new Button("Department Report");
	private Button branchReport=new Button("Branch Report");
	private Button salaryReport=new Button("Salary Report");
	
	private Label lblTitle=new Label("Generate Reports");
	

	
	private GridPane grid = null;
	
	
	
	public GenerateReport(User user,Stage stage) {
		 setGUI();
		 setEvent();
	}
	
	private void setGUI() {
		lblTitle.setStyle("-fx-font: 24 arial;");
		
		
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(20);
		grid.setVgap(20); // sets vertical gap between buttons
		
		grid.add(lblTitle,1, 1);
		grid.add(empReport, 1, 2);
		grid.add(deptReport, 1, 3);
		grid.add(branchReport,1, 4);
		
		grid.add(salaryReport,1, 5);
				
		Scene scene = new Scene(grid, 700, 500);

		setScene(scene);
	}
	
	private void setEvent() {
		deptReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				Reports r=new Reports(new DepartmentReport());
				showReport(r);							
			}
		});
		branchReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				Reports r=new Reports(new BranchReport());
				showReport(r);							
			}
		});
	}
	private void showReport(Reports r) {
		try {
			
			FXMLLoader fxmlLoader = new 
			FXMLLoader(getClass().getResource("/fxml/report.fxml"));
	
			fxmlLoader.setController(r);
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();			
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Dashboard");
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
