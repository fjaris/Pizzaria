package model.dao;

import model.vo.PizzaVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PizzaDAO extends BaseDAO implements BaseInterDAO<PizzaVO>{


	public void inserir(PizzaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into pizzas (tipo, valor) values(?,?)";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTipo());
			ptst.setFloat(2, vo.getValor());
			ptst.execute();
	}
	
	public void remover(PizzaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from pizzas where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<PizzaVO> listar() throws SQLException {
		conn = getConnection();
		String sql = "select * from pizzas";
		Statement st;
		ResultSet rs;
		List<PizzaVO> pizzas = new ArrayList<PizzaVO>(); 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PizzaVO vo = new PizzaVO();
				vo.setId(rs.getLong("id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setValor(rs.getFloat("valor"));
				pizzas.add(vo);
			}
		return pizzas;
	}
	
	public void editar(PizzaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "update pizzas set tipo = ?, valor = ? where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTipo());
			ptst.setFloat(2, vo.getValor());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<PizzaVO> BuscarPizzaPorTipo(PizzaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "select * from pizzas where tipo like ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<PizzaVO> pizzas = new ArrayList<PizzaVO>(); 
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,"%" + vo.getTipo() + "%");
			rs = ptst.executeQuery();
			while(rs.next()) {
				PizzaVO voPizza = new PizzaVO(); 
				voPizza.setId(rs.getLong("id"));
				voPizza.setTipo(rs.getString("tipo"));
				voPizza.setValor(rs.getFloat("valor"));
				pizzas.add(voPizza);
			}
		return pizzas;
	}
}





