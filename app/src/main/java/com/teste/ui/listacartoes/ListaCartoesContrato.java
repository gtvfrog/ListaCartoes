package com.teste.ui.listacartoes;

import com.teste.data.model.Cartao;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface ListaCartoesContrato {
    interface ListaCartoesView {

        void mostraCartoes(List<Cartao> filmes);

        void mostraErro();
    }

    interface ListaCartoesPresenter {

        void obtemCartoes() throws IOException, JSONException;

        void destruirView();
    }

}
