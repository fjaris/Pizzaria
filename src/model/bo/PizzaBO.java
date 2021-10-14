package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.PizzaDAO;
import model.vo.PizzaVO;

public class PizzaBO implements BaseInterBO <PizzaVO> {
	PizzaDAO dao = new PizzaDAO();
	
	public void inserir(PizzaVO enity) throws java.sql.SQLException {
		dao.inserir(enity);
	};
	public void remover(PizzaVO enity) throws java.sql.SQLException {
		dao.remover(enity);
	};
	public void editar(PizzaVO enity) throws java.sql.SQLException {
		dao.editar(enity);
	};
	
	public List<PizzaVO> listar() throws SQLException {
		return dao.listar();
	}

}
