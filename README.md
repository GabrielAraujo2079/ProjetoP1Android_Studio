# TechShop – P1 Grupo 9

Projeto de aplicativo Android voltado para o e-commerce de produtos de tecnologia, desenvolvido como requisito para a avaliação P1. O sistema permite a navegação por catálogo, visualização de detalhes, gestão de carrinho e finalização de pedidos.

---

## Estrutura do Projeto

### Activities
* **MainActivity**: Atua como container principal. Responsável por inicializar o sistema de navegação e hospedar o NavHostFragment.
* **DetalheProdutoActivity**: Activity secundária dedicada à exibição detalhada de um item. Recebe dados via Intent utilizando a serialização de objetos.

### Fragments
* **homeFragment**: Tela inicial com listagem dinâmica de produtos.
* **CarrinhoFragment**: Exibe a lista de itens selecionados pelo usuário para conferência.
* **CompraFragment**: Interface para coleta de informações de pagamento e fechamento do pedido.
* **PedidoFinalizadoFragment**: Confirmação visual de conclusão da transação.

### Lógica e Persistência
* **Produto.java**: Classe de modelo (nome, preço, imagem) que implementa Serializable.
* **ProdutoAdapter.java**: Gerencia a reciclagem de views e o vínculo de dados no RecyclerView.
* **CarrinhoManager.java**: Singleton responsável por centralizar e manter os dados do carrinho durante a execução do app.

---

## Fluxo de Navegação

O projeto utiliza o Navigation Component para transições entre fragments e Intents para chamadas de novas activities.

| Origem | Destino | Método |
|:---|:---|:---|
| homeFragment | DetalheProdutoActivity | Intent com Objeto Serializable |
| homeFragment | CarrinhoFragment | Navigation Action |
| CarrinhoFragment | CompraFragment | Navigation Action |
| CompraFragment | PedidoFinalizadoFragment | Navigation Action |

---

## Requisitos Avaliados

1. **RecyclerView**: Implementado para otimização da listagem de produtos e itens do carrinho.
2. **Activities**: Estrutura composta por múltiplas Activities para atender ao requisito de navegação entre contextos.
3. **Fragments**: Uso de fragmentação para modularizar as etapas do processo de compra.
4. **Comunicação por Objetos**: Transferência de dados técnicos entre componentes através de objetos serializados.
5. **Ergonomia**: Interface organizada com foco em legibilidade e fluidez de navegação.

---
