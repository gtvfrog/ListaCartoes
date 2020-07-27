package com.teste.ui.listacartoes;

import com.teste.data.mapper.CartaoMapper;
import com.teste.data.model.Cartao;
import com.teste.data.network.ApiService;
import com.teste.data.network.response.CartoesResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCartoesPresenter implements ListaCartoesContrato.ListaCartoesPresenter{
    private ListaCartoesContrato.ListaCartoesView view;
    public ListaCartoesPresenter(ListaCartoesContrato.ListaCartoesView view) {
        this.view = view;
    }
    @Override
    public void obtemCartoes() throws IOException, JSONException {
        //JSONObject JO =  getJSONObjectFromURL("https://github.com/policante/Coopercard-mobile/blob/master/service/cards.json");

       ApiService.getInstance()
                .obterCartoes()
                .enqueue(new Callback<CartoesResult>() {
                    @Override
                    public void onResponse(Call<CartoesResult> call, Response<CartoesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Cartao> listaCartoes = CartaoMapper
                                    .deResponseParaDominio(response.body().getResultadoCartoes());

                            view.mostraCartoes(listaCartoes);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<CartoesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
    public static JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {
        System.out.println("JSON: ");
        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);
        urlConnection.disconnect();

        return new JSONObject(jsonString);
    }
}