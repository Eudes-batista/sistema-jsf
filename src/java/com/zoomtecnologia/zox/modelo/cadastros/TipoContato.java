package com.zoomtecnologia.zox.modelo.cadastros;

public enum TipoContato {
    TELEFONE("T"), CELULAR("C"), EMAIL("E"), WHATSSAP("W"), OUTROS("O");

    private final String value;

    private TipoContato(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
