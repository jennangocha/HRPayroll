package app.controller;
import app.gui.EmployeeCreation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * 
 * @author luungochabui
 *
 */

public class EmployeeInfoController {

    @FXML
    private Label fxlbl_title;

    @FXML
    private Button fxbt_update;

    @FXML
    private TableView<?> fxtbl_infoEmployee;

    @FXML
    private Button fxbt_create;

    @FXML
    private Button fxbt_delete;

    @FXML
    void onSortAction(ActionEvent event) {

    }

    @FXML
    void onCreateAction(ActionEvent event) throws Exception {
    	Stage empCreationStage = new Stage();
    	EmployeeCreation empCreation = new EmployeeCreation();
    	empCreation.start(empCreationStage);
    }

    @FXML
    void onUpdadteAction(ActionEvent event) {

    }

    @FXML
    void onDeleteAction(ActionEvent event) {

    }
    
    @FXML
    void onExitAction(ActionEvent event) {
    	Window w = ((Node)(event.getSource())).getScene().getWindow(); 
    	((Stage)w).close();
    }

}
