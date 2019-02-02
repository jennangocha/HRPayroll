package app.gui;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import app.domain.Employee;
import app.domain.EmployeeInfoPayslipDisplay;
import app.domain.PayslipPeriod;
import app.domain.User;
import app.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage; 
/*Owner: Jmmy*/
public class GeneratePayslip  extends Stage {

	private User user;
	private Stage stage;
	private Button btnSearch=new Button("Search");
	private Button btnSubmit=new Button("Export");
	private Button btnBrowsePath=new Button("Browse");
	
	private Label lblTitle=new Label("Generate Payslip");
	
	private Label lblEmployee=new Label("Enter Employee Info :");
	
	 
	private Label lblEmpDept=new Label("Department :");
	private Label lblEmpBranch=new Label("Branch :"); 
	
	private Label lblPayslipTemplate=new Label("Payslip Template :");
	
	private Label lblPeriod=new Label("Pay Period :");
	
	private Label lblExportPath=new Label("Export Path :");
	
	private TextField txtSearch=new TextField();	 
	private TextField txtDept=new TextField();
	private TextField txtBranch=new TextField(); 
	
	private TextField txtExportPath=new TextField(); 
	
	private DatePicker datePickerfrom = new DatePicker();
	private DatePicker datePickerto = new DatePicker();
	
	private GridPane grid = null;
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "XML"
		    );
	private ComboBox cboPayslipTemplete = new ComboBox(options);
	
	//A checkbox with a string caption
	/*CheckBox chkemail = new CheckBox("Email");
	CheckBox chkexport = new CheckBox("Export");
	CheckBox chkprint = new CheckBox("Print");*/
	
    private TableView<EmployeeInfoPayslipDisplay> tblEmployee = new TableView<>(); 
    private final ObservableList<EmployeeInfoPayslipDisplay> data =
            FXCollections.observableArrayList();
    
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File selectedDirectory;
	
	public GeneratePayslip(User user,Stage stage) {
		this.stage=stage;
		 setGUI();
		 setEvent();
	}
	
	private void setGUI() {
		lblTitle.setStyle("-fx-font: 24 arial;");
		
		tblEmployee.setEditable(false);
		
		TableColumn<EmployeeInfoPayslipDisplay, String> dateCol1 = new TableColumn<>("FirstName");
		dateCol1.setPrefWidth(130);
        dateCol1.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        
        TableColumn<EmployeeInfoPayslipDisplay, String> dateCol2 = new TableColumn<>("LastName");
        dateCol2.setPrefWidth(130);
        dateCol2.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        
        TableColumn<EmployeeInfoPayslipDisplay, String> dateCol3 = new TableColumn<>("Code");
        dateCol3.setPrefWidth(80);
        dateCol3.setCellValueFactory(new PropertyValueFactory<>("Code"));
        
        TableColumn<EmployeeInfoPayslipDisplay, String> dateCol4 = new TableColumn<>("Department");
        dateCol4.setPrefWidth(130);
        dateCol4.setCellValueFactory(new PropertyValueFactory<>("Department"));
        
        TableColumn<EmployeeInfoPayslipDisplay, String> dateCol5 = new TableColumn<>("Branch");
        dateCol5.setPrefWidth(130);
        dateCol5.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        
        TableColumn<EmployeeInfoPayslipDisplay, Double> dateCol6 = new TableColumn<>("BasicPay");
        dateCol6.setPrefWidth(150);
        dateCol6.setCellValueFactory(new PropertyValueFactory<>("BasicPay"));
        
        ScrollBar table1VerticalScrollBar = findScrollBar( tblEmployee, Orientation.VERTICAL);
        tblEmployee.getColumns().addAll(dateCol1,dateCol2,dateCol3,dateCol4,dateCol5,dateCol6); 
        tblEmployee.setPrefSize( 600, 200 );
        tblEmployee.setItems(data);			
	
		txtSearch.setPrefWidth(100);		
	 
		txtExportPath.setEditable(false);			
		
		datePickerfrom.setValue(LocalDate.of(2019, 2,1));
		datePickerto.setValue(LocalDate.of(2019, 2, 28));
				
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10); // sets vertical gap between buttons
		
		grid.add(lblTitle,0, 0,3,1);
		grid.add(lblEmployee,0, 1);
		grid.add(txtSearch,1, 1);
			
	
		grid.add(lblEmpDept, 2, 1);
		grid.add(txtDept, 3, 1);
		
		grid.add(lblEmpBranch, 4, 1);
		grid.add(txtBranch, 5, 1);
		
		grid.add(btnSearch,6, 1);	
		
		grid.add(tblEmployee, 0,2,7,1);
		 
		grid.add(lblPeriod, 0, 3);
		grid.add(datePickerfrom, 1, 3);
		
		grid.add(datePickerto, 1, 4);
		
		grid.add(lblPayslipTemplate, 0, 5);
		grid.add(cboPayslipTemplete, 1, 5);
		//grid.add(btnPreview,2, 9);
		/*HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.getChildren().addAll(chkprint,chkemail,chkexport);
		grid.add(hbox, 1, 6,2,1); */
		
		grid.add(lblExportPath, 0, 6);
		grid.add(txtExportPath, 1, 6);
		grid.add(btnBrowsePath, 2, 6);
		
		grid.add(btnSubmit, 1, 7);
		
		Scene scene = new Scene(grid, 850, 530);

		setScene(scene);
	}
	
	private void setEvent() {
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				refreshEmployeeList(getEmployeeList());
			}
		});
		
		btnBrowsePath.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				selectedDirectory= directoryChooser.showDialog(stage);
				
				txtExportPath.setText(selectedDirectory.getAbsolutePath());
			}
		});
		
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			 
					
			}
		});
	}
	
	private void refreshEmployeeList(List<Employee> e) {
		data.clear();
		
		for(Employee emp : e) 
			data.add(new EmployeeInfoPayslipDisplay(emp.getFirstName(), emp.getLastName(), emp.getEmpCode(), emp.getDepartment().getDepartmentName(), emp.getBranch().getBranchName(), 0.00));
		
	}
	
	private List<Employee> getEmployeeList(){
		return EmployeeService.getInstance().getAllEmployee(txtDept.getText().trim(), txtBranch.getText().trim(), txtSearch.getText().trim());
	}
	
	private PayslipPeriod getPayPeriod() {
		 
		PayslipPeriod period=new PayslipPeriod(java.sql.Date.valueOf( datePickerfrom.getValue()),  java.sql.Date.valueOf( datePickerto.getValue()));
		
		return period;
	}
	
	 private ScrollBar findScrollBar(TableView<?> table, Orientation orientation) {
 
	        Set<Node> set = table.lookupAll(".scroll-bar");
	        for( Node node: set) {
	            ScrollBar bar = (ScrollBar) node;
	            if( bar.getOrientation() == orientation) {
	                return bar;
	            }
	        }

	        return null;

	    }
	 
}
