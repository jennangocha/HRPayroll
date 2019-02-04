package app.gui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import app.business.prototype.PayslipData;
import app.business.proxy.IPaySlipGenerator;
import app.business.proxy.PaySlipGeneratorProxy;
import app.controller.Reports;
import app.domain.PayslipPeriod;
import app.domain.User;
import app.exceptions.AuthenticationError;
import app.service.EmployeeService;
import app.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import reports.strategy.BranchReport;
import reports.strategy.DepartmentReport;
import reports.strategy.EmployeeReport;
import reports.strategy.SalaryReport; 
/*Owner: Chinmoy*/
public class GenerateReport  extends Stage  {

	private User user;
	
	private Button empReport=new Button("Employee Report");
	private Button deptReport=new Button("Department Report");
	private Button branchReport=new Button("Branch Report");
	private Button salaryReport=new Button("Salary Report");
	private Button monthlyReport=new Button("Payslip Report");
	
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
		grid.add(monthlyReport,1, 6);
		
		Scene scene = new Scene(grid, 700, 500);

		setScene(scene);
	}
	
	private void setEvent() {
		empReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				Reports r=new Reports(new EmployeeReport());
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
		deptReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				Reports r=new Reports(new DepartmentReport());
				showReport(r);							
			}
		});
		salaryReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				Reports r=new Reports(new SalaryReport());
				showReport(r);							
			}
		});
		
		monthlyReport.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				//Reports r=new Reports(new SalaryReport());
				//showReport(r);	
				//User user=new User("admin","admin");
				showMonthlyReport();
				
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
			stage.setTitle("Report");
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
			Alert a=new Alert(Alert.AlertType.ERROR, "Please contact with Administrator!!");
			a.setHeaderText("DB Connection Error");
			a.showAndWait();
		}		
	}
	private void showMonthlyReport() {
		try {
			
			FXMLLoader fxmlLoader = new 
			FXMLLoader(getClass().getResource("/fxml/SalaryReport.fxml"));
	
			//fxmlLoader.setController(r);
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();			
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Report");
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}		
	}
}
