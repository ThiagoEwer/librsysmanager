package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estoque {
    private List<MovimentoEstoque> movimentos;

    public Estoque(List<MovimentoEstoque> movimentos) {
        this.movimentos = movimentos;
    }

    public void adicionarEntrada(int codigoLivro, Date dataEntrada, int quantidade) {
        movimentos.add(new MovimentoEstoque(codigoLivro, dataEntrada, quantidade, TipoMovimento.ENTRADA));
    }

    public void adicionarSaida(int codigoLivro, Date dataSaida, int quantidade) {
        movimentos.add(new MovimentoEstoque(codigoLivro, dataSaida, quantidade, TipoMovimento.SAIDA));
    }

    public List<MovimentoEstoque> getMovimentacoesEstoquePorCodigo(int codigoLivro){
        List<MovimentoEstoque> movEstoqueLivro = new ArrayList<>();

        for (MovimentoEstoque movimento : movimentos) {
            if (movimento.getCodigoLivro() == codigoLivro) {
                movEstoqueLivro.add(movimento);
            }
        }

        return movEstoqueLivro;
    }

    public int getEstoquePorCodigo(int codigoLivro) {
        int total = 0;

        for (MovimentoEstoque movimento : movimentos) {
            if (movimento.getCodigoLivro() == codigoLivro) {
                if (movimento.getTipo() == TipoMovimento.ENTRADA) {
                    total += movimento.getQuantidade();
                } else {
                    total -= movimento.getQuantidade();
                }
            }
        }

        return total;
    }

    public Date getDataEntradaEstoquePorCodigo(int codigoLivro) {
        Date data = null;

        for (MovimentoEstoque movimento : movimentos) {
            if (movimento.getCodigoLivro() == codigoLivro) {
                if (movimento.getTipo() == TipoMovimento.ENTRADA) {
                    data = movimento.getDataMovimento();
                    return data;
                }
            }
        }

        return data;
    }
}
