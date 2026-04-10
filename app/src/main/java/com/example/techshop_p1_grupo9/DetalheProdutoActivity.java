package com.example.techshop_p1_grupo9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.techshop_p1_grupo9.home.Produto;

public class DetalheProdutoActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUTO = "extra_produto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        Produto produto = (Produto) getIntent().getSerializableExtra(EXTRA_PRODUTO);

        if (produto == null) {
            finish();
            return;
        }

        ImageView imgProduto = findViewById(R.id.imgDetalheProduto);
        TextView txtNome = findViewById(R.id.txtDetalheNome);
        TextView txtPreco = findViewById(R.id.txtDetalhePreco);
        Button btnAdicionar = findViewById(R.id.btnDetalheAdicionar);
        Button btnVoltar = findViewById(R.id.btnDetalheVoltar);

        imgProduto.setImageResource(produto.getImagemRes());
        txtNome.setText(produto.getNome());
        txtPreco.setText(String.format("R$ %.2f", produto.getPreco()));

        btnAdicionar.setOnClickListener(v -> {
            CarrinhoManager.getInstance().adicionar(produto);
            Toast.makeText(this, produto.getNome() + " adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}