package model;

public class Livro {
    private String titulo;
    private String autor;
    private String ISBN;
    private double preco;
    private int quantidadeEmEstoque;

//construtor
    public Livro(String titulo, String autor, String ISBN, double preco, int quantidadeEmEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
//gets&setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

}