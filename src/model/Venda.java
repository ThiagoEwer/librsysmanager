package model;

import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private double valorTotal;
    private List<Livro> livrosVendidos;
    private Cliente cliente;
    private Funcionario funcionario;

    public Venda(Date data, double valorTotal, List<Livro> livrosVendidos, Cliente cliente, Funcionario funcionario) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.livrosVendidos = livrosVendidos;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Livro> getLivrosVendidos() {
        return livrosVendidos;
    }

    public void setLivrosVendidos(List<Livro> livrosVendidos) {
        this.livrosVendidos = livrosVendidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
