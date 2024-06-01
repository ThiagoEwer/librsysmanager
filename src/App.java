import controller.CadastroLivroService;
import controller.VendaService;
import mock.MockDados;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GUI.CadastroClientesForm;
import GUI.MenuPrincipal;

public class App {
    public static void main(String[] args) {
        MockDados repository = new MockDados();

        // Abre o JFrame do MENU PRINCIPAL
        // new MenuPrincipal(repository).setVisible(true);

        // FLUXO DE VENDAS
        /*  
        VendaService vendaService = new VendaService(repository);
        
        Scanner tec = new Scanner(System.in);
        System.out.print("Informe o CPF do cliente: ");
        String cpf = tec.nextLine();

        //Buscarpor CPF
        Cliente cliente = vendaService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não cadastrado. Por favor, realize o cadastro.");
            return;
        }

        System.out.println("Bem-vindo, " + cliente.getNome());

        //livros disponíveis
        List<Livro> livrosDisponiveis = vendaService.listarLivros();
        System.out.println("Livros disponíveis para compra:");
        for (int i = 0; i < livrosDisponiveis.size(); i++) {
            Livro livro = livrosDisponiveis.get(i);
            System.out.println((i + 1) + ". " + livro.getTitulo() + " - R$ " + livro.getPreco());
        }

        List<Livro> livrosComprados = new ArrayList<>();
        System.out.println("Digite o número do livro que deseja comprar (ou 0 para finalizar):");
        while (true) {
            int escolha = tec.nextInt();
            if (escolha == 0) {
                break;
            }
            if (escolha > 0 && escolha <= livrosDisponiveis.size()) {
                livrosComprados.add(livrosDisponiveis.get(escolha - 1));
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
        

        if (livrosComprados.isEmpty()) {
            System.out.println("Nenhum livro selecionado para compra.");
            return;
        }

        // Selec funcionario
        Funcionario funcionario = repository.getFuncionarios().get(0); // Carlos Souza

        //Realizar a venda
        vendaService.realizarVenda(cliente, funcionario, livrosComprados);

        List<Venda> vendas = vendaService.consultarVendas();
        System.out.println("Vendas realizadas:");
        vendas.forEach(venda -> {
            System.out.println("Venda realizada em: " + venda.getData());
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Funcionário: " + venda.getFuncionario().getNome());
            System.out.println("Livros Comprados: ");
            venda.getLivrosVendidos().forEach(livro -> {
                System.out.println(" - " + livro.getTitulo());
            });
            System.out.println("Valor Total: " + venda.getValorTotal());
            System.out.println("---------------------------");
        });
        */

        // FLUXO DE CADASTRO DE LIVROS
       CadastroLivroService.cadastrarLivro(repository);
    }
}
