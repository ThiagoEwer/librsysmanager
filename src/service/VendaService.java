package service;

import mock.MockDados;
import model.Cliente;
import model.Funcionario;
import model.Livro;
import model.Venda;

import java.util.Date;
import java.util.List;

public class VendaService {
    private MockDados mockDados;

    public VendaService(MockDados mockDados) {
        this.mockDados = mockDados;
    }

    public void adicionarVenda(Date data, List<Livro> livrosVendidos, Cliente cliente, Funcionario funcionario) {
        double valorTotal = calcularValorTotal(livrosVendidos);
        Venda novaVenda = new Venda(data, valorTotal, livrosVendidos, cliente, funcionario);
        mockDados.addVenda(novaVenda);
    }

    private double calcularValorTotal(List<Livro> livrosVendidos) {
        double total = 0.0;
        for (Livro livro : livrosVendidos) {
            total += livro.getPreco();
        }
        return total;
    }

    public List<Venda> listarVendas() {
        return mockDados.getVendas();
    }

    public void imprimirDetalhesDasVendas() {
        for (Venda venda : mockDados.getVendas()) {
            System.out.println(venda.getVendaDetalhes());
        }
    }
}
