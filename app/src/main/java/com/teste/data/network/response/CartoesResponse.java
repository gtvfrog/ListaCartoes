package com.teste.data.network.response;
import com.squareup.moshi.Json;
import com.teste.data.model.Categoria;

public class CartoesResponse {

    @Json(name="name")
    private final String nomeCartao;

    @Json(name="card_numer")
    private final String cardNumber;

    @Json(name="limit")
    private final int limit;

    @Json(name="category")
    private final Categoria categoria;

    public CartoesResponse(String nomeCartao, String cardNumber,int limit,Categoria categoria) {
        this.nomeCartao = nomeCartao;
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.categoria = categoria;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getLimit() {
        return limit;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
