package com.teste.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class CartoesResult {
    @Json(name = "results")
    private final List<CartoesResponse> resultadoCartoes;

    public CartoesResult(List<CartoesResponse> resultadoCartoes) {
        this.resultadoCartoes = resultadoCartoes;
    }

    public List<CartoesResponse> getResultadoCartoes() {
        return resultadoCartoes;
    }
}
