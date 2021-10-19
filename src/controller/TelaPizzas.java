package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaPizzas {
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
	  
	  public void clientes(ActionEvent event) {
		  try {
			  Telas.clientes();
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
}
