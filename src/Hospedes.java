import java.util.ArrayList;
import java.util.List;

public class Hospedes {

    private String nome;
    private String cpf;
    private int datanascimento;
    private String endereco;
    private String telefone;
    private int dataHospedagem;


    private List<Estadia> historicoEstadias;

    public Hospedes(String nome, String cpf, int datanascimento, String endereco, String telefone) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Hóspede{" +
                "Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Data de Nascimento='" + datanascimento + '\'' +
                ", Endereço='" + endereco + '\'' +
                ", Telefone='" + telefone + '\'' +
                '}';
    }
}

