package model.dao;

import model.vo.EstoqueVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EstoqueDAO extends BaseDAO implements BaseInterDAO<EstoqueVO> {
	

	public void inserir(EstoqueVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into estoque (item, quantidade) values(?,?)";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getItem());
			ptst.setInt(2, vo.getQuantidade());
			ptst.execute();
	}
	
	public void remover(EstoqueVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from estoque where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<EstoqueVO> listar() throws SQLException {
		conn = getConnection();
		String sql = "select * from estoque";
		Statement st;
		ResultSet rs;
		List<EstoqueVO> estoque = new ArrayList<EstoqueVO>(); 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EstoqueVO vo = new EstoqueVO();
				vo.setId(rs.getLong("id"));
				vo.setItem(rs.getString("item"));
				vo.setQuantidade(rs.getInt("quantidade"));
				estoque.add(vo);
			}
		return estoque;
	}
	
	public void editar(EstoqueVO vo) throws SQLException {
		conn = getConnection();
		String sql = "update estoque set item = ?, quantidade = ? where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getItem());
			ptst.setInt(2, vo.getQuantidade());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
	}
}

