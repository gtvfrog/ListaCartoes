package com.teste.data.mapper;

import com.teste.data.model.Cartao;
import com.teste.data.network.response.CartoesResponse;
import java.util.ArrayList;
import java.util.List;

public class CartaoMapper {
    public static List<Cartao> deResponseParaDominio(List<CartoesResponse> listaFilmeResponse) {
        List<Cartao> listacartoes = new ArrayList<>();

        for (CartoesResponse cartaoResponse : listaFilmeResponse) {
            final Cartao cartao = new Cartao(cartaoResponse.getNomeCartao(), cartaoResponse.getCardNumber(),cartaoResponse.getLimit(),cartaoResponse.getCategoria());
            listacartoes.add(cartao);
        }

        return listacartoes;
    }
}
