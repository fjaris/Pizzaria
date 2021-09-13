package model.vo;

public class UsuarioVO {
	private long id;
	private String usuario;
	private String senha;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		if (usuario != null) {
			if(usuario.isEmpty()) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.usuario = usuario;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			if(senha.isEmpty()) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.senha = senha;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}	
}















