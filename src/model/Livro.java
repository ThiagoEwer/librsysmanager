package model;

import java.util.Date;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private String ISBN;
    private double preco;
    private int quantidadeEmEstoque;
    private Date dataEntrada;

    public Livro(int codigo, String titulo, String autor, String ISBN, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }
}
