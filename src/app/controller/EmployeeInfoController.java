package app.controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.business.EmployeeTableDataLoader;
import app.business.EmployeeView;
import app.domain.Employee;
import app.gui.EmployeeCreation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * 
 * @author luungochabui
 *
 */

public class EmployeeInfoController implements Initializable{

    @FXML
    private Label fxlbl_title;

    @FXML
    private TableView<EmployeeView> fxtbl_infoEmployee;

    @FXML
    private Button fxbt_create;

    @FXML
    private Button fxbt_delete;
    
    @FXML
    private Button fxbt_reload;
    
    @FXML
    private TableColumn<EmployeeView, String> addressColumn;
    
    @FXML
    private TableColumn<EmployeeView, String> codeColumn;
    
    @FXML
    private TableColumn<EmployeeView, String> phoneColumn;
    
    @FXML
    private TableColumn<EmployeeView, String> nameColumn;

    @FXML
    private TableColumn<EmployeeView, String> salaryColumn;
    
    @FXML
    private TableColumn<EmployeeView, String> emailColumn;
    
    @FXML
    private TableColumn<EmployeeView, String> departmentCol;
    
    @FXML
    private TableColumn<EmployeeView, String> branchCol;

    
    private ObservableList<EmployeeView> employeeData = FXCollections.observableArrayList();
    
    private static EmployeeInfoController instance = new EmployeeInfoController();
    
    
    public static EmployeeInfoController getInstance() {
    	return instance;
    }
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	codeColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("code"));
    	nameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("name"));
    	addressColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("address"));
    	phoneColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("phone"));
    	salaryColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("salary"));
    	emailColumn.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("email"));
    	departmentCol.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("department"));
    	branchCol.setCellValueFactory(new PropertyValueFactory<EmployeeView, String>("branch"));
    	fxtbl_infoEmployee.setItems(getList());
    }

    @FXML
    void onSortAction(ActionEvent event) {
    	
    }
    
    @FXML
    void onReloadAction(ActionEvent event) {
    	fxtbl_infoEmployee.getItems().clear();
    	fxtbl_infoEmployee.setItems(getList());
    }

    @FXML
    void onCreateAction(ActionEvent event) throws Exception {
    	Stage empCreationStage = new Stage();
    	EmployeeCreation empCreation = new EmployeeCreation();
    	empCreation.start(empCreationStage);
    }
    
    public void addList(String code, String name, String address, String phone, String salary, String email, String department, String branch) {
    	employeeData.add(new EmployeeView(code, name, address, phone, salary, email, department, branch));
    }
    
    public ObservableList<EmployeeView> getList(){
    	List<EmployeeView> list = EmployeeTableDataLoader.getAllEmployee();
    	for(EmployeeView eView: list) {
    		employeeData.add(eView);
    	}
    	return employeeData;
    }


    @FXML
    void onDeleteAction(ActionEvent event) {
    	fxtbl_infoEmployee.getItems().removeAll(fxtbl_infoEmployee.getSelectionModel().getSelectedItem());
    	System.out.println("Employee is deleted");
    }
    
    @FXML
    void onExitAction(ActionEvent event) {
    	Window w = ((Node)(event.getSource())).getScene().getWindow(); 
    	((Stage)w).close();
    }

}
