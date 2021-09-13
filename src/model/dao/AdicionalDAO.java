package model.dao;

import model.vo.AdicionalVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdicionalDAO extends BaseDAO {
	AdicionalVO vo;
	
	public void inserir(AdicionalVO vo) {
		conn = getConnection();
		String sql = "insert into adicionais (nome, valor) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setDouble(2, vo.getValor());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AdicionalVO vo) {
		conn = getConnection();
		String sql = "delete from adicionais where id = ?";
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
	
	public List<AdicionalVO> listar() {
		conn = getConnection();
		String sql = "select * from adicionais";
		Statement st;
		ResultSet rs;
		List<AdicionalVO> adicionais = new ArrayList<AdicionalVO>(); 
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AdicionalVO vo = new AdicionalVO();
				vo.setId(rs.getLong("id"));
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				adicionais.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adicionais;
	}
	
	public void editar(AdicionalVO vo) {
		conn = getConnection();
		String sql = "update adicionais set nome = ?, valor = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setFloat(2, vo.getValor());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
