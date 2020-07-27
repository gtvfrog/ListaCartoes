package com.teste.data.network;

import com.teste.data.network.response.CartoesService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {
    private static CartoesService INSTANCE;

    public static CartoesService getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(CartoesService.class);
        }

        return INSTANCE;
    }
}
