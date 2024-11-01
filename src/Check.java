import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Check {

    private String numero; // número do quarto
    private String status; // status do quarto (disponível ou ocupado)
    private Hospede hospede; // hospede associado ao quarto
    private double precoCadaDia; // preço do quarto por dia

    private static ArrayList<Check> checks = new ArrayList<>(); // Lista de quartos

    // Construtor
    public Check(String numero, double precoCadaDia) {
        this.numero = numero;
        this.precoCadaDia = precoCadaDia;
        this.status = "disponível"; // inicializando disponível
    }


    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public double getPrecoCadaDia() {
        return precoCadaDia;
    }

    // Check-in
    public static void realizarCheckIn(String numeroQuarto, Hospede hospede) {
        for (Check check : checks) {
            if (check.getNumero().equals(numeroQuarto)) {
                if (check.getStatus().equals("disponível")) {
                    check.setStatus("ocupado");
                    check.setHospede(hospede);
                    System.out.println("Check-in realizado com sucesso para o hóspede " + hospede.getNome());
                } else {
                    System.out.println("Quarto não disponível para check-in.");
                }
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    // Check-out
    public static void realizarCheckOut(String numeroQuarto, String dataCheckIn, String dataCheckOut) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        for (Check check : checks) {
            if (check.getNumero().equals(numeroQuarto) && check.getStatus().equals("ocupado")) {
                try {
                    Date checkIn = formatoData.parse(dataCheckIn);
                    Date checkOut = formatoData.parse(dataCheckOut);

                    if (checkOut.after(checkIn)) {
                        long diferencaEmMilissegundos = checkOut.getTime() - checkIn.getTime();
                        long dias = diferencaEmMilissegundos / (1000 * 60 * 60 * 24);
                        double valorTotal = dias * check.getPrecoCadaDia();

                        check.setStatus("disponível");
                        check.setHospede(null);

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


    public static void listarQuartos() {
        for (Check check : checks) {
            System.out.println(check);
        }
    }


    public static void adicionarQuarto(Check check) {
        checks.add(check);
        System.out.println("Quarto " + check.getNumero() + " adicionado com sucesso!");
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero='" + numero + '\'' +
                ", status='" + status + '\'' +
                ", hospede=" + (hospede != null ? hospede.getNome() : "Nenhum") +
                ", precoPorDia=" + precoCadaDia +
                '}';
    }
}