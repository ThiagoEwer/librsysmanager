package model;

public enum TipoMovimento {
    ENTRADA(1),
    SAIDA(2);

    private final int index;

    TipoMovimento(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
