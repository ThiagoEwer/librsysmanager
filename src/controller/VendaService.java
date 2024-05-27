package controller;
import model.*;
import mock.MockDados;

import java.util.Date;
import java.util.List;


public class VendaService {
    private MockDados repository;

    public VendaService(MockDados repository) {
        this.repository = repository;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : repository.getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void realizarVenda(Cliente cliente, Funcionario funcionario, List<Livro> livrosComprados) {
        double valorTotal = 0.0;
        for (Livro livro : livrosComprados) {
            valorTotal += livro.getPreco();
        }

        Venda venda = new Venda(new Date(), valorTotal, livrosComprados, cliente, funcionario);
        repository.addVenda(venda);
    }

    public List<Venda> consultarVendas() {
        return repository.getVendas();
    }

    public List<Livro> listarLivros() {
        return repository.getLivros();
    }
}