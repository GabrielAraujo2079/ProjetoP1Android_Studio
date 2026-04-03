package com.example.techshop_p1_grupo9.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techshop_p1_grupo9.R;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {

    public homeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Botão do carrinho → navega pro CarrinhoFragment
        ImageView btnCarrinho = view.findViewById(R.id.btnCarrinho);
        btnCarrinho.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_home_to_carrinho)
        );

        // Lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Water Cooler", 250.00, R.drawable.water_cooler));
        produtos.add(new Produto("Placa de Vídeo", 1700.00, R.drawable.placa_de_video));
        produtos.add(new Produto("Fonte 650W", 309.00, R.drawable.fonte_msi));
        produtos.add(new Produto("Mouse Gamer", 500.00, R.drawable.mouse_gamerwebp));
        produtos.add(new Produto("Teclado Mecânico", 350.00, R.drawable.teclado_mecanico));

        // Configurar RecyclerView
        RecyclerView recycler = view.findViewById(R.id.recyclerProdutos);
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new ProdutoAdapter(produtos, produto -> {
            // Dialog ao clicar no produto
            new AlertDialog.Builder(requireContext())
                    .setTitle(produto.getNome())
                    .setMessage(String.format("R$ %.2f", produto.getPreco()))
                    .setPositiveButton("🛒 Adicionar ao Carrinho", (d, w) -> {
                        // TODO: adicionar ao CarrinhoManager
                    })
                    .setNegativeButton("⚡ Comprar Agora", (d, w) -> {
                        Navigation.findNavController(view).navigate(R.id.action_home_to_compra);
                    })
                    .setNeutralButton("Cancelar", null)
                    .show();
        }));

        return view;
    }
}