import java.util.Scanner;

public class MenuReserva {

    private GerenciaReserva gerenciaReserva;
    private Scanner scanner;

    public MenuReserva(GerenciaReserva gerenciaReserva) {
        this.gerenciaReserva = gerenciaReserva;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuReserva() {
        int opcao;

        do {
            System.out.println("\nMenu de Gerenciamento de Reservas: ");
            System.out.println("1 - Criar reservas");
            System.out.println("2 - Cancelar reservas");
            System.out.println("3 - Verificar disponibilidade de quartos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    criarReserva();
                    break;
                case 2:
                    gerenciaReserva.cancelarReserva();
                    break;
                case 3:
                    verificarDisponibilidade();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void criarReserva() {
        System.out.print("Nome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Data de entrada (dd-MM-yyyy): ");
        String dataEntrada = scanner.nextLine();
        System.out.print("Data de saída (dd-MM-yyyy): ");
        String dataSaida = scanner.nextLine();
        System.out.print("Tipo de quarto (1 - SOLTEIRO, 2 - CASAL, 3 - SUITE): ");
        int tipoQuarto = scanner.nextInt();
        Quartos.TipoQuarto tipo = Quartos.TipoQuarto.values()[tipoQuarto - 1];
        System.out.print("Capacidade de hóspedes: ");
        int capacidadeHospedes = scanner.nextInt();

        try {
            gerenciaReserva.adicionarReservaHospede(numeroQuarto, nome, dataEntrada, dataSaida, tipo, capacidadeHospedes);
        } catch (DataException e) {
            System.out.println("Erro ao criar a reserva: " + e.getMessage());
        }
    }

    private void verificarDisponibilidade() {
        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Data de entrada (dd-MM-yyyy): ");
        String dataEntrada = scanner.nextLine();
        System.out.print("Data de saída (dd-MM-yyyy): ");
        String dataSaida = scanner.nextLine();

        boolean disponivel = gerenciaReserva.verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida);
        if (disponivel) {
            System.out.println("O quarto está disponível para as datas selecionadas.");
        } else {
            System.out.println("O quarto não está disponível para as datas selecionadas");
        }
    }
}
