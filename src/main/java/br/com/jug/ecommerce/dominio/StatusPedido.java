package br.com.jug.ecommerce.dominio;

/**
 * Status possíveis de um pedido.
 */
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO,
    PAGAMENTO_APROVADO,
    EM_SEPARACAO,
    ENVIADO,
    ENTREGUE,
    CANCELADO,
    ERRO
}