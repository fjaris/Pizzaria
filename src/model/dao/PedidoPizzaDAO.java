package model.dao;

import model.vo.PedidoVO;
import model.vo.PizzaVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoPizzaDAO extends BaseDAO {

	
	public void inserir(PedidoVO voPedido, PizzaVO voPizza) {
		conn = getConnection();
		String sql = "insert into pedido_pizza (id_pedido, id_pizza) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voPedido.getId());
			ptst.setLong(2, voPizza.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(PedidoVO voPedido, PizzaVO voPizza) {
		conn = getConnection();
		String sql = "delete from pedido_pizza where id_pedido = ? and id_pizza = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voPedido.getId());
			ptst.setLong(2, voPizza.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<PizzaVO> listarPizzasPorPedido(PedidoVO voPedido) {
		conn = getConnection();
		String sql = "select * from pedido_pizza, pizzas where pedido_pizza.id_pedido = ? and pizzas.id = pedido_pizza.id_pizza";
		PreparedStatement ptst;
		ResultSet rs;
		List<PizzaVO> pizzas = new ArrayList<PizzaVO>(); 
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voPedido.getId());
			rs = ptst.executeQuery();
			while(rs.next()) {
				PizzaVO vo = new PizzaVO();
				vo.setId(rs.getLong("pizzas.id"));
				vo.setTipo(rs.getString("pizzas.tipo"));
				vo.setValor(rs.getFloat("pizzas.valor"));
				pizzas.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizzas;
	}
}
	

