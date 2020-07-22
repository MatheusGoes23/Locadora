package locadora.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaCadastro extends Application {
	private static Stage stage;
 	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setTitle("Cadastro");
		primaryStage.setScene(cena);
		primaryStage.show();
		setStage(stage);
	
		
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		TelaCadastro.stage = stage;
	}
}
