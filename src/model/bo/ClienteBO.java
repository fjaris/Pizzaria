package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO implements BaseInterBO <ClienteVO> {
	ClienteDAO dao = new ClienteDAO();
	
	public void inserir(ClienteVO enity) throws java.sql.SQLException {
		dao.inserir(enity);
	};
	public void editar(ClienteVO enity) throws java.sql.SQLException {
		dao.editar(enity);
	};
	public void remover(ClienteVO enity) throws java.sql.SQLException {
		dao.remover(enity);
	};
	
	public List<ClienteVO> listar() throws SQLException {
		return dao.listar();
	}
}
