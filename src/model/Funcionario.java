package model;
import java.util.Date;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private Date dataContratacao;

    public Funcionario(String nome, String cpf, String email, String telefone, Endereco endereco, String cargo, double salario, Date dataContratacao) {
        super(nome, cpf, email, telefone, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

}
