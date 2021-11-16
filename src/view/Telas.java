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
	
	private static Stage secondaryStage;

	  public static void createPopUp(Scene scene, String title) throws Exception {
		closePopUp();
	    secondaryStage = new Stage();
	    secondaryStage.setScene(scene);
	    secondaryStage.setTitle(title);
	    secondaryStage.centerOnScreen();
	    secondaryStage.setResizable(false);
	    secondaryStage.show();
	  }
	  
	  public static void novoPedido() throws Exception {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPedidosNovo.fxml"));
		    Scene scene = new Scene(root);
		    createPopUp(scene, "Novo Pedido");
	}
	  
	  public static void novaPizza() throws Exception {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPizzasNovo.fxml"));
		    Scene scene = new Scene(root);
		    createPopUp(scene, "Nova Pizza");
	}
	  
	  public static void novoAdicional() throws Exception {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAdicionaisNovo.fxml"));
		    Scene scene = new Scene(root);
		    createPopUp(scene, "Novo Adicional");
	}
	  
	public static void novoEstoque() throws Exception {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaEstoqueNovo.fxml"));
		    Scene scene = new Scene(root);
		    createPopUp(scene, "Novo Estoque");
	}
	
	public static void novoCliente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClientNovo.fxml"));
	    Scene scene = new Scene(root);
	    createPopUp(scene, "Novo Cliente");
	}

	  public static void closePopUp() throws Exception {
	    if (secondaryStage != null) {
	      secondaryStage.close();
	      secondaryStage = null;
	    }
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
