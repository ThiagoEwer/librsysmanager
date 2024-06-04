package model;

public class Carrinho {
    
    private int idCliente;
    private int idFuncionario;
    private Livro livroSelecionado;
    private int quantidadeLivro;

    public Carrinho(int idCliente, int idFuncionario, Livro livro, int quantidadeLivro){
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.livroSelecionado = livro;
        this.quantidadeLivro = quantidadeLivro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public Livro getLivroSelecionado() {
        return livroSelecionado;
    }

    public int getQuantidadeLivro() {
        return quantidadeLivro;
    }
}
