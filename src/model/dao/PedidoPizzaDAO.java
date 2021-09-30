package model.dao;

import model.vo.AdicionalVO;
import model.vo.PedidoVO;
import model.vo.PizzaVO;
import model.vo.PizzaVOExtends;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PedidoPizzaDAO extends BaseDAO {
	private AdicionalDAO adicionalDAO = new AdicionalDAO();
	
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
	
	public List<PizzaVOExtends> ListarPizzaPorPedido(PedidoVO vo) {
		conn = getConnection();
		String sql = "select * from pizzas, pedidos, pedido_pizza where pedidos.id = ? and pedido_pizza.id_pedido = pedidos.id and pizzas.id = pedido_pizza.id_pizza";
		PreparedStatement ptst;
		ResultSet rs;
		List<PizzaVOExtends> pizzas = new ArrayList<PizzaVOExtends>(); 
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			rs = ptst.executeQuery();
			while(rs.next()) {
				PizzaVOExtends voPizza = new PizzaVOExtends(); 
				voPizza.setId(rs.getLong("id"));
				voPizza.setTipo(rs.getString("tipo"));
				voPizza.setValor(rs.getFloat("valor"));
				List<AdicionalVO> adicionais = adicionalDAO.listarPorPizzasEmPedido(vo, voPizza);
				AdicionalVO[] adicionaisPizzas = new AdicionalVO[adicionais.size()];
				adicionais.toArray(adicionaisPizzas);
				voPizza.setAdicionais(adicionaisPizzas);
				pizzas.add(voPizza);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizzas;
	}
}
	

