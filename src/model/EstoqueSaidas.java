package model;

import java.util.Date;

public class EstoqueSaidas {
    
    private int codigoLivro;
    private Date dataSaida;
    private int totalSaida;

    public EstoqueSaidas(int codigoLivro, Date dataSaida, int totalSaida){
        this.codigoLivro = codigoLivro;
        this.dataSaida = dataSaida;
        this.totalSaida = totalSaida;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public int getTotalSaida() {
        return totalSaida;
    }

}
