import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciaQuartos gerenciaQuartos = new GerenciaQuartos();
        GerenciaHospedes gerenciaHospedes = new GerenciaHospedes();
        GerenciaReserva gerenciaReserva = new GerenciaReserva();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Gerenciamento de Quartos");
            System.out.println("2. Gerenciamento de Hóspedes");
            System.out.println("3. Gerenciamento de Reservas");
            System.out.println("4. Gerenciamento de Funcionários");
            System.out.println("5. Check-In / Check-Out");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    MenuQuarto menuQuarto = new MenuQuarto(gerenciaQuartos);
                    menuQuarto.exibirMenu();
                    break;
                case 2:
                    MenuHospede menuHospede = new MenuHospede(gerenciaHospedes);
                    menuHospede.exibirMenuHospedes();
                    break;
                case 3:
                    MenuReserva menuReserva = new MenuReserva(gerenciaReserva);
                    menuReserva.exibirMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}



