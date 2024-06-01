package model;

import java.util.Date;

public class MovimentoEstoque {
    private int codigoLivro;
    private Date dataMovimento;
    private int quantidade;
    private TipoMovimento tipo;

    public MovimentoEstoque(int codigoLivro, Date dataMovimento, int quantidade, TipoMovimento tipo) {
        this.codigoLivro = codigoLivro;
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }
}
