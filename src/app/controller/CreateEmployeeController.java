package app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.service.BranchListServiceImpl;
import app.service.DepartmentListServiceImpl;
import app.service.IBranchListService;
import app.service.IDepartmentListService;
import app.service.IJobTypeService;
import app.service.JobTypeListServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateEmployeeController {

    @FXML
    private Label fxlbl_firstname;

    @FXML
    private Label fxlbl_employeeid;

    @FXML
    private DatePicker fxdate_resignDate;

    @FXML
    private Label fxlbl_createemployee;

    @FXML
    private Label fxlbl_resignDate;

    @FXML
    private TextField fxtf_zipcode;

    @FXML
    private TextField fxtf_employeeid;

    @FXML
    private Button fxbt_exit;

    @FXML
    private Label fxlbl_city;

    @FXML
    private Label fxlbl_zipcode;

    @FXML
    private DatePicker fxdate_dob;

    @FXML
    private Label fxlbl_street;

    @FXML
    private Label fxlbl_state;

    @FXML
    private TextField fxtf_position;

    @FXML
    private TextField fxtf_state;

    @FXML
    private TextField fxtf_street;

    @FXML
    private Label fxlbl_dob;

    @FXML
    private TextField fxtf_email;

    @FXML
    private TextField fxtf_salary;

    @FXML
    private Label fxlbl_branch;

    @FXML
    private Label fxlbl_salary;

    @FXML
    private DatePicker fxdate_joinDate;

    @FXML
    private Label fxlbl_email;

    @FXML
    private ComboBox<String> fxcb_department;

    @FXML
    private TextField fxtf_city;

    @FXML
    private Label fxlbl_department;

    @FXML
    private Label fxlbl_position;

    @FXML
    private TextField fxtf_firstname;

    @FXML
    private TextField fxtf_phone;

    @FXML
    private Label fxlbl_country;

    @FXML
    private Label fxlbl_phone;

    @FXML
    private ComboBox<String> fxcb_branch;

    @FXML
    private Label fxlbl_joinDate;

    @FXML
    private Label fxlbl_lastname;

    @FXML
    private TextField fxtf_lastname;

    @FXML
    private Button fxbt_save;

    @FXML
    private Label fxlbl_jobType;

    @FXML
    private TextField fxtf_country;

    @FXML
    private ComboBox<String> fxcb_jobType;
    
    @FXML
    private Label fxlbl_ssn;
    
    @FXML
    private TextField fxtf_ssn;
    
    private IDepartmentListService departmentService = new DepartmentListServiceImpl();
    private List<String> departmentNames = new ArrayList<String>();
    private ObservableList<String> departmentNamesObserver;
    private IBranchListService branchService = new BranchListServiceImpl();
    private List<String> branchNames = new ArrayList<String>();
    private ObservableList<String> branchObserver;
    private IJobTypeService jobTypeService = new JobTypeListServiceImpl();
    private List<String> jobTypes = new ArrayList<String>();
    private ObservableList<String> jobTypeObserver;
    
    @FXML
    private void initialize() {
    	prepareDataForInitialize();
    	populatedData();
    }
    
    private void populatedData() {
    	fxcb_department.setValue((departmentNamesObserver.get(0)));
    	fxcb_department.setItems(departmentNamesObserver);
    	fxcb_branch.setValue(branchObserver.get(0));
    	fxcb_branch.setItems(branchObserver);
    	fxcb_jobType.setValue(jobTypeObserver.get(0));
    	fxcb_jobType.setItems(jobTypeObserver);
	}

	private void prepareDataForInitialize() {
    	departmentNames = departmentService.getDepartmentList();
    	departmentNamesObserver = FXCollections.observableList(departmentNames);
    	branchNames = branchService.getBranchListByName();
    	branchObserver = FXCollections.observableList(branchNames);
    	jobTypes = jobTypeService.getJobTypeList();
    	jobTypeObserver = FXCollections.observableArrayList(jobTypes);
    }

    @FXML
    void onSaveAction(ActionEvent event) {
    	prepareDataForSave();
    }

    private void prepareDataForSave() {
    	String employeeCode = fxtf_employeeid.getText();
    	LocalDate dob = fxdate_dob.getValue();
    	String firstName = fxtf_firstname.getText();
    	String lastName = fxtf_lastname.getText();
    	String ssn = fxtf_ssn.getText();
	}

	@FXML
    void onExitAction(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onDepartmentChoosenAction(ActionEvent event) {

    }

    @FXML
    void onBranchChoosenAction(ActionEvent event) {

    }

    @FXML
    void onChooseDateAction(ActionEvent event) {

    }

    @FXML
    void onChooseJoinDateAction(ActionEvent event) {

    }

    @FXML
    void onChooseResignDateAction(ActionEvent event) {

    }

    @FXML
    void onJobChoosenAction(ActionEvent event) {

    }

}
