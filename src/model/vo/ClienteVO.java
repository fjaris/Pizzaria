package model.vo;

public class ClienteVO {
	private long id;
	private String nome;
	private String endereço;
	private String cpf;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null) {
			if (nome.isEmpty()) {
				System.out.println("Entrada inválida! Digite um nome.");
			}
			else {
				this.nome = nome;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite um nome.");
		}
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		if (endereço != null) {
			if (endereço.isEmpty()) {
				System.out.println("Entrada inválida! Digite um endereço.");
			}
			else {
				this.endereço = endereço;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite um endereço.");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (cpf != null) {
			if (cpf.length() < 14 || cpf.length() > 14 || !cpf.substring(0, 3).matches("[0-9]*") || !cpf.substring(3, 4).matches("[.]*") ||
					!cpf.substring(4, 7).matches("[0-9]*")	|| !cpf.substring(7, 8).matches("[.]*") || !cpf.substring(8, 11).matches("[0-9]*") || !cpf.substring(11, 12).matches("[-]*")
					|| !cpf.substring(12, 14).matches("[0-9]*")) {
				System.out.println("Entrada de CPF inválida! Use o formato xxx.xxx.xxx-xx");
			}
			else {
				this.cpf = cpf;
			}
		}
		else {
			System.out.println("Entrada de CPF inválida! Use o formato xxx.xxx.xxx-xx");
		}
	}
}

