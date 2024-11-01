public class Reserva {

    private int numeroQuarto;
    private String nome;
    private String dataEntrada;
    private String dataSaida;
    private Quartos.TipoQuarto tipo;
    private int capacidadeHospedes;


    public Reserva(int numeroQuarto ,String nome, String dataEntrada, String dataSaida, Quartos.TipoQuarto tipo, int capacidadeHospedes) {
        this.numeroQuarto = numeroQuarto;
        this.nome = nome;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipo = tipo;
        this.capacidadeHospedes = capacidadeHospedes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Quartos.TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(Quartos.TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadeHospedes() {
        return capacidadeHospedes;
    }

    public void setCapacidadeHospedes(int capacidadeHospedes) {
        this.capacidadeHospedes = capacidadeHospedes;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nome='" + nome + '\'' +
                ", dataEntrada='" + dataEntrada + '\'' +
                ", dataSaida='" + dataSaida + '\'' +
                ", tipo=" + tipo +
                ", capacidadeHospedes=" + capacidadeHospedes +
                ", numeroQuarto=" + numeroQuarto + // Adicione a vírgula
                '}';
    }
}

