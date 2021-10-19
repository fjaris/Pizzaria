package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import view.Telas;


public class LoginController {
	UsuarioBO boUsuario = new UsuarioBO();
	
	
	@FXML
	  private Label error;
	  @FXML
	  private TextField login;
	  @FXML
	  private PasswordField senha;
	  @FXML
	  private TextField loginCadastro;
	  @FXML
	  private TextField senhaCadastro;
	  @FXML
	  private TextField senhaConfirmarCadastro;
	  
	  
	  public void autenticar(ActionEvent event) {
//		  System.out.println(login.getText());
//		  System.out.println(senha.getText());
		  try {
//			  UsuarioVO usuario = new UsuarioVO();
//
//			  usuario.setUsuario(this.login.getText());
//		        usuario.setSenha(this.senha.getText());
//
//		        this.boUsuario.autenticar(usuario);
		        Telas.pedidos();
		  }
		  catch(Exception e) {
			  error.setText(e.getMessage());
			  e.printStackTrace();
		  }
	  }
	  
	  public void cadastrar(ActionEvent event) {
		  UsuarioVO usuario = new UsuarioVO();
		  usuario.setUsuario(loginCadastro.getText());
		  usuario.setSenha(senhaCadastro.getText());
	  }
	  
	  public void telaCadastro(ActionEvent event) {
		  try {
			Telas.cadastrar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public void voltarLogin(ActionEvent event) {
		  try {
				Telas.login();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
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
	 
	  
}
