import java.util.ArrayList;

public class GerenciaHospedes {

    private ArrayList<Hospedes> hospedes;

    public GerenciaHospedes() {
        hospedes = new ArrayList<>();
    }

    public void adicionarHospede(Hospedes hospede) {
        hospedes.add(hospede);
        System.out.println("Novo Hóspede cadastrado com sucesso!");

    }

    public void criarEcadastrarHospede(String nome, int cpf, int datanascimento, String endereco, int telefone) {
        Hospedes novoHospede = new Hospedes(nome, cpf, datanascimento, endereco, telefone);
        adicionarHospede(novoHospede);

    }

    public void adicionarEstadiaHospede(String nome, String dataHospedagem, int numeroQuarto, int duracao){
        for (Hospedes hospede : hospedes) {
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
            for (Hospedes hospedes1 : hospedes) {
                if (hospedes1.getNome().equals(nome)) {
                    System.out.println("Histórico de estadias de " + nome + ":");
                    for (Estadia estadia : hospedes1.getHistoricoEstadias()) {
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
            for (Hospedes hospedes1 : hospedes) {
                System.out.println(hospedes1);
            }
        }
    }


}



