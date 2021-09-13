package model.vo;

public class AdicionalVO {
	private long id;
	private String nome;
	private float valor;
	
	public Long getId() {
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

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		if(valor < 0) {
			System.out.println("O número informado não pode ser menor que 0");
		} else {
			this.valor = valor;
		}
	}
}
