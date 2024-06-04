package model;

import java.util.Date;
import java.util.List;

public class Venda {
    private static int idCounter = 0;
    private int id;
    private Date data;
    private double valorTotal;
    private List<Livro> livrosVendidos;
    private Cliente cliente;
    private Funcionario funcionario;

    public Venda(Date data, double valorTotal, List<Livro> livrosVendidos, Cliente cliente, Funcionario funcionario) {
        this.id = ++idCounter;
        this.data = data;
        this.valorTotal = valorTotal;
        this.livrosVendidos = livrosVendidos;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        double vt = 0;
        for (Livro livro : livrosVendidos) {
            vt += livro.getPreco();
        }
        return vt;
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

    public String getVendaDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venda ID: ").append(id).append("\n")
          .append("Data: ").append(data).append("\n")
          .append("Valor Total: ").append(valorTotal).append("\n")
          .append("Cliente: ").append(cliente.getNome()).append("\n")
          .append("Funcionário: ").append(funcionario.getNome()).append("\n")
          .append("Livros Vendidos:\n");

        for (Livro livro : livrosVendidos) {
            sb.append("  - ").append(livro.getTitulo()).append(" (").append(livro.getAutor()).append(")\n");
        }

        return sb.toString();
    }
}
