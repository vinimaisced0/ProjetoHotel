import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaFuncionario {

    private ArrayList<Funcionario> funcionarios;

    public GerenciaFuncionario() {
        funcionarios = new ArrayList<>();
    }


    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Novo Funcionário cadastrado com sucesso!");
    }


    public void criarECadastrarFuncionario(String nome, String cpf, String cargo, double salarioBase, String turnoDeTrabalho) {
        Funcionario novoFuncionario = new Funcionario(nome, cpf, cargo, salarioBase, turnoDeTrabalho);
        adicionarFuncionario(novoFuncionario);
    }


    public void visualizarHistoricoHoras(String cpf) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getCpf().equals(cpf)) {
                    System.out.println("Histórico de horas trabalhadas do funcionário " + funcionario.getNome() + ":");
                    for (Double horas : funcionario.getHistoricoHoras()) {
                        System.out.println("Horas registradas: " + horas);
                    }
                    return;
                }
            }
            System.out.println("Funcionário não encontrado.");
        }
    }

    
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }


    public void editarFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                Scanner scanner = new Scanner(System.in);
                int opcao;

                do {
                    System.out.println("\nEscolha a informação que deseja editar:");
                    System.out.println("1. Nome");
                    System.out.println("2. CPF");
                    System.out.println("3. Cargo");
                    System.out.println("4. Salário Base");
                    System.out.println("5. Turno de Trabalho");
                    System.out.println("0. Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            funcionario.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;
                        case 2:
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            funcionario.setCpf(novoCpf);
                            System.out.println("CPF atualizado com sucesso!");
                            break;
                        case 3:
                            System.out.print("Novo cargo: ");
                            String novoCargo = scanner.nextLine();
                            funcionario.setCargo(novoCargo);
                            System.out.println("Cargo atualizado com sucesso!");
                            break;
                        case 4:
                            System.out.print("Novo salário base: ");
                            double novoSalarioBase = scanner.nextDouble();
                            funcionario.setSalarioBase(novoSalarioBase);
                            System.out.println("Salário base atualizado com sucesso!");
                            break;
                        case 5:
                            System.out.print("Novo turno de trabalho: ");
                            String novoTurno = scanner.nextLine();
                            funcionario.setTurnoDeTrabalho(novoTurno);
                            System.out.println("Turno de trabalho atualizado com sucesso!");
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
        System.out.println("Funcionário não encontrado.");
    }


    public void registrarHorasFuncionario(String cpf, double horas) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionario.adicionarHoras(horas);
                System.out.println("Horas registradas com sucesso para o funcionário " + funcionario.getNome());
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    // Calcular o salário de um funcionário pelo CPF
    public void calcularSalarioFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                double salario = funcionario.calcularSalario();
                System.out.println("O salário do funcionário " + funcionario.getNome() + " é: R$" + salario);
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salarioBase, String turnoDeTrabalho) {
        Funcionario novoFuncionario = new Funcionario(nome, cpf, cargo, salarioBase, turnoDeTrabalho);
        funcionarios.add(novoFuncionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

}
