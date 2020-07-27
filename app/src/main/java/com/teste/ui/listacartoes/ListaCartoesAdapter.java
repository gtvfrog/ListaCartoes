package com.teste.ui.listacartoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.teste.R;
import com.teste.data.model.Cartao;

import java.util.ArrayList;
import java.util.List;

public class ListaCartoesAdapter extends RecyclerView .Adapter<ListaCartoesAdapter.ListaCartoesViewHolder>{
    private List<Cartao> cartoes;
    private static ItemCartaoClickListener itemCartaoClickListener;

    public ListaCartoesAdapter(ItemCartaoClickListener itemCartaoClickListener) {
        this.itemCartaoClickListener = itemCartaoClickListener;

        cartoes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaCartoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartao, parent, false);

        return new ListaCartoesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCartoesViewHolder holder, int position) {
        //holder.bind(cartoes.get(position));
    }

    @Override
    public int getItemCount() {
        return (cartoes != null && cartoes.size() > 0) ? cartoes.size() : 0;
    }

    static class ListaCartoesViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeCartao;
        private ImageView imageCartao;
        private Cartao cartao;

        public ListaCartoesViewHolder(View itemView) {
            super(itemView);

            nomeCartao = itemView.findViewById(R.id.text_nome_cartao);
            imageCartao = itemView.findViewById(R.id.image_cartao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemCartaoClickListener != null) {
                        itemCartaoClickListener.onItemCartaoClicado(cartao);
                    }
                }
            });
        }

        public void bind(Cartao cartao) {
            this.cartao = cartao;

            nomeCartao.setText(cartao.getName());
            Picasso.get()
                    .load(cartao.getCategoria().getImage_path())
                    .into(imageCartao);
        }
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
        notifyDataSetChanged();
    }

    public interface ItemCartaoClickListener {

        void onItemCartaoClicado(Cartao cartao);
    }
}