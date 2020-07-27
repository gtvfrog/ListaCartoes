package com.teste.data.model;

import java.io.Serializable;

public class Cartao  implements Serializable {
    private final String name;
    private final String card_number;
    private final int limit;
    private final Categoria categoria;

    public Cartao(String name, String card_number, int limit, Categoria categoria) {
        this.name = name;
        this.card_number = card_number;
        this.limit = limit;
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public String getCard_number() {
        return card_number;
    }

    public int getLimit() {
        return limit;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
