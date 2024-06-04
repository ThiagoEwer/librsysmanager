package model;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private String ISBN;
    private double preco;

    //Construtor dados Mocados
    public Livro(int codigo, String titulo, String autor, String ISBN, double preco) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.preco = preco;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Livro outroLivro = (Livro) obj;
        return codigo == outroLivro.codigo;
    }
}
