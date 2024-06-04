//import controller.CadastroLivroService;
//import controller.CadastroVendaService;
import mock.MockDados;
//import model.*;
//import service.VendaService;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

//import GUI.CadastroClientesForm;
import GUI.MenuPrincipal;

public class App {
    public static void main(String[] args) {
        MockDados repository = new MockDados();
        //Scanner tec = new Scanner(System.in);

        // Abre o JFrame do MENU PRINCIPAL
        new MenuPrincipal(repository).setVisible(true);


        // NOVO FLUXO DE CADASTRO E VENDAS DE LIVROS
        // while (true) {
        //     System.out.println("Menu Principal:");
        //     System.out.println("1 - Cadastrar Livro");
        //     System.out.println("2 - Cadastrar Venda");
        //     System.out.println("3 - Sair");
        //     System.out.print("Selecione uma opção: ");
        //     int opcao = tec.nextInt();

        //     switch (opcao) {
        //         case 1:
        //             CadastroLivroService.cadastrarLivro(repository);
        //             break;
        //         case 2:
        //             CadastroVendaService.cadastrarVenda(repository);
        //             break;
        //         case 3:
        //             System.out.println("Saindo...");
        //             return;
        //         default:
        //             System.out.println("Opção inválida. Tente novamente.");
        //     }
        // }
    }
}
