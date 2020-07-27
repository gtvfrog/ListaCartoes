package com.teste.ui.listacartoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.R;
import com.teste.data.model.Cartao;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ListaCartoesActivity extends AppCompatActivity implements ListaCartoesContrato.ListaCartoesView, ListaCartoesAdapter.ItemCartaoClickListener{

    private ListaCartoesAdapter cartoesAdapter;
    private ListaCartoesContrato.ListaCartoesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuraToolbar();

        configuraAdapter();

        presenter = new ListaCartoesPresenter(this);
        try {
            presenter.obtemCartoes();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        final RecyclerView recyclerCartoes = findViewById(R.id.recycler_cartoes);

        cartoesAdapter = new ListaCartoesAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 1);

        recyclerCartoes.setLayoutManager(gridLayoutManager);
        recyclerCartoes.setAdapter(cartoesAdapter);
    }

    @Override
    public void onItemCartaoClicado(Cartao cartao) {

    }

    @Override
    public void mostraCartoes(List<Cartao> cartoes) {

    }

    @Override
    public void mostraErro() {

    }


}