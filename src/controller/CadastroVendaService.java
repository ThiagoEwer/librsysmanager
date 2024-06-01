package controller;

import mock.MockDados;
import model.Cliente;
import model.Funcionario;
import model.Livro;
import model.Venda;
import service.VendaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CadastroVendaService {

    public static void cadastrarVenda(MockDados repository) {
        Scanner tec = new Scanner(System.in);
        VendaService vendaService = new VendaService(repository);

        while (true) {
            System.out.println("Cadastro de Vendas");

            // Exibir clientes disponíveis
            System.out.println("Clientes disponíveis:");
            for (int i = 0; i < repository.getClientes().size(); i++) {
                System.out.println(i + " - " + repository.getClientes().get(i).getNome());
            }

            // Selecionar Cliente
            System.out.print("Selecione o cliente (pelo número) ou -1 para prosseguir sem cadastrar: ");
            int clienteIndex = tec.nextInt();
            tec.nextLine();

            Cliente cliente = null;
            if (clienteIndex != -1 && clienteIndex < repository.getClientes().size()) {
                cliente = repository.getClientes().get(clienteIndex);
            } else {
                System.out.println("Prosseguindo sem cadastrar o cliente.");
            }

            // Selecionar Funcionario
            System.out.println("Funcionários disponíveis:");
            for (int i = 0; i < repository.getFuncionarios().size(); i++) {
                System.out.println(i + " - " + repository.getFuncionarios().get(i).getNome());
            }
            System.out.print("Selecione o funcionário (pelo número): ");
            int funcionarioIndex = tec.nextInt();
            tec.nextLine(); // Limpar o buffer do tec
            Funcionario funcionario = repository.getFuncionarios().get(funcionarioIndex);

            // Selecionar Livros
            List<Livro> livrosVendidos = new ArrayList<>();
            while (true) {
                System.out.println("Livros disponíveis:");
                for (int i = 0; i < repository.getLivros().size(); i++) {
                    Livro livro = repository.getLivros().get(i);
                    System.out.println(i + " - " + livro.getTitulo() + " (Preço: " + livro.getPreco() + ") - Estoque: " + livro.getQuantidadeEmEstoque());
                }
                System.out.print("Selecione o livro (pelo número) ou -1 para finalizar: ");
                int livroIndex = tec.nextInt();
                tec.nextLine();
                if (livroIndex == -1) {
                    break;
                }
                Livro livroSelecionado = repository.getLivros().get(livroIndex);
                System.out.print("Quantidade desejada: ");
                int quantidadeDesejada = tec.nextInt();
                tec.nextLine();
                if (quantidadeDesejada <= livroSelecionado.getQuantidadeEmEstoque()) {
                    // Se a quantidade desejada estiver disponível em estoque, adicionamos à lista de livros vendidos
                    for (int i = 0; i < quantidadeDesejada; i++) {
                        livrosVendidos.add(livroSelecionado);
                    }
                } else {
                    // Caso contrário, exibimos uma mensagem informando que não há estoque suficiente
                    System.out.println("Não há estoque suficiente para o livro selecionado. Quantidade disponível em estoque: " + livroSelecionado.getQuantidadeEmEstoque());
                }
            }

            // Adicionar Venda
            Date data = new Date();
            vendaService.adicionarVenda(data, livrosVendidos, cliente, funcionario);

            System.out.println("Venda cadastrada com sucesso!");

            // Exibir recibo
            Venda venda = vendaService.listarVendas().get(vendaService.listarVendas().size() - 1); // Última venda realizada
            System.out.println("\nRECIBO");
            System.out.println("Data da venda: " + venda.getData());
            if (cliente != null) {
                System.out.println("Cliente: " + venda.getCliente().getNome());
            }
            System.out.println("Funcionário: " + venda.getFuncionario().getNome());
            System.out.println("Livros comprados:");
            for (Livro livro : venda.getLivrosVendidos()) {
                System.out.println("- " + livro.getTitulo() + " - Quantidade: 1");
            }
            System.out.println("Valor total: R$ " + venda.getValorTotal());

            // Cadastrar outra venda
            System.out.print("Deseja cadastrar outra venda? (S/N): ");
            String resposta = tec.next();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
            tec.nextLine();
    }
  }
}