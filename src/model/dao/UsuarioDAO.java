package model.dao;


import model.vo.UsuarioVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDAO implements BaseInterDAO<UsuarioVO> {

	public void inserir(UsuarioVO vo) {
		conn = getConnection();
		String sql = "insert into usuarios (usuario, senha) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getUsuario());
			ptst.setString(2, vo.getSenha());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(UsuarioVO vo) {
		conn = getConnection();
		String sql = "delete from usuarios where id = ?";
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
	
	public List<UsuarioVO> listar() {
		conn = getConnection();
		String sql = "select * from usuarios";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>(); 
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO vo = new UsuarioVO();
				vo.setId(rs.getLong("id"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setSenha(rs.getString("senha"));
				usuarios.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void editar(UsuarioVO vo) { 
		conn = getConnection();
		String sql = "update usuarios set usuario = ?, senha = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getUsuario());
			ptst.setString(2, vo.getSenha());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
