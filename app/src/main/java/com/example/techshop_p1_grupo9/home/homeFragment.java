package com.example.techshop_p1_grupo9.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techshop_p1_grupo9.R;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {

    public homeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Botão do carrinho
        ImageView btnCarrinho = view.findViewById(R.id.btnCarrinho);
        btnCarrinho.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_home_to_carrinho)
        );

        // Lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Water Cooler Gamer RGB 240mm", 429.90, R.drawable.water_cooler));
        produtos.add(new Produto("Processador AMD Ryzen 5 5600", 899.90, R.drawable.ryzen5_5600));
        produtos.add(new Produto("Fonte 650W", 309.00, R.drawable.fonte_msi));
        produtos.add(new Produto("Mouse Gamer", 500.00, R.drawable.mouse_gamerwebp));
        produtos.add(new Produto("Teclado Mecânico", 350.00, R.drawable.teclado_mecanico));

        // RecyclerView
        RecyclerView recycler = view.findViewById(R.id.recyclerProdutos);
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new ProdutoAdapter(produtos, produto -> {
            Intent intent = new Intent(requireContext(), com.example.techshop_p1_grupo9.DetalheProdutoActivity.class);
            intent.putExtra(com.example.techshop_p1_grupo9.DetalheProdutoActivity.EXTRA_PRODUTO, produto);
            startActivity(intent);
        }));

        return view;
    }
}