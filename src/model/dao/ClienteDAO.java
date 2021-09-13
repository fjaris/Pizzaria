package model.dao;

import model.vo.ClienteVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO extends BaseDAO {
	ClienteVO vo;
	
	public void inserir(ClienteVO vo) {
		conn = getConnection();
		String sql = "insert into clientes (nome, endereço, cpf) values(?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereço());
			ptst.setString(3, vo.getCpf());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(ClienteVO vo) {
		conn = getConnection();
		String sql = "delete from clientes where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ClienteVO> listar() {
		conn = getConnection();
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>(); 
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO vo = new ClienteVO();
				vo.setId(rs.getLong("id"));
				vo.setNome(rs.getString("nome"));
				vo.setEndereço(rs.getString("endereço"));
				vo.setCpf(rs.getString("cpf"));
				clientes.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}
	
	public void editar(ClienteVO vo) {
		conn = getConnection();
		String sql = "update clientes set nome = ?, endereço = ?, cpf = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereço());
			ptst.setString(3, vo.getCpf());
			ptst.setLong(4, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
