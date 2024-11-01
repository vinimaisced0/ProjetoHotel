import java.util.ArrayList;

public class Funcionario {

    private String nome;
    private String cpf;
    private String cargo;
    private double salarioBase; // Salário base por hora
    private String turnoDeTrabalho;
    private double horasTrabalhadas;
    private ArrayList<Double> historicoHoras;

    // Constructor
    public Funcionario(String nome, String cpf, String cargo, double salarioBase, String turnoDeTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.turnoDeTrabalho = turnoDeTrabalho;
        this.horasTrabalhadas = 0; // Inicializando com 0 horas
        this.historicoHoras = new ArrayList<>();
    }

    // Getters e Setters
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getTurnoDeTrabalho() {
        return turnoDeTrabalho;
    }

    public void setTurnoDeTrabalho(String turnoDeTrabalho) {
        this.turnoDeTrabalho = turnoDeTrabalho;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }


    public void registrarHoras(double horas) {
        if (horas > 0) {
            this.horasTrabalhadas += horas;
        } else {
            System.out.println("Horas inválidas. Digite um valor positivo.");
        }
    }


    public void adicionarHoras(double horas) {
        this.horasTrabalhadas += horas;
    }


    public ArrayList<Double> getHistoricoHoras() {
        return historicoHoras;
    }



    public double calcularSalario() {
        double salario = this.salarioBase * this.horasTrabalhadas; // multiplica pelo salário base
        this.horasTrabalhadas = 0; // resetando após o calculo
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salarioBase=" + salarioBase +
                ", turnoDeTrabalho='" + turnoDeTrabalho + '\'' +
                ", horasTrabalhadas=" + horasTrabalhadas +
                '}';
    }
}