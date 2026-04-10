package com.example.techshop_p1_grupo9.home;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double preco;
    private int imagemRes;

    public Produto(String nome, double preco, int imagemRes) {
        this.nome = nome;
        this.preco = preco;
        this.imagemRes = imagemRes;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getImagemRes() { return imagemRes; }
}