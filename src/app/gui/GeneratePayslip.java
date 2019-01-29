package app.gui;

import app.domain.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GeneratePayslip  extends Stage {

	private User user;
	
	private Button btnSearch=new Button("Search");
	private Button btnSubmit=new Button("Submit");
	private Button btnPreview=new Button("Preview");
	
	private Label lblTitle=new Label("Generate Payslip");
	
	Label lblEmployee=new Label("Enter Employee Info:");
	
	Label lblEmpName=new Label("Name");
	Label lblEmpCode=new Label("Code");
	Label lblEmpDept=new Label("Department");
	Label lblEmpBranch=new Label("Branch");
	Label lblEmpStatus=new Label("Status");
	
	TextField txtSearch=new TextField();
	
	private GridPane grid = null;
	
	
	public GeneratePayslip(User user,Stage stage) {
		 setGUI();
	}
	
	private void setGUI() {
		lblTitle.setStyle("-fx-font: 24 arial;");
	
		txtSearch.setPrefWidth(100);
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10); // sets vertical gap between buttons
		
		grid.add(lblTitle,1, 0);
		grid.add(lblEmployee,0, 1);
		grid.add(txtSearch,1, 1);
		grid.add(btnSearch,3, 1);
		
		Scene scene = new Scene(grid, 700, 500);

		setScene(scene);
	}
	
	private void setEvent() {
		
	}
}
