package br.com.jug.ecommerce.notificacao;

import br.com.jug.ecommerce.dominio.Pedido;

/**
 * INTERFACE para diferentes canais de notificação
 *
 * POLIMORFISMO: Mesmo contrato, implementações diferentes
 */
public interface Notificador {

    void enviarConfirmacaoPedido(Pedido pedido);

    void enviarConfirmacaoPagamento(Pedido pedido);

    void enviarNotificacaoEnvio(Pedido pedido, String codigoRastreio);

    String getTipoNotificacao();
}