package app.gui;

import java.time.LocalDate;

import app.domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage; 
/*Owner: Jmmy*/
public class GeneratePayslip  extends Stage {

	private User user;
	
	private Button btnSearch=new Button("Search");
	private Button btnSubmit=new Button("Submit");
	private Button btnPreview=new Button("Preview");
	
	private Label lblTitle=new Label("Generate Payslip");
	
	private Label lblEmployee=new Label("Enter Employee Info:");
	
	private Label lblEmpName=new Label("Name");
	private Label lblEmpCode=new Label("Code");
	private Label lblEmpDept=new Label("Department");
	private Label lblEmpBranch=new Label("Branch");
	private Label lblEmpStatus=new Label("Status");
	
	private Label lblPayslipTemplate=new Label("Payslip Template");
	
	private Label lblPeriod=new Label("Period");
	
	private TextField txtSearch=new TextField();
	
	private TextField txtEmpname=new TextField();
	private TextField txtCode=new TextField();
	private TextField txtDept=new TextField();
	private TextField txtBranch=new TextField();
	private TextField txtStatus=new TextField();
	
	private DatePicker datePickerfrom = new DatePicker();
	private DatePicker datePickerto = new DatePicker();
	
	private GridPane grid = null;
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "XML"
		    );
	private ComboBox cboPayslipTemplete = new ComboBox(options);
	
	//A checkbox with a string caption
	CheckBox chkemail = new CheckBox("Email");
	CheckBox chkexport = new CheckBox("Export");
	CheckBox chkprint = new CheckBox("Print");
	
	public GeneratePayslip(User user,Stage stage) {
		 setGUI();
	}
	
	private void setGUI() {
		lblTitle.setStyle("-fx-font: 24 arial;");
	
		txtSearch.setPrefWidth(100);
		
		txtEmpname.setEditable(false);
		txtCode.setEditable(false);
		txtDept.setEditable(false);
		txtBranch.setEditable(false);
		txtStatus.setEditable(false);
		
		datePickerfrom.setValue(LocalDate.of(2019, 2,1));
		datePickerto.setValue(LocalDate.of(2019, 2, 28));
				
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10); // sets vertical gap between buttons
		
		grid.add(lblTitle,1, 0);
		grid.add(lblEmployee,0, 1);
		grid.add(txtSearch,1, 1);
		grid.add(btnSearch,2, 1);
		
		grid.add(lblEmpName, 0, 3);
		grid.add(txtEmpname, 1, 3);
		
		grid.add(lblEmpCode, 2, 3);
		grid.add(txtCode, 3, 3);
		
		grid.add(lblEmpDept, 0, 4);
		grid.add(txtDept, 1, 4);
		
		grid.add(lblEmpBranch, 2, 4);
		grid.add(txtBranch, 3, 4);
		
		grid.add(lblEmpStatus, 0, 5);
		grid.add(txtStatus, 1, 5);
		
		grid.add(lblPeriod, 0, 7);
		grid.add(datePickerfrom, 1, 7);
		
		grid.add(datePickerto, 1, 8);
		
		grid.add(lblPayslipTemplate, 0, 9);
		grid.add(cboPayslipTemplete, 1, 9);
		//grid.add(btnPreview,2, 9);
		
		grid.add(chkemail, 1, 10);
		grid.add(chkexport, 1, 11);
		grid.add(chkprint, 1, 12);
		
		grid.add(btnSubmit, 1, 14);
		
		Scene scene = new Scene(grid, 700, 500);

		setScene(scene);
	}
	
	private void setEvent() {
		
	}
}
