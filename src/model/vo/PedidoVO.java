package model.vo;

public class PedidoVO {
    private long id;
    private ClienteVO cliente;
    private PizzaVOExtends[] pizzas;
    private Tamanho tamanho;
    private Estado estado;
    private float valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        if (cliente != null) {
            if (!cliente.getNome().isEmpty() && !cliente.getCpf().isEmpty() && !cliente.getEndere�o().isEmpty()) {
                this.cliente = cliente;
            }
        } else {
            System.out.println("O valor de cliente � inv�lido");
        }
    }

    public PizzaVOExtends[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(PizzaVOExtends[] pizzas) {
        if (pizzas != null && pizzas.length > 0) {
            boolean isValid = true;
            for (int i = 0; i < pizzas.length; i++) {
                if (pizzas[i] == null) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                this.pizzas = pizzas;
            } else {
                System.out.println("O valor da pizza � inv�lido");
            }
        } else {
            System.out.println("O vetor � nulo ou vazio");
        }
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        if (tamanho != null) {
            this.tamanho = tamanho;
        } else {
            System.out.println("O valor do tamanho est� incorreto!");
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            System.out.println("O valor do estado est� incorreto!");
        }
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor < 0) {
            System.out.println("O n�mero informado n�o pode ser menor que 0");
        } else {
            this.valor = valor;
        }
    }
}
