package pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class deleteMain extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));

		Scene scene = new Scene(root);

		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}

}
