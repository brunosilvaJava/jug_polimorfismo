package br.com.jug.ecommerce.notificacao;

import br.com.jug.ecommerce.dominio.Pedido;

import static java.lang.IO.println;

public class NotificadorSMS implements Notificador {

    @Override
    public void enviarConfirmacaoPedido(Pedido pedido) {
        println("📱 SMS enviado");
        println("   Mensagem: Pedido #" + pedido.getId().substring(0, 8) +
                " confirmado! Total: R$" + pedido.calcularValorTotal());
    }

    @Override
    public void enviarConfirmacaoPagamento(Pedido pedido) {
        println("📱 SMS enviado");
        println("   Mensagem: Pagamento aprovado! R$" + pedido.calcularValorTotal());
    }

    @Override
    public void enviarNotificacaoEnvio(Pedido pedido, String codigoRastreio) {
        println("📱 SMS enviado");
        println("   Mensagem: Pedido enviado! Rastreio: " + codigoRastreio);
    }

    @Override
    public String getTipoNotificacao() {
        return "SMS";
    }
}