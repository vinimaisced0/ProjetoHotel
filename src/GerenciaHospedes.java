import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaHospedes {

    private ArrayList<Hospede> hospedes;

    public GerenciaHospedes() {
        hospedes = new ArrayList<>();
    }

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
        System.out.println("Novo Hóspede cadastrado com sucesso!");

    }

    public void criarEcadastrarHospede(String nome, String cpf, int datanascimento, String endereco, String telefone) {
        Hospede novoHospede = new Hospede(nome, cpf, datanascimento, endereco, telefone);
        adicionarHospede(novoHospede);

    }

    public void adicionarEstadiaHospede(String nome, String dataHospedagem, int numeroQuarto, int duracao){
        for (Hospede hospede : hospedes) {
            if (hospede.getNome().equals(nome)) {
                Estadia novaEstadia = new Estadia(dataHospedagem, numeroQuarto, duracao);
                hospede.adicionarEstadia(novaEstadia);
                System.out.println("Estadia adicionada com sucesso para " + nome);
                return;
            }
        }
        System.out.println("Hóspede não encontrado.");

    }


    public void visualizarHistorico(String nome) {
        if (hospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
        } else {
            for (Hospede hospede1 : hospedes) {
                if (hospede1.getNome().equals(nome)) {
                    System.out.println("Histórico de estadias de " + nome + ":");
                    for (Estadia estadia : hospede1.getHistoricoEstadias()) {
                        System.out.println(estadia);
                    }
                }
            }
        }
    }


    public void listarHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
        } else {
            for (Hospede hospede1 : hospedes) {
                System.out.println(hospede1);
            }
        }
    }

    public void editarHospede(String nome) {
        for (Hospede hospede : hospedes) {
            if (hospede.getNome().equals(nome)) {
                Scanner scanner = new Scanner(System.in);
                int opcao;

                do {
                    System.out.println("\nEscolha a informação que deseja editar:");
                    System.out.println("1. Nome");
                    System.out.println("2. CPF");
                    System.out.println("3. Data de Nascimento");
                    System.out.println("4. Endereço");
                    System.out.println("5. Telefone");
                    System.out.println("0. Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            if (!novoNome.isEmpty()) {
                                hospede.setNome(novoNome);
                                System.out.println("Nome atualizado com sucesso!");
                            }
                            break;
                        case 2:
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            scanner.nextLine();
                            hospede.setCpf(novoCpf);
                            System.out.println("CPF atualizado com sucesso!");
                            break;
                        case 3:
                            System.out.print("Nova data de nascimento: ");
                            int novaDataNascimento = scanner.nextInt();
                            scanner.nextLine();
                            hospede.setDatanascimento(novaDataNascimento);
                            System.out.println("Data de nascimento atualizada com sucesso!");
                            break;
                        case 4:
                            System.out.print("Novo endereço: ");
                            String novoEndereco = scanner.nextLine();
                            if (!novoEndereco.isEmpty()) {
                                hospede.setEndereco(novoEndereco);
                                System.out.println("Endereço atualizado com sucesso!");
                            }
                            break;
                        case 5:
                            System.out.print("Novo telefone: ");
                            String novoTelefone = scanner.nextLine();
                            hospede.setTelefone(novoTelefone);
                            System.out.println("Telefone atualizado com sucesso!");
                            break;
                        case 0:
                            System.out.println("Edição finalizada.");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } while (opcao != 0);

                return;
            }
        }
        System.out.println("Hóspede não encontrado.");
    }



}



