package br.com.jug.ecommerce.dominio;

import java.math.BigDecimal;

/**
 * Representa um item individual dentro de um pedido.
 */
public class ItemPedido {

    private String produtoNome;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido(String produtoNome, int quantidade, BigDecimal precoUnitario) {
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return String.format("%s - Qtd: %d - R$ %.2f",
                produtoNome, quantidade, getSubtotal());
    }
}