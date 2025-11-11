package br.com.jug.ecommerce.notificacao;

import br.com.jug.ecommerce.dominio.Pedido;

import static java.lang.IO.println;

/**
 * Implementação CONCRETA: Notificações por Email
 */
public class NotificadorEmail implements Notificador {

    @Override
    public void enviarConfirmacaoPedido(Pedido pedido) {
        println("📧 Email enviado para: " + pedido.getCliente().getEmail());
        println("   Assunto: Pedido #" + pedido.getId() + " confirmado!");
        println("   Conteúdo: Seu pedido foi recebido e está sendo processado.");
    }

    @Override
    public void enviarConfirmacaoPagamento(Pedido pedido) {
        println("📧 Email enviado para: " + pedido.getCliente().getEmail());
        println("   Assunto: Pagamento confirmado!");
        println("   Conteúdo: Pagamento de R$ " + pedido.calcularValorTotal() + " confirmado.");
    }

    @Override
    public void enviarNotificacaoEnvio(Pedido pedido, String codigoRastreio) {
        println("📧 Email enviado para: " + pedido.getCliente().getEmail());
        println("   Assunto: Pedido enviado!");
        println("   Conteúdo: Código de rastreio: " + codigoRastreio);
    }

    @Override
    public String getTipoNotificacao() {
        return "Email";
    }
}