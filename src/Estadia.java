public class Estadia {
    private String dataHospedagem;
    private int numeroQuarto;
    private int duracao; // em dias!!

    public Estadia(String dataHospedagem, int numeroQuarto, int duracao) {
        this.dataHospedagem = dataHospedagem;
        this.numeroQuarto = numeroQuarto;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Data: " + dataHospedagem + ", Quarto: " + numeroQuarto + ", Duração: " + duracao + " dias";
    }
}
