package model.vo;

public class EstoqueVO {
	private long id;
	private String item;
	private int quantidade;
	
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		if (item != null) {
			if (item.isEmpty()) {
				System.out.println("Entrada inválida! Digite um nome.");
			}
			else {
				this.item = item;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite um nome.");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade < 0) {
			System.out.println("O número informado não pode ser menor que 0");
		} else {
			this.quantidade = quantidade;
		}
	}
}	

