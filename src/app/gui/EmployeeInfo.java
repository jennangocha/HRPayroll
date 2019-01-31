package app.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author luungochabui
 *
 */

public class EmployeeInfo extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = (Pane)FXMLLoader.load(EmployeeInfo.class.getResource("/fxml/employee_info.fxml"));
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
		
	}

}
