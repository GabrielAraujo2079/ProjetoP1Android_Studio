# TechShop - Projeto P1 Android Studio

Aplicativo de loja de informática desenvolvido em Java puro no Android Studio.

## Grupo 9

---

## Estrutura do Projeto
```
com.example.techshop_p1_grupo9
 ├── carrinho
 │    └── CarrinhoFragment.java
 ├── compra
 │    └── CompraFragment.java
 ├── home
 │    └── homeFragment.java
 └── MainActivity.java

res/
 ├── drawable/
 │    ├── bg_pesquisa.xml          → fundo com radius da barra de pesquisa
 │    ├── user_icon                → ícone de perfil
 │    ├── cart_iconpng             → ícone do carrinho
 │    ├── pesquisa_icon            → ícone da barra de pesquisa
 │    ├── imagem_estatica          → banner principal
 │    └── imagem_estatica3_desing  → banner secundário
 ├── layout/
 │    ├── activity_main.xml
 │    ├── fragment_home.xml
 │    ├── fragment_carrinho.xml
 │    └── fragment_compra.xml
 └── navigation/
      └── nav_graph.xml
```

---

## Tecnologias Utilizadas

- Java (Android Studio)
- Navigation Component
- RecyclerView
- Fragments
- Singleton Pattern

---

## Navegação

A navegação entre telas é gerenciada pelo `nav_graph.xml` via Navigation Component.

| Action | De | Para |
|---|---|---|
| `action_home_to_carrinho` | homeFragment | CarrinhoFragment |
| `action_home_to_compra` | homeFragment | CompraFragment |
| `action_carrinho_to_compra` | CarrinhoFragment | CompraFragment |

- Tela inicial: `homeFragment`

---

## Telas

### Home
- Header com ícone de perfil, barra de pesquisa e botão do carrinho
- Banner estático principal
- Banner secundário
- Lista de produtos via RecyclerView
- Dialog ao clicar no produto com opções: **Adicionar ao Carrinho** ou **Comprar Agora**

### Carrinho
- Lista dos produtos adicionados
- Total da compra
- Botão para finalizar e ir pra tela de compra

### Compra
- Resumo dos itens
- Campos de nome e endereço
- Seleção de forma de pagamento
- Botão de confirmar compra

---

## Como Rodar

1. Clone o repositório
2. Abra no Android Studio
3. Aguarde o Gradle sincronizar
4. Rode em um emulador ou dispositivo físico com Android 7.0+ (API 24)

---

## Requisitos Atendidos

- [x] Uso de Fragments
- [x] Uso de Activities
- [x] Navigation Component
- [ ] RecyclerView *(em desenvolvimento)*
- [ ] Comunicação entre Activities por objetos *(em desenvolvimento)*
- [x] Layout ergonômico e agradável
