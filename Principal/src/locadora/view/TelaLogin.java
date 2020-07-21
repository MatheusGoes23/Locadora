package locadora.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLogin extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("telaLocacao.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(cena);
		primaryStage.show();
		
	}
}
