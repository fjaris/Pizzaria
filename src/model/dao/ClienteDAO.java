package model.dao;

import model.vo.ClienteVO;
import model.bo.BaseInterBO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO extends BaseDAO implements BaseInterDAO<ClienteVO> {
	
	public void inserir(ClienteVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into clientes (nome, endereço, cpf) values(?,?,?)";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereço());
			ptst.setString(3, vo.getCpf());
			ptst.execute();
	}
	
	public void remover(ClienteVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from clientes where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<ClienteVO> listar() throws SQLException {
		conn = getConnection();
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>(); 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO vo = new ClienteVO();
				vo.setId(rs.getLong("id"));
				vo.setNome(rs.getString("nome"));
				vo.setEndereço(rs.getString("endereï¿½o"));
				vo.setCpf(rs.getString("cpf"));
				clientes.add(vo);
			}
		return clientes;
	}
	
	public void editar(ClienteVO vo) throws SQLException {
		conn = getConnection();
		String sql = "update clientes set nome = ?, endereï¿½o = ?, cpf = ? where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereço());
			ptst.setString(3, vo.getCpf());
			ptst.setLong(4, vo.getId());
			ptst.executeUpdate();
	}
}
