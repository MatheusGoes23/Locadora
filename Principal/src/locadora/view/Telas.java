package locadora.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Login");
		primaryStage.show();
		telaLogin();
	
		
	}
	
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("loginTela.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaInicialLivros.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastro() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("cadastro.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void cadastroVinil() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaIncluirVinis.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void inicialVinil() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaInicialVinis.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	
	
	public static void cadastroLivros() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaIncluirLivros.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaClientes.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaIncluirClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaIncluirCliente.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void main(String[] args) {
		launch();
	}

	
	
	
}