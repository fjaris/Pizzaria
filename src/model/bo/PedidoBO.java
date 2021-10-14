package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.PedidoAdicionalDAO;
import model.dao.PedidoDAO;
import model.dao.PedidoPizzaDAO;
import model.vo.AdicionalVO;
import model.vo.PedidoVO;
import model.vo.PizzaVO;
import model.vo.PizzaVOExtends;

public class PedidoBO implements BaseInterBO <PedidoVO> {
	PedidoDAO daoPedido = new PedidoDAO();
	PedidoAdicionalDAO daoPedidoAdicional = new PedidoAdicionalDAO();
	PedidoPizzaDAO daoPedidoPizza = new PedidoPizzaDAO();
	
	public void inserir(PedidoVO enity) throws java.sql.SQLException {
		daoPedido.inserir(enity);
	};
	public void editar(PedidoVO enity) throws java.sql.SQLException {
		daoPedido.editar(enity);
	};
	public void remover(PedidoVO enity) throws SQLException {
		for (PizzaVOExtends pizza : enity.getPizzas()) {
			for(AdicionalVO adicional : pizza.getAdicionais()) {
				daoPedidoAdicional.remover(enity, pizza, adicional);
			}
			daoPedidoPizza.remover(enity, pizza);
		}
		daoPedido.remover(enity);
	};
	public List<PedidoVO> listar() throws SQLException {
		return daoPedido.listar();
	}
	
	public void inserirPizza(PedidoVO pedido, PizzaVO pizza) throws java.sql.SQLException {
		daoPedidoPizza.inserir(pedido, pizza);
	}
	
	public void inserirAdicional(PizzaVO pizza, AdicionalVO adicional, PedidoVO pedido) throws java.sql.SQLException {
		daoPedidoAdicional.inserir(adicional, pizza, pedido);
	}
	
	public void removerPizza(PedidoVO pedido, PizzaVO pizza) throws java.sql.SQLException {
		daoPedidoPizza.remover(pedido, pizza);
	}
	
	public void removerAdicional(PizzaVO pizza, AdicionalVO adicional, PedidoVO pedido) throws java.sql.SQLException {
		daoPedidoAdicional.remover(pedido, pizza, adicional);
	}
}
