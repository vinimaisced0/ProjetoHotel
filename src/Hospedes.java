import java.util.ArrayList;
import java.util.List;

public class Hospedes {

    private String nome;
    private int cpf;
    private int datanascimento;
    private String endereco;
    private int telefone;
    private int dataHospedagem;


    private List<Estadia> historicoEstadias;

    public Hospedes(String nome, int cpf, int datanascimento, String endereco, int telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataHospedagem = dataHospedagem;
        this.historicoEstadias = new ArrayList<>();
    }

    public void adicionarEstadia(Estadia estadia) {
        historicoEstadias.add(estadia);
    }

    public List<Estadia> getHistoricoEstadias() {
        return historicoEstadias;
    }


    public int getDatahospedagem() {
        return dataHospedagem;
    }

    public void setDatahospedagem(int datahospedagem) {
        this.dataHospedagem = datahospedagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(int datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}



