package model.dao;

import model.vo.Tamanho;
import model.vo.ClienteVO;
import model.vo.Estado;
import model.vo.PedidoVO;
import model.vo.PizzaVOExtends;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO extends BaseDAO implements BaseInterDAO<PedidoVO> {
	PedidoPizzaDAO pizzadao = new PedidoPizzaDAO();
	
	public void inserir(PedidoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into pedidos (cliente_id, tamanho, estado, valor) values(?,?,?,?)";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getCliente().getId());
			ptst.setString(2, vo.getTamanho().toString());
			ptst.setString(3, vo.getEstado().toString());
			ptst.setFloat(4, vo.getValor());
			ptst.execute();
	}
	
	public void remover(PedidoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from pedidos where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<PedidoVO> listar() throws SQLException {
		conn = getConnection();
		String sql = "select * from pedidos";
		Statement st;
		ResultSet rs;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>(); 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PedidoVO vo = new PedidoVO();
				String StringTamanho = rs.getString("tamanho");
				Tamanho enumTamanho = Tamanho.P;
				switch(StringTamanho) {
					case "P":
						enumTamanho = Tamanho.P;
						break;
					case "M":
						enumTamanho = Tamanho.M;
						break;
					case "G":
						enumTamanho = Tamanho.G;
						break;
				}
				String StringEstado = rs.getString("estado");
				Estado enumEstado = Estado.PEDIDO_REALIZADO;
				switch(StringEstado) {
					case "PEDIDO_REALIZADO":
						enumEstado = Estado.PEDIDO_REALIZADO;
						break;
					case "EM_ANDAMENTO":
						enumEstado = Estado.EM_ANDAMENTO;
						break;
					case "FINALIZADO":
						enumEstado = Estado.FINALIZADO;
						break;
				}
				vo.setId(rs.getLong("id"));
				vo.setTamanho(enumTamanho);
				vo.setEstado(enumEstado);
				vo.setValor(rs.getFloat("valor"));
				List<PizzaVOExtends> pizzas = pizzadao.ListarPizzaPorPedido(vo);
				PizzaVOExtends[] pizzasPedido = new PizzaVOExtends[pizzas.size()];
				pizzas.toArray(pizzasPedido);
				vo.setPizzas(pizzasPedido);
				pedidos.add(vo);
			}
		return pedidos;
	}
	
	public void editar(PedidoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "update pedidos set cliente_id = ?, tamanho = ?, estado = ?, valor = ? where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getCliente().getId());
			ptst.setString(2, vo.getTamanho().toString());
			ptst.setString(3, vo.getEstado().toString());
			ptst.setFloat(4, vo.getValor());
			ptst.setLong(5, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<PedidoVO> BuscarPedido(ClienteVO vo) throws SQLException {
		conn = getConnection();
		String sql = "select * from pedidos, clientes where clientes.nome like ? and pedidos.cliente_id = clientes.id";
		PreparedStatement ptst;
		ResultSet rs;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		ClienteVO cliente = new ClienteVO();
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,"%" + cliente.getNome() + "%");
			rs = ptst.executeQuery();
			while(rs.next()) {
				PedidoVO voPedido = new PedidoVO();
				voPedido.setId(rs.getLong("pedidos.id"));
				cliente.setId(rs.getLong("clientes.id"));
				cliente.setNome(rs.getString("clientes.nome"));
				cliente.setCpf(rs.getString("clientes.cpf"));
				cliente.setEnderešo(rs.getString("clientes.enderešo"));
				voPedido.setValor(rs.getFloat("valor"));
				String StringTamanho = rs.getString("tamanho");
				Tamanho enumTamanho = Tamanho.P;
				switch(StringTamanho) {
					case "P":
						enumTamanho = Tamanho.P;
						break;
					case "M":
						enumTamanho = Tamanho.M;
						break;
					case "G":
						enumTamanho = Tamanho.G;
						break;
				}
				String StringEstado = rs.getString("estado");
				Estado enumEstado = Estado.PEDIDO_REALIZADO;
				switch(StringEstado) {
					case "PEDIDO_REALIZADO":
						enumEstado = Estado.PEDIDO_REALIZADO;
						break;
					case "EM_ANDAMENTO":
						enumEstado = Estado.EM_ANDAMENTO;
						break;
					case "FINALIZADO":
						enumEstado = Estado.FINALIZADO;
						break;
				}
				voPedido.setTamanho(enumTamanho);
				voPedido.setEstado(enumEstado);
				voPedido.setCliente(cliente);
				List<PizzaVOExtends> pizzas = pizzadao.ListarPizzaPorPedido(voPedido);
				PizzaVOExtends[] pizzasPedido = new PizzaVOExtends[pizzas.size()];
				pizzas.toArray(pizzasPedido);
				voPedido.setPizzas(pizzasPedido);
				pedidos.add(voPedido);
			}
		return pedidos;
	}
	public List<PedidoVO> BuscarPedidoPorEstado(PedidoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "select * from pedidos, clientes where pedidos.estado = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		ClienteVO cliente = new ClienteVO();
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,"%" + vo.getEstado().toString() + "%");
			rs = ptst.executeQuery();
			while(rs.next()) {
				PedidoVO voPedido = new PedidoVO();
				voPedido.setId(rs.getLong("pedidos.id"));
				cliente.setId(rs.getLong("clientes.id"));
				cliente.setNome(rs.getString("clientes.nome"));
				cliente.setCpf(rs.getString("clientes.cpf"));
				cliente.setEnderešo(rs.getString("clientes.enderešo"));
				voPedido.setValor(rs.getFloat("valor"));
				String StringTamanho = rs.getString("tamanho");
				Tamanho enumTamanho = Tamanho.P;
				switch(StringTamanho) {
					case "P":
						enumTamanho = Tamanho.P;
						break;
					case "M":
						enumTamanho = Tamanho.M;
						break;
					case "G":
						enumTamanho = Tamanho.G;
						break;
				}
				voPedido.setTamanho(enumTamanho);
				voPedido.setEstado(vo.getEstado());
				voPedido.setCliente(cliente);
				List<PizzaVOExtends> pizzas = pizzadao.ListarPizzaPorPedido(voPedido);
				PizzaVOExtends[] pizzasPedido = new PizzaVOExtends[pizzas.size()];
				pizzas.toArray(pizzasPedido);
				voPedido.setPizzas(pizzasPedido);
				pedidos.add(voPedido);
			}
		return pedidos;
	}
}
