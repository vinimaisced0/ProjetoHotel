import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class GerenciaReserva {

    private ArrayList<Reserva> reservas;
    private Scanner scanner;

    public GerenciaReserva() {
        reservas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Novo Hóspede cadastrado com sucesso!");

    }


    public void adicionarReservaHospede(int numeroQuarto, String nome, String dataEntrada, String dataSaida, Quartos.TipoQuarto tipo, int capacidadeHospedes) {
        try {
            boolean disponivel = verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida);
            if (!disponivel) {
                System.out.println("Quarto não disponível para as datas selecionadas.");
                return; // Não adiciona a reserva se o quarto não estiver disponível
            }

            // Criar a nova reserva
            Reserva novaReserva = new Reserva(numeroQuarto,nome, dataEntrada, dataSaida, tipo, capacidadeHospedes);
            novaReserva.setNumeroQuarto(numeroQuarto); // Define o número do quarto
            adicionarReserva(novaReserva);
            System.out.println("Reserva adicionada com sucesso para " + nome);
        } catch (DataException e) {
            System.out.println("Erro ao verificar disponibilidade: " + e.getMessage());
        }

    }

    public void cancelarReserva(){
        listarReservas();

        if (reservas.isEmpty()){
            System.out.println("Nenhuma reserva cadastrada para cancelar");
            return;
        }

        System.out.println("Escolha o número da reserva que deseja cancelar: ");
        int numeroReserva = scanner.nextInt();
        scanner.nextLine();

        if (numeroReserva < 1 || numeroReserva > reservas.size()) {
            System.out.println("Número de reserva inválida.");
            return;
        }

        reservas.remove(numeroReserva - 1);
        System.out.println("Reserva cancelada com sucesso");

    }

    public void listarReservas(){
        if (reservas.isEmpty()){
            System.out.println("Nenhuma reserva cadastrada no momento");
        } else {
            System.out.println("Reservas cadastradas: ");
            for (int i = 0; i < reservas.size(); i++) {
                System.out.println((i + 1) + ", " + reservas.get(i));
            }
        }


    }

    public boolean verificarDisponibilidade(int numeroQuarto, String dataEntrada, String dataSaida) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date entrada = sdf.parse(dataEntrada);
            Date saida = sdf.parse(dataSaida);

            for (Reserva reserva : reservas) {

                if (reserva.getNumeroQuarto() == numeroQuarto) {
                    Date dataReservaEntrada = sdf.parse(reserva.getDataEntrada());
                    Date dataReservaSaida = sdf.parse(reserva.getDataSaida());

                    // Verifica as datas
                    if ((entrada.after(dataReservaEntrada) && entrada.before(dataReservaSaida)) ||
                            (saida.after(dataReservaEntrada) && saida.before(dataReservaSaida)) ||
                            (entrada.equals(dataReservaEntrada) || saida.equals(dataReservaSaida))) {
                        return false; // Quarto não disponível
                    }
                }
            }
        } catch (ParseException e) {
            System.out.println("Erro ao analisar as datas: " + e.getMessage());
        }

        return true; // Quarto disponível
    }
}

















