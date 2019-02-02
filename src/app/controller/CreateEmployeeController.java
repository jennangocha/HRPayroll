package app.controller;

import org.omg.CORBA.INITIALIZE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateEmployeeController {

    @FXML
    private Label fxlbl_firstname;

    @FXML
    private Label fxlbl_employeeid;

    @FXML
    private Label fxlbl_createemployee;

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
    private Label fxlbl_street;

    @FXML
    private Label fxlbl_state;

    @FXML
    private TextField fxtf_state;

    @FXML
    private TextField fxtf_street;

    @FXML
    private Label fxlbl_dob;

    @FXML
    private TextField fxtf_email;

    @FXML
    private Label fxlbl_branch;

    @FXML
    private Label fxlbl_email;

    @FXML
    private ComboBox<String> fxcb_department;
    
    ObservableList<String> listDepartment = FXCollections.observableArrayList("Financial","Human Resource","Development");

    @FXML
    private TextField fxtf_city;

    @FXML
    private Label fxlbl_department;

    @FXML
    private TextField fxtf_firstname;

    @FXML
    private TextField fxtf_phone;

    @FXML
    private Label fxlbl_country;

    @FXML
    private TextField fxtf_dob;

    @FXML
    private Label fxlbl_phone;

    @FXML
    private ComboBox<?> fxcb_branch;

    @FXML
    private Label fxlbl_lastname;

    @FXML
    private TextField fxtf_lastname;

    @FXML
    private Button fxbt_save;

    @FXML
    private TextField fxtf_country;
    
    @FXML
    private void initialize() {
    	fxcb_department.setValue("Development");
    	fxcb_department.setItems(listDepartment);
    }

    @FXML
    void onSaveAction(ActionEvent event) {

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

}
