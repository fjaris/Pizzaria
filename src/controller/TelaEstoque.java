package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaEstoque {
	public void adicionais(ActionEvent event) {
		  try {
			  Telas.adicionais();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void pedidos(ActionEvent event) {
		  try {
			  Telas.pedidos();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void clientes(ActionEvent event) {
		  try {
			  Telas.clientes();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void pizzas(ActionEvent event) {
		  try {
			  Telas.pizzas();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void novoEstoque(ActionEvent event) {
		  try {
			  Telas.novoEstoque();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
}
