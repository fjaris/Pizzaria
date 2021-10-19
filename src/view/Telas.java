package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Pizzaria");
		login();
		stage.setResizable(false);
		stage.show();
	}
	
	public static void login() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/login.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void pedidos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPedidos.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void cadastrar() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrar.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void adicionais() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAdicionais.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void estoque() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaEstoque.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void clientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCliente.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
	
	public static void pizzas() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPizzas.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	}
}
