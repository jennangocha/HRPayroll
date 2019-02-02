package app.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import app.data.DefaultData;
import app.domain.User;
import app.service.*;

/*Owner: Jmmy*/
public class Login extends Application{
	
	public static Stage loginStage;
	public static Stage mainMenuStage;
	
	Label lblTitle =new Label("HRPayroll");
	
	Label lblUserName= new Label("User Name : ");
	TextField txtUserName = new TextField();
	
	Label lblPassword= new Label("Password : ");
	PasswordField txtPassword = new PasswordField ();

	Button btnLogin=new Button("Login");
	
	Label lblErrorMessage=new Label();
	
	GridPane grid = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public static void show() {
		loginStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		loginStage=primaryStage;
		
		setGUI();
		setEvent();
		setDefaultData();
	}
	
	private void setGUI() {
		loginStage.setTitle("Login");
		/*Default login*/
		txtUserName.setText("admin");
		txtPassword.setText("admin");
		// Arrange buttons in a 2x1 grid
		
		lblTitle.setStyle("-fx-font: 24 arial;");
		lblErrorMessage.setTextFill(Color.RED);
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); // sets vertical gap between buttons
		grid.add(lblTitle,1, 0);
		grid.add(lblUserName,0, 1);
		grid.add(txtUserName, 1, 1);
		grid.add(lblPassword, 0, 2);
		grid.add(txtPassword, 1, 2);
		
		grid.add(btnLogin, 1, 3);
		grid.add(lblErrorMessage, 1,4);
		
		// create and position scene in stage
		Scene scene = new Scene(grid, 500, 300);
		positionSceneInStage(loginStage, scene);

		loginStage.setScene(scene);
		loginStage.show();
		
		
	}
	
	private void setEvent() {
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//User =new user();
				UserService controller = UserService.getInstance();
				
				User user = controller.getUserByUsername(txtUserName.getText());				
				
				if (user != null)
				{					
					if (user.login(txtPassword.getText())) {
						
						clear();
						
						Stage stage = new Stage();
						
						stage.setTitle("Main Menu");
						stage.setWidth(300);
						stage.setHeight(700);
						
						
						mainMenuStage=new MainMenu(user,stage);
						mainMenuStage.show();
						loginStage.hide();
						
					}else
					{
						lblErrorMessage.setText("Invalid User");						
					}
					
				}
				else
				{
					lblErrorMessage.setText("Invalid User");
				}
				
				
			}
		});
	}
	
	void positionSceneInStage(Stage stage, Scene scene) {
		
		stage.setX(400);
		stage.setY(200);

	}


	private void setDefaultData() {
		DefaultData.load();
	}
	
	private void clear() {
		txtPassword.setText("");
		txtUserName.setText("");
		lblErrorMessage.setText("");
	}
}
