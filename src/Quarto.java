import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Quarto {
    // Definindo uma enumeração para os tipos de quarto
    public enum TipoQuarto {
        SOLTEIRO, CASAL, SUITE
    }

    public enum StatusQuarto {
        DISPONIVEL, OCUPADO, EM_MANUTENCAO
    }

    // Atributos do quarto
    private int numero; // número do quarto
    private TipoQuarto tipo; // tipo de quarto
    private int capacidade; // capacidade do quarto
    private double precoDiaria; // preço do quarto por dia
    private StatusQuarto status; // status do quarto
    private Hospede hospede; // hóspede associado ao quarto

    private static ArrayList<Quarto> quartos = new ArrayList<>(); // Lista de quartos

    // Construtor
    public Quarto(int numero, TipoQuarto tipo, int capacidade, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
        this.status = StatusQuarto.DISPONIVEL; // inicializando disponível
    }


    public static void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
        System.out.println("Novo quarto cadastrado com sucesso!");
    }

    public static void criarEAdicionarQuarto(int numero, TipoQuarto tipo, int capacidade, double precoDiaria) {
        Quarto novoQuarto = new Quarto(numero, tipo, capacidade, precoDiaria);
        adicionarQuarto(novoQuarto);
    }

    public static void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (Quarto quarto : quartos) {
                System.out.println(quarto);
            }
        }
    }

    public static Quarto pesquisarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public static void alterarStatusQuarto(int numero, StatusQuarto novoStatus) {
        Quarto quarto = pesquisarQuarto(numero);
        if (quarto != null) {
            quarto.setStatus(novoStatus);
            System.out.println("Status do quarto alterado para " + novoStatus + " com sucesso!");
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    // check-in e check-out
    public static void realizarCheckIn(int numeroQuarto, Hospede hospede) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                if (quarto.getStatus() == StatusQuarto.DISPONIVEL) {
                    quarto.setStatus(StatusQuarto.OCUPADO);
                    quarto.setHospede(hospede);
                    System.out.println("Check-in realizado com sucesso para o hóspede " + hospede.getNome());
                } else {
                    System.out.println("Quarto não disponível para check-in.");
                }
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public static void realizarCheckOut(int numeroQuarto, String dataCheckIn, String dataCheckOut) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.getStatus() == StatusQuarto.OCUPADO) {
                try {
                    Date checkIn = formatoData.parse(dataCheckIn);
                    Date checkOut = formatoData.parse(dataCheckOut);

                    if (checkOut.after(checkIn)) {
                        long diferencaEmMilissegundos = checkOut.getTime() - checkIn.getTime();
                        long dias = diferencaEmMilissegundos / (1000 * 60 * 60 * 24);
                        double valorTotal = dias * quarto.getPrecoDiaria();

                        quarto.setStatus(StatusQuarto.DISPONIVEL);
                        quarto.setHospede(null);

                        System.out.println("Check-out realizado com sucesso.");
                        System.out.println("Total a ser pago: R$" + valorTotal);
                    } else {
                        System.out.println("Data de check-out deve ser posterior à data de check-in.");
                    }
                } catch (ParseException e) {
                    System.out.println("Erro: formate as datas corretamente (dd/MM/yyyy).");
                }
                return;
            }
        }
        System.out.println("Quarto não encontrado ou já está disponível.");
    }

    // Getters e Setters
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

    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Tipo: " + tipo + ", Capacidade: " + capacidade +
                " pessoas, Preço da diária: R$" + precoDiaria + ", Status: " + status +
                ", Hóspede: " + (hospede != null ? hospede.getNome() : "Nenhum");
    }
}
