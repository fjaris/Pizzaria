package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO implements BaseInterBO <UsuarioVO> {
	UsuarioDAO dao = new UsuarioDAO();
	
	public void inserir(UsuarioVO enity) throws java.sql.SQLException {
		dao.inserir(enity);
	};
	public void editar(UsuarioVO enity) throws SQLException {
		dao.editar(enity);
	};
	public void remover(UsuarioVO enity) throws SQLException {
		dao.remover(enity);
	};
	
	public List<UsuarioVO> listar() throws SQLException {
		return dao.listar();
	};
	
	public UsuarioVO autenticar(UsuarioVO enity) throws Exception {
	      UsuarioVO usuario = dao.buscarPorLogin(enity);

	      if (usuario == null)
	        throw new Exception("Usuario não encontrado");
	      if (!enity.getSenha().equals(usuario.getSenha()))
	        throw new Exception("Senha incorreta");

	      return usuario;
  	}
	
}
