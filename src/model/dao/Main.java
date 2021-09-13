package model.dao;

import java.util.List;

import model.vo.AdicionalVO;
import model.vo.ClienteVO;
import model.vo.Estado;
import model.vo.EstoqueVO;
import model.vo.PedidoVO;
import model.vo.PizzaVO;
import model.vo.Tamanho;
import model.vo.UsuarioVO;

public class Main {

	public static void main(String[] args) {
		BaseDAO teste = new BaseDAO();
		System.out.println(teste.getConnection());
		ClienteDAO daoteste = new ClienteDAO();
		AdicionalDAO daoteste2 = new AdicionalDAO();
		EstoqueDAO daoteste3 = new EstoqueDAO();
		PizzaDAO daoteste4 = new PizzaDAO();
		UsuarioDAO daoteste5 = new UsuarioDAO();
		PedidoDAO daoteste6 = new PedidoDAO();
		PedidoPizzaDAO daoteste7 = new PedidoPizzaDAO();
		PedidoAdicionalDAO daoteste8 = new PedidoAdicionalDAO();
		
		
		AdicionalVO adicional = new AdicionalVO();
		adicional.setId(2);
		adicional.setNome("Calabresa");
		adicional.setValor(6);
		
		
		PizzaVO voPizza = new PizzaVO();
		voPizza.setTipo("5 Queijos");
		voPizza.setValor(34);
		voPizza.setId(3);
		
		ClienteVO vo = new ClienteVO();
		vo.setNome("jujuju");
		vo.setCpf("713.444.444-44");
		vo.setEndereço("jajaj");
		vo.setId(2);
		
		
		PedidoVO vo2 = new PedidoVO();
		vo2.setCliente(vo);
		vo2.setId(2);
		
		List<AdicionalVO> adicionais = daoteste8.listarAdicionaisPorPizza(vo2, voPizza);
		for(AdicionalVO voUsuario22: adicionais) {
		System.out.println(voUsuario22.getId() + " " + voUsuario22.getId());
		}
		
		daoteste8.listarAdicionaisPorPizza(vo2, voPizza);

		
		
//		List<AdicionalVO> adicionais = daoteste8.listarAdicionaisPorPizza(vo2, voPizza);
//		for(AdicionalVO voUsuario22: adicionais) {
//		System.out.println(voUsuario22.getId() + " " + voUsuario22.getId());
//		}
//		
//		daoteste8.listarAdicionaisPorPizza(vo2, voPizza);
		
//		List<PizzaVO> pizzas = daoteste7.listarPizzasPorPedido(vo2);
//		
//		for(PizzaVO voUsuario22: pizzas) {
//		System.out.println(voUsuario22.getId() + " " + voUsuario22.getId());
//	}
//		
//		daoteste7.listarPizzasPorPedido(vo2);
		
		
		
		

		
//		vo.setNome("Junior3");
//		vo.setEndereço("Rua Maria de Lourdes de Medeiros");
//		vo.setCpf("713.423.434-73");
		
//		
//		PedidoVO voPedido = new PedidoVO();
//		voPedido.setCliente(vo);
//		voPedido.setTamanho(Tamanho.G);
//		voPedido.setEstado(Estado.PEDIDO_REALIZADO);
//		voPedido.setValor(50);
//		voPedido.setId(2);
//		
//		daoteste6.editar(voPedido);
		
		
		
//		UsuarioVO voUsuario = new UsuarioVO();
//		voUsuario.setUsuario("junior");
//		voUsuario.setSenha("12345");
//		
//		
//		
//		
//		UsuarioVO voUsuario2 = new UsuarioVO();
//		voUsuario2.setUsuario("inhegaz");
//		voUsuario2.setSenha("12345");
//		voUsuario2.setId(1);
//		
//		List<UsuarioVO> usuarios = daoteste5.listar();
//		
//		for(UsuarioVO voUsuario22: usuarios) {
//		System.out.println(voUsuario22.getId() + voUsuario22.getUsuario() + voUsuario22.getSenha());
//	}
		
		
		
		
		
		/*EstoqueVO voEstoque = new EstoqueVO();
		voEstoque.setItem("Queijo");
		voEstoque.setQuantidade(5);
		
		daoteste3.inserir(voEstoque);*/
		
		/*AdicionalVO voEdit = new AdicionalVO();
		voEdit.setNome("carne");
		voEdit.setValor(20);
		voEdit.setId(2);
		
		daoteste2.editar(voEdit);*/


		/*ClienteVO vo2 = new ClienteVO();
		vo2.setNome("Joany");
		vo2.setEndereço("Rua Padre João Urbano");
		vo2.setCpf("111.111.111-11");
		vo.setId(new Long(2));
		
		daoteste.remover(vo);*/
		/*daoteste.editar(vo2);*/
		
		/*daoteste.inserir(vo);
		daoteste.remover(vo);*/
		/*List<ClienteVO> clientes = daoteste.listar();*/
		
		/*for(ClienteVO vo2: clientes) {
			System.out.println(vo2.getId() + vo2.getNome() + vo2.getEndereço() + vo2.getCpf());
		}*/
	}
	
}