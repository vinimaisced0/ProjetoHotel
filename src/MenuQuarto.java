import java.util.Scanner;

public class MenuQuarto {
    private GerenciaQuartos gerenciaQuartos;
    private Scanner scanner;

    public MenuQuarto(GerenciaQuartos gerenciaQuartos) {
        this.gerenciaQuartos = gerenciaQuartos;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Quartos:");
            System.out.println("1. Cadastrar novo quarto");
            System.out.println("2. Listar todos os quartos");
            System.out.println("3. Pesquisar quarto por número");
            System.out.println("4. Alterar status do quarto");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarQuarto();
                    break;
                case 2:
                    gerenciaQuartos.listarQuartos();
                    break;
                case 3:
                    pesquisarQuarto();
                    break;
                case 4:
                    alterarStatusQuarto();
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
        Quartos.TipoQuarto tipoQuarto;
        try {
            tipoQuarto = Quartos.TipoQuarto.valueOf(tipoQuartoInput);
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

        gerenciaQuartos.criarEAdicionarQuarto(numero, tipoQuarto, capacidade, precoDiaria);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    private void pesquisarQuarto() {
        System.out.print("Digite o número do quarto para pesquisar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Quartos quarto = gerenciaQuartos.pesquisarQuartos(numero);
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
        Quartos.StatusQuarto novoStatus;
        try {
            novoStatus = Quartos.StatusQuarto.valueOf(statusInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Status de quarto inválido. Alteração cancelada.");
            return;
        }

        gerenciaQuartos.alterarStatusQuartos(numero, novoStatus);
    }
}
