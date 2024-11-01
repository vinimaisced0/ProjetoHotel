import java.util.ArrayList;

public class GerenciaQuartos {

    private ArrayList<Quartos> quartos;

    public GerenciaQuartos() {
        quartos = new ArrayList<>();
    }

    public void adicionarQuartos(Quartos quarto) {
        quartos.add(quarto);
        System.out.println("Novo quarto cadastrado com sucesso!");
    }

    public void criarEAdicionarQuarto(int numero, Quartos.TipoQuarto tipo, int capacidade, double precoDiaria) {
        Quartos novoQuarto = new Quartos(numero, tipo, capacidade, precoDiaria);
        adicionarQuartos(novoQuarto);

    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (Quartos quartos1 : quartos) {
                System.out.println(quartos1);
            }
        }
    }

    public Quartos pesquisarQuartos(int numero) {
        for (Quartos quartos1 : quartos) {
            if (quartos1.getNumero() == numero) {
                return quartos1;
            }
        }
        return null;
    }

    public void alterarStatusQuartos(int numero, Quartos.StatusQuarto novoStatus) {
        // Faz a pesquisa do quarto com base no número
        Quartos quarto = pesquisarQuartos(numero);

        // Se o quarto for encontrado
        if (quarto != null) {
            // Alterna o status de ocupado
            quarto.setStatus(novoStatus);
            System.out.println("\nStatus do quarto alterado para " + novoStatus + " com sucesso!");
            } else{
                System.out.println("Quarto não encontrado.");
            }
        }
    }



