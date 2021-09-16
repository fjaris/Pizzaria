package model.vo;

public class PizzaVO {
	private long id;
	private String tipo;
	private float valor;
	
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		if (tipo != null) {
			if (tipo.isEmpty()) {
				System.out.println("Entrada inválida! Digite um tipo de pizza.");
			}
			else {
				this.tipo = tipo;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite um tipo de pizza.");
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
	
	public String toString() {
		return "id: " + getId() + " tipo: " + getTipo() + " valor: " + getValor();
	}
}	
	
	
