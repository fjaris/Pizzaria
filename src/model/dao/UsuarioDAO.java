package model.dao;


import model.vo.UsuarioVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDAO implements BaseInterDAO<UsuarioVO> {

	public void inserir(UsuarioVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into usuarios (usuario, senha) values(?,?)";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getUsuario());
			ptst.setString(2, vo.getSenha());
			ptst.execute();
	}
	
	public void remover(UsuarioVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from usuarios where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
	}
	
	public List<UsuarioVO> listar() throws SQLException {
		conn = getConnection();
		String sql = "select * from usuarios";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>(); 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO vo = new UsuarioVO();
				vo.setId(rs.getLong("id"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setSenha(rs.getString("senha"));
				usuarios.add(vo);
			}
		return usuarios;
	}
	
	public void editar(UsuarioVO vo) throws SQLException { 
		conn = getConnection();
		String sql = "update usuarios set usuario = ?, senha = ? where id = ?";
		PreparedStatement ptst;
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getUsuario());
			ptst.setString(2, vo.getSenha());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
	}
	
	public UsuarioVO buscarPorLogin(UsuarioVO voLogin) throws SQLException {
		conn = getConnection();
		String sql = "select * from usuarios where usuario = ?";
		PreparedStatement st;
		ResultSet rs;
		UsuarioVO usuario = null; 
			st = conn.prepareStatement(sql);
			st.setString(1, voLogin.getUsuario());
			rs = st.executeQuery();
			if(rs.next()) {
				usuario = new UsuarioVO();
				usuario.setId(rs.getLong("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
			}
		return usuario;
	}
}
