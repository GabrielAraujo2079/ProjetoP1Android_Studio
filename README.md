1. Visão Geral
O TechShop é um app Android de e-commerce de produtos de tecnologia. O usuário navega pelo catálogo, visualiza produtos com imagem e preço, pode adicionar itens ao carrinho e iniciar uma compra.

Pacote: com.example.techshop_p1_grupo9
Linguagem: Java
SDK mínimo: API 24 (Android 7.0)
SDK alvo: API 36
Tema: Material3 DayNight NoActionBar


2. Estrutura de Arquivos
Classes Java

MainActivity.java – Ponto de entrada do app
home/homeFragment.java – Tela inicial com lista de produtos
home/Produto.java – Modelo de dados do produto
home/ProdutoAdapter.java – Adapter do RecyclerView
carrinho/CarrinhoFragment.java – Tela do carrinho
compra/CompraFragment.java – Tela de finalização de compra

Layouts XML

activity_main.xml – Contêiner com NavHostFragment
fragment_home.xml – Header fixo, banners e RecyclerView
item_produto.xml – Layout de cada item da lista
fragment_carrinho.xml – Tela do carrinho (placeholder)
fragment_compra.xml – Tela de compra (placeholder)

Recursos

res/navigation/nav_graph.xml – Grafo de navegação
res/drawable/ – Imagens dos produtos e ícones
res/values/ – Cores, temas e strings


3. Activity
MainActivity
Única Activity do projeto. Inicializa o layout com EdgeToEdge (tela cheia) e hospeda o NavHostFragment, que gerencia a navegação entre todos os fragments do app.

4. Fragments
homeFragment
Fragment principal. Exibe o header vermelho com ícone de usuário, barra de pesquisa e ícone de carrinho. Abaixo mostra banners promocionais estáticos e a lista de produtos via RecyclerView.
Produtos cadastrados:

Water Cooler – R$ 250,00
Placa de Vídeo – R$ 1.700,00
Fonte 650W – R$ 309,00
Mouse Gamer – R$ 500,00
Teclado Mecânico – R$ 350,00

Ao clicar em um produto, um AlertDialog exibe o nome e o preço com três opções: Adicionar ao Carrinho, Comprar Agora e Cancelar.
CarrinhoFragment
Fragment do carrinho de compras. Atualmente exibe uma tela placeholder. A lógica de gerenciamento de itens está pendente de implementação (marcada como TODO no código).
CompraFragment
Fragment de finalização de compra. Também exibe uma tela placeholder, aguardando o desenvolvimento do fluxo de pagamento.

5. RecyclerView
Produto.java
Classe modelo com três atributos: nome (String), preco (double) e imagemRes (int). Possui construtor completo e getters para cada campo.
ProdutoAdapter.java
Adapter que conecta a lista de produtos ao RecyclerView. Implementa a interface OnProdutoClickListener para tratar cliques nos itens.

ProdutoViewHolder – referencia imgProduto, txtNome e txtPreco
onCreateViewHolder – infla o layout item_produto.xml
onBindViewHolder – preenche nome, preço (R$ X,XX) e imagem
OnProdutoClickListener – interface de callback para clique no item


6. Navegação
Usa o Android Navigation Component com grafo definido em nav_graph.xml. O destino inicial é o homeFragment.
Ações disponíveis:

action_home_to_carrinho → homeFragment para CarrinhoFragment
action_home_to_compra → homeFragment para CompraFragment
action_carrinho_to_compra → CarrinhoFragment para CompraFragment


7. Interface Visual
O app usa a cor vermelha (#B71C1C) como identidade visual principal.

Header fixo vermelho com ícone de usuário, pesquisa e carrinho
Banners promocionais com imagens estáticas
Seção de ofertas com título em fundo vermelho
Itens da lista em fundo escuro (#8B1A1A), nome em branco e preço em verde
Scroll suave com NestedScrollView


8. Dependências

appcompat 1.7.1
material 1.13.0
activity 1.13.0
constraintlayout 2.2.1
navigation-fragment-ktx 2.9.7
navigation-ui-ktx 2.9.7


9. Requisitos Obrigatórios
RecyclerView — Implementado em homeFragment com ProdutoAdapter e ProdutoViewHolder exibindo a lista de produtos.
Activities — MainActivity implementada como AppCompatActivity, servindo de host para os fragments via Navigation Component.
Fragments — Três fragments implementados: homeFragment, CarrinhoFragment e CompraFragment, cada um com layout e classe Java próprios.
Comunicação entre Activities por objetos — A classe Produto está criada como objeto de dados. Pendente: passar o objeto via Bundle ao navegar para a tela de compra.
Layout ergonômico e agradável — Header fixo, scroll fluido, banners visuais, hierarquia de informação clara e paleta de cores consistente.
