package model.dao;

import model.vo.Tamanho;
import model.vo.Estado;
import model.vo.PedidoVO;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO extends BaseDAO {
	PedidoVO vo;
	
	public void inserir(PedidoVO vo) {
		conn = getConnection();
		String sql = "insert into pedidos (cliente_id, tamanho, estado, valor) values(?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getCliente().getId());
			ptst.setString(2, vo.getTamanho().toString());
			ptst.setString(3, vo.getEstado().toString());
			ptst.setFloat(4, vo.getValor());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(PedidoVO vo) {
		conn = getConnection();
		String sql = "delete from pedidos where id = ?";
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
	
	public List<PedidoVO> listar() {
		conn = getConnection();
		String sql = "select * from pedidos";
		Statement st;
		ResultSet rs;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>(); 
		try {
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
				pedidos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedidos;
	}
	
	public void editar(PedidoVO vo) {
		conn = getConnection();
		String sql = "update pedidos set cliente_id = ?, tamanho = ?, estado = ?, valor = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getCliente().getId());
			ptst.setString(2, vo.getTamanho().toString());
			ptst.setString(3, vo.getEstado().toString());
			ptst.setFloat(4, vo.getValor());
			ptst.setLong(5, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
