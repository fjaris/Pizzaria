package model.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseInterDAO <VO> {
	public void inserir(VO enity) throws SQLException;
	public void editar(VO enity) throws SQLException;
	public void remover(VO enity) throws SQLException;
	public List<VO> listar() throws SQLException;
	
}
