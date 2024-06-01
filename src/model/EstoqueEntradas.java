package model;

import java.util.Date;

public class EstoqueEntradas {
    
    private int codigoLivro;
    private Date dataEntrada;
    private int totalEntrada;

    public EstoqueEntradas(int codigoLivro, Date dataEntrada, int totalEntrada){
        this.codigoLivro = codigoLivro;
        this.dataEntrada = dataEntrada;
        this.totalEntrada = totalEntrada;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public int getTotalEntrada() {
        return totalEntrada;
    }
}
