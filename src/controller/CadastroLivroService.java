package controller;

import mock.MockDados;
import model.Livro;

import java.util.Scanner;

public class CadastroLivroService {

    public static void cadastrarLivro(MockDados repository) {
        Scanner tec = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Livros");

            // Solicitar informações do livro
            System.out.print("Título: ");
            String titulo = tec.nextLine();

            System.out.print("Autor: ");
            String autor = tec.nextLine();

            System.out.print("ISBN: ");
            String ISBN = tec.nextLine();

            System.out.print("Preço: ");
            double preco = tec.nextDouble();

            System.out.print("Quantidade em Estoque: ");
            int quantidadeEmEstoque = tec.nextInt();

            // Gerar O ID o livro
            int id = repository.gerarIdUnicoParaLivro();

            // Cria o novo livro com os dados fornecidos
            //Livro novoLivro = new Livro(id, titulo, autor, ISBN, preco, quantidadeEmEstoque, new java.util.Date());

            // Adicionar o livro ao repositório
            //repository.addLivro(novoLivro);

            System.out.println("Livro cadastrado com sucesso!");

            // Exibir lista de livros cadastrados
            // System.out.println("Livros cadastrados:");
            // for (Livro livro : repository.getLivros()) {
            //     System.out.println("ID: " + livro.getCodigo() + ", Título: " + livro.getTitulo() +
            //             ", Autor: " + livro.getAutor() + ", Data de Entrada: " + livro.getDataEntrada());
            // }

            //cadastrar outro livro
            System.out.print("Deseja cadastrar outro livro? (S/N): ");
            String resposta = tec.next();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
            tec.nextLine();
        }
    }
}
