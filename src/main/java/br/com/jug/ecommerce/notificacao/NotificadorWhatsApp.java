package br.com.jug.ecommerce.notificacao;

import br.com.jug.ecommerce.dominio.Pedido;

import static java.lang.IO.println;

public class NotificadorWhatsApp implements Notificador {

    @Override
    public void enviarConfirmacaoPedido(Pedido pedido) {
        println("💬 WhatsApp enviado");
        println("   Olá " + pedido.getCliente().getNome() + "!");
        println("   ✅ Pedido #" + pedido.getId().substring(0, 8) + " confirmado!");
        println("   💰 Total: R$ " + pedido.calcularValorTotal());
    }

    @Override
    public void enviarConfirmacaoPagamento(Pedido pedido) {
        println("💬 WhatsApp enviado");
        println("   🎉 Pagamento confirmado!");
        println("   💳 Valor: R$ " + pedido.calcularValorTotal());
    }

    @Override
    public void enviarNotificacaoEnvio(Pedido pedido, String codigoRastreio) {
        println("💬 WhatsApp enviado");
        println("   📦 Seu pedido foi enviado!");
        println("   🔍 Código de rastreio: " + codigoRastreio);
        println("   Acompanhe sua entrega!");
    }

    @Override
    public String getTipoNotificacao() {
        return "WhatsApp";
    }
}