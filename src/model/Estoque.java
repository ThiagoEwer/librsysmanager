package model;

import java.util.List;

public class Estoque {
    private List<EstoqueEntradas> entradas;
    private List<EstoqueSaidas> saidas;

    public int getEstoquePorCodigo(int codigoLivro){
        int total = 0;

        for (EstoqueEntradas totalEntrada : entradas) {
            if(totalEntrada.getCodigoLivro() == codigoLivro){
                total += totalEntrada.getTotalEntrada();
            }  
        }

        for (EstoqueSaidas totalSaida : saidas) {
            if(totalSaida.getCodigoLivro() == codigoLivro){
                total -= totalSaida.getTotalSaida();
            }
        }

        return total;
    }
}