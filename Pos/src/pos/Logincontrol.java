package pos;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Logincontrol {
	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXTextField txtUserName;

	@FXML
	private JFXButton btnLogIn;

	@FXML
	private JFXPasswordField txtPassword;

	@FXML
	private Label lblError;
	
	@FXML
    private ImageView imgview1;
	
	@FXML
    private ImageView imgview2;
	
	@FXML
    private ImageView imgview3;
	
	@FXML
    void enterLogin(ActionEvent event) {
		if (txtUserName.getText().equals("possys") && txtPassword.getText().equals("java")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("cafe.fxml"));
				Stage stage = (Stage) btnLogIn.getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			lblError.setText("Please check your id and password !");
		}
    }
	
	@FXML
	void login(ActionEvent event) {
		if (txtUserName.getText().equals("possys") && txtPassword.getText().equals("java")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("cafe.fxml"));
				Stage stage = (Stage) btnLogIn.getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			lblError.setText("Please check your id and password !");
		}
	}

	@FXML
	void close(ActionEvent event) {
		Platform.exit();
	}

}
