package com.example.techshop_p1_grupo9.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.techshop_p1_grupo9.R;

import java.util.List;
import java.util.Locale;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    public interface OnProdutoClickListener {
        void onProdutoClick(Produto produto);
    }

    private final List<Produto> listaProdutos;
    private final OnProdutoClickListener listener;

    public ProdutoAdapter(List<Produto> listaProdutos, OnProdutoClickListener listener) {
        this.listaProdutos = listaProdutos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);

        holder.txtNome.setText(produto.getNome());
        holder.txtPreco.setText(String.format(Locale.getDefault(), "R$ %.2f", produto.getPreco()));

        Glide.with(holder.itemView.getContext())
                .load(produto.getImagemRes())
                .into(holder.imgProduto);

        holder.itemView.setOnClickListener(v -> listener.onProdutoClick(produto));
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduto;
        TextView txtNome, txtPreco;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduto = itemView.findViewById(R.id.imgProduto);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPreco = itemView.findViewById(R.id.txtPreco);
        }
    }
}