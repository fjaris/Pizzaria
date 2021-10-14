package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.AdicionalDAO;
import model.vo.AdicionalVO;

public class AdicionalBO implements BaseInterBO <AdicionalVO> {
	AdicionalDAO dao = new AdicionalDAO();
	
	public void inserir(AdicionalVO enity)  throws java.sql.SQLException {
		dao.inserir(enity);
	};
	
	public void remover(AdicionalVO enity) throws SQLException {
		dao.remover(enity);
		
	}
	
	public void editar(AdicionalVO enity) throws SQLException {
		dao.editar(enity);
	}
	
	public List<AdicionalVO> listar() throws SQLException {
		return dao.listar();
	}
}
