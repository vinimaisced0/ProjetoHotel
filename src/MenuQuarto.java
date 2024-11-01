import java.util.Scanner;

public class MenuQuarto {

    private Scanner scanner;
    private Quarto quarto;

    public MenuQuarto() {
        this.quarto = quarto;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuQuarto() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Quartos:");
            System.out.println("1. Cadastrar novo quarto");
            System.out.println("2. Listar todos os quartos");
            System.out.println("3. Pesquisar quarto por número");
            System.out.println("4. Alterar status do quarto");
            System.out.println("5. Realizar Check-in");
            System.out.println("6. Realizar Check-out");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarQuarto();
                    break;
                case 2:
                    quarto.listarQuartos();
                    break;
                case 3:
                    pesquisarQuarto();
                    break;
                case 4:
                    alterarStatusQuarto();
                    break;
                case 5:
                    realizarCheckIn();
                    break;
                case 6:
                    realizarCheckOut();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o tipo do quarto (SOLTEIRO, CASAL, SUITE): ");
        String tipoQuartoInput = scanner.nextLine().toUpperCase();
        Quarto.TipoQuarto tipoQuarto;
        try {
            tipoQuarto = Quarto.TipoQuarto.valueOf(tipoQuartoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de quarto inválido. Cadastro cancelado.");
            return;
        }

        System.out.print("Digite a capacidade do quarto: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o preço da diária: ");
        double precoDiaria = scanner.nextDouble();
        scanner.nextLine();

        quarto.criarEAdicionarQuarto(numero, tipoQuarto, capacidade, precoDiaria);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    private void pesquisarQuarto() {
        System.out.print("Digite o número do quarto para pesquisar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Quarto quarto1 = quarto.pesquisarQuarto(numero);
        if (quarto != null) {
            System.out.println("Detalhes do quarto: " + quarto);
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    private void alterarStatusQuarto() {
        System.out.print("Digite o número do quarto para alterar o status: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o novo status do quarto (DISPONIVEL, OCUPADO, EM_MANUTENCAO): ");
        String statusInput = scanner.nextLine().toUpperCase();
        Quarto.StatusQuarto novoStatus;
        try {
            novoStatus = Quarto.StatusQuarto.valueOf(statusInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Status de quarto inválido. Alteração cancelada.");
            return;
        }

        Quarto.alterarStatusQuarto(numero, novoStatus);
    }

    private void realizarCheckIn() {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o CPF do hóspede: ");
        String cpfHospede = scanner.nextLine();

        // Criação do objeto hospede
        Hospede hospede = new Hospede(cpfHospede);

        // CHECK IN
        Quarto.realizarCheckIn(numeroQuarto, hospede);
    }

    private void realizarCheckOut() {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
        String dataCheckIn = scanner.nextLine();

        System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
        String dataCheckOut = scanner.nextLine();

        // Realiza o check-out
        Quarto.realizarCheckOut(numeroQuarto, dataCheckIn, dataCheckOut);
    }
}

