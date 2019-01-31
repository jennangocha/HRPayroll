package app.gui;

import app.domain.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*Owner: Jmmy*/
public class MainMenu extends Stage{

	private User user;
	final ImageView selectedImage = new ImageView();   
    
	private Button btnEmployee=new Button("Employee");
	private Button btnPayslip=new Button("Payslip");
	private Button btnReport=new Button("Report");
	
	private Button btnLogout=new Button("Logout");
	
	private Label lblTitle=new Label("HRPayroll");
	
	private GridPane grid = null;
	
	public MainMenu(User user,Stage ps) {
		this.user=user;
				
		setGUI();
		setEvent();
		setOption();
	}
	public void setGUI() {
		
		lblTitle.setStyle("-fx-font: 24 arial;");
		VBox vBox = new VBox();
				
		btnEmployee.setMinWidth(100);
		btnPayslip.setMinWidth(100);
		btnReport.setMinWidth(100);
		btnLogout.setMinWidth(100);
		
		Image image = new Image("/resources/logo.png");

	    selectedImage.setImage(image);
	    
	    vBox.setSpacing(5);
	    vBox.setAlignment(Pos.BASELINE_CENTER);
	    vBox.getChildren().addAll(lblTitle,btnEmployee,btnPayslip,btnReport,btnLogout,selectedImage);
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); // sets vertical gap between buttons
		grid.add(vBox, 0, 0);
		/*grid.add(btnEmployee,0, 1);
		grid.add(btnPayslip,0, 2);
		grid.add(btnReport, 0, 3);
		grid.add(btnLogout, 0, 4);
		grid.add(selectedImage, 0, 5);*/
		Scene scene = new Scene(grid, 400, 500);

		setScene(scene);
	}
		
	public void setEvent() {
		btnLogout.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				close();
				Login.show();
			}
		});
		
		btnPayslip.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				
				stage.setTitle("Generate Payslip");
				stage.setWidth(300);
				stage.setHeight(700);
				
				
				GeneratePayslip payslip=new GeneratePayslip(user,stage);
				payslip.show();
			}
		});
		
		btnReport.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				stage.setTitle("Reports");
				stage.setWidth(300);
				stage.setHeight(700);
				
				
				GenerateReport report=new GenerateReport(user,stage);
				report.show();
			}
		});
	}
	
	public void setOption() {

		btnEmployee.setVisible(false);
		btnPayslip.setVisible(false);
		btnReport.setVisible(false);
		
		if(user.getAccesslevel()==app.domain.AccessLevel.ADMIN )
		{
			btnEmployee.setVisible(true);
			btnPayslip.setVisible(true);
			btnReport.setVisible(true);
		}else {
			btnPayslip.setVisible(true);
		}
	}

}
