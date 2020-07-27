package com.teste.data.network.response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;
public interface CartoesService {
    @GET("https://github.com/policante/Coopercard-mobile/blob/master/service/cards.json")
    Call<CartoesResult> obterCartoes();
}
