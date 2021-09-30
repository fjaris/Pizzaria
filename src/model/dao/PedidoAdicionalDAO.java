package model.dao;

import model.vo.AdicionalVO;
import model.vo.PedidoVO;
import model.vo.PizzaVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PedidoAdicionalDAO extends BaseDAO  {

	
	public void inserir(AdicionalVO voAdicional, PizzaVO voPizza, PedidoVO voPedido) {
		conn = getConnection();
		String sql = "insert into pedido_pizza_adicional (id_adicional, id_pedido, id_pizza) values(?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voAdicional.getId());
			ptst.setLong(2, voPedido.getId());
			ptst.setLong(3, voPizza.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(PedidoVO voPedido, PizzaVO voPizza, AdicionalVO voAdicional) {
		conn = getConnection();
		String sql = "delete from pedido_pizza where id_pedido = ? and id_pizza = ? and id_adicional = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voAdicional.getId());
			ptst.setLong(2, voPizza.getId());
			ptst.setLong(3, voPedido.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AdicionalVO> listarAdicionaisPorPizza(PedidoVO voPedido, PizzaVO voPizza) {
		conn = getConnection();
		String sql = "select * from pedido_pizza_adicional, adicionais where pedido_pizza_adicional.id_pedido = ? and pedido_pizza_adicional.id_pizza = ? and adicionais.id = pedido_pizza_adicional.id_adicional";
		PreparedStatement ptst;
		ResultSet rs;
		List<AdicionalVO> adicionais = new ArrayList<AdicionalVO>(); 
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, voPedido.getId());
			ptst.setLong(2, voPizza.getId());
			rs = ptst.executeQuery();
			while(rs.next()) {
				AdicionalVO vo = new AdicionalVO();
				vo.setId(rs.getLong("adicionais.id"));
				vo.setNome(rs.getString("adicionais.nome"));
				vo.setValor(rs.getFloat("adicionais.valor"));
				adicionais.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adicionais;
	}
}
	
