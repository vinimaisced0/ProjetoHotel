import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuQuarto menuQuarto = new MenuQuarto();
        GerenciaHospedes gerenciaHospedes = new GerenciaHospedes();
        GerenciaReserva gerenciaReserva = new GerenciaReserva();
        GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Gerenciamento de QuartosCheck-in/Out");
            System.out.println("2. Gerenciamento de Hóspedes");
            System.out.println("3. Gerenciamento de Reservas");
            System.out.println("4. Gerenciamento de Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuQuarto.exibirMenuQuarto();
                    break;
                case 2:
                    MenuHospede menuHospede = new MenuHospede(gerenciaHospedes);
                    menuHospede.exibirMenuHospedes();
                    break;
                case 3:
                    MenuReserva menuReserva = new MenuReserva(gerenciaReserva);
                    menuReserva.exibirMenuReserva();
                    break;

                case 4:
                    MenuFuncionario menuFuncionario = new MenuFuncionario(gerenciaFuncionario);
                    menuFuncionario.exibirMenuFuncionarios();

                case 0:
                    System.out.println("Saindo.... cuidja...");

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}



