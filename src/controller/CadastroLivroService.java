package controller;

import mock.MockDados;
import model.Livro;
import model.EstoqueEntradas;

import java.util.Date;
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

            // Gerar um ID único para o livro
            int id = repository.gerarIdUnicoParaLivro();

            // Criar um novo livro com as informações fornecidas
            Livro novoLivro = new Livro(id, titulo, autor, ISBN, preco, quantidadeEmEstoque);

            // Adicionar a data de entrada do livro
            novoLivro.setDataEntrada(new Date());

            // Adicionar o livro ao repositório
            repository.addLivro(novoLivro);

            // Adicionar entrada de estoque
            repository.addEntradaEstoque(new EstoqueEntradas(id, new Date(), quantidadeEmEstoque));

            System.out.println("Livro cadastrado com sucesso!");

            // Exibir lista de livros cadastrados
            System.out.println("Livros cadastrados:");
            for (Livro livro : repository.getLivros()) {
                System.out.println("ID: " + livro.getCodigo() + ", Título: " + livro.getTitulo() +
                        ", Autor: " + livro.getAutor() + ", Data de Entrada: " + livro.getDataEntrada());
            }

            // Verificar se o usuário deseja cadastrar outro livro
            System.out.print("Deseja cadastrar outro livro? (S/N): ");
            String resposta = tec.next();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
            // Limpar o buffer do tec
            tec.nextLine();
        }
    }
}
