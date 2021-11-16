package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaAdicionais {
	  
	  public void pedidos(ActionEvent event) {
		  try {
			  Telas.pedidos();
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
	  
	  public void novoAdicional(ActionEvent event) {
		  try {
			  Telas.novoAdicional();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
}
