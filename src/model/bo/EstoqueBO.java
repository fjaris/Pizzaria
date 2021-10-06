package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.vo.EstoqueVO;
import model.dao.EstoqueDAO;

public class EstoqueBO implements BaseInterBO <EstoqueVO>{
	EstoqueDAO dao = new EstoqueDAO();
	
	public void inserir(EstoqueVO enity) throws java.sql.SQLException {
		dao.inserir(enity);
	};
	
	public void editar(EstoqueVO enity) throws java.sql.SQLException {
		dao.editar(enity);
	};
	
	public void remover(EstoqueVO enity) throws SQLException {
		dao.remover(enity);
	};
	
	public List<EstoqueVO> listar() throws SQLException {
		return dao.listar();
	}
}
