package model.vo;

public class PizzaVOExtends extends PizzaVO {
	private AdicionalVO[] adicionais = new AdicionalVO[0];

	
	public AdicionalVO[] getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(AdicionalVO[] adicionais) {
		if (adicionais != null) {
            boolean isValid = true;
            for (int i = 0; i < adicionais.length; i++) {
                if (adicionais[i] == null) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                this.adicionais = adicionais;
            } else {
                System.out.println("O valor do adicional é inválido");
            }
        } else {
            System.out.println("O vetor é nulo ou vazio");
        }
	}
	public String toString() {
		return super.toString() + adicionais[0].getNome();
	}
}

