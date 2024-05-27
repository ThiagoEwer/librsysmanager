package model;

import java.util.Date;

public class Promocao {
    private String descricao;
    private double desconto;
    private Date dataInicio;
    private Date dataFim;

    public Promocao(String descricao, double desconto, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.desconto = desconto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
