//  switch (opcao) {
//                case 1:
//                    int subOpcao;
//                    do {
//                        System.out.println("\nGerenciamento de Quartos:");
//                        System.out.println("1. Cadastrar novos quartos");
//                        System.out.println("2. Visualizar quartos");
//                        System.out.println("3. Atualizar o status de um quarto");
//                        System.out.println("0. Voltar ao menu principal");
//                        System.out.print("Escolha uma opção: ");
//                        subOpcao = scanner.nextInt();
//                        scanner.nextLine();
//
//                        switch (subOpcao) {
//                            case 1:
//                                System.out.print("Digite o número do quarto: ");
//                                int numero = scanner.nextInt();
//                                scanner.nextLine();
//
//                                System.out.print("Digite o tipo do quarto (SOLTEIRO, CASAL, SUITE): ");
//                                String tipo = scanner.nextLine().toUpperCase();
//
//                                System.out.print("Digite a capacidade do quarto: ");
//                                int capacidade = scanner.nextInt();
//
//                                System.out.print("Digite o preço da diária: ");
//                                double precoDiaria = scanner.nextDouble();
//                                scanner.nextLine();
//
//                                // converte String para TipoQuarto e adicionar quarto
//                                try {
//                                    Quartos.TipoQuarto tipoQuarto = Quartos.TipoQuarto.valueOf(tipo);
//                                    gerenciaQuartos.criarEAdicionarQuarto(numero, tipoQuarto, capacidade, precoDiaria);
//                                    System.out.println("Quarto cadastrado com sucesso!");
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println("Tipo de quarto inválido. Use SOLTEIRO, CASAL ou SUITE.");
//                                }
//                                break;
//
//                            case 2:
//                                System.out.println("Quartos cadastrados:");
//                                gerenciaQuartos.listarQuartos();
//                                break;
//
//                            case 3:
//                                System.out.print("Digite o número do quarto para alterar o status: ");
//                                int numeroQuarto = scanner.nextInt();
//                                scanner.nextLine(); // Consumir a quebra de linha
//
//                                System.out.print("Digite o novo status (DISPONIVEL, OCUPADO, EM_MANUTENCAO): ");
//                                String statusStr = scanner.nextLine().toUpperCase();
//
//                                try {
//                                    Quartos.StatusQuarto novoStatus = Quartos.StatusQuarto.valueOf(statusStr);
//                                    gerenciaQuartos.alterarStatusQuartos(numeroQuarto, novoStatus);
//                                } catch (IllegalArgumentException e) {
//                                    System.out.println("Status inválido.");
//                                }
//                                break;
//
//                            case 0:
//                                System.out.println("Voltando ao menu principal...");
//                                break;
//
//                            default:
//                                System.out.println("Opção inválida. Tente novamente.");
//                                break;
//                        }
//                    } while (subOpcao != 0);
//                    break;
//
//                case 0:
//                    System.out.println("Saindo do sistema...");
//                    break;
//
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//                    break;
//
//
//                case 2:
//                    int subOpcao2;
//                    do{
//                        System.out.println("\nGerenciamento de Hóspedes:");
//                        System.out.println("1. Cadastrar novos hóspede");
//                        System.out.println("2. Listar hóspedes");
//                        System.out.println("3. Visualizar histórico de estadias: ");
//                        System.out.println("4. Editar informações dos hóspedes: ");
//                        System.out.println("0. Voltar ao menu principal");
//                        System.out.print("Escolha uma opção: ");
//                        subOpcao2 = scanner.nextInt();
//                        scanner.nextLine();
//
//                   switch (subOpcao2){
//                       case 1:
//                           System.out.print("Digite o nome do hóspede: ");
//                           String nome = scanner.next();
//                           scanner.nextLine();
//
//                           System.out.print("Digite o CPF do hóspede: ");
//                           String cpfInput = scanner.nextLine();
//
//                           try {
//                               Validar.validarCPF(cpfInput); // lança CPFException se o CPF for inválido
//                               int cpf = Integer.parseInt(cpfInput); // apenas se o CPF for válido
//                               System.out.print("Digite a data de nascimento: ");
//                               int datanascimento = scanner.nextInt();
//
//
//                           } catch (CPFException e) {
//                               System.out.println(e.getMessage()); // mensagem da exceção
//                           }
//
//                           System.out.print("Digite a data de nascimento: ");
//                           int datanascimento = scanner.nextInt();
//
//                           System.out.print("Digite o preço da diária: ");
//                           double precoDiaria = scanner.nextDouble();
//                           scanner.nextLine();
//                            break;
//
//
//                       case 2:
//                           System.out.println("Hóspedes cadastrados: ");
//                           //GerenciaHospedes.listarHospedes();
//                           break;
//
//                       case 3:
//
//                   }
//
//                    } while(subOpcao2 != 0);
//                        break;
//
//
//
//
//
//            }
//
//
//
//
//
//
//        } while (opcao != 0);
//
//        scanner.close();
//    }
//
//}