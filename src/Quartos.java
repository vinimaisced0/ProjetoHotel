public class Quartos {
    // Definindo uma enumeração para os tipos de quarto
    public enum TipoQuarto {
        SOLTEIRO, CASAL, SUITE
    }
    public enum StatusQuarto{
        DISPONIVEL, OCUPADO, EM_MANUTENCAO
    }
    // Atributos do quarto
    private int numero;
    private TipoQuarto tipo;
    private int capacidade;
    private double precoDiaria;
    private StatusQuarto status;

    // Construtor
    public Quartos(int numero, TipoQuarto tipo, int capacidade, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
        this.status = StatusQuarto.DISPONIVEL;

    }

    // Métodos para ocupar e desocupar o quarto
    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }

    // Getters e setters
    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Tipo: " + tipo + ", Capacidade: " + capacidade +
                " pessoas, Preço da diária: R$" + precoDiaria + ", Status " + status;
    }
}
