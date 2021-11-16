package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaClientes {
	public void adicionais(ActionEvent event) {
		  try {
			  Telas.adicionais();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void estoque(ActionEvent event) {
		  try {
			  Telas.estoque();
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
	  
	  public void pizzas(ActionEvent event) {
		  try {
			  Telas.pizzas();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void novoCliente(ActionEvent event) {
		  try {
			  Telas.novoCliente();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
}
