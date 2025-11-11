package br.com.jug.ecommerce.notificacao;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.notificacao.factory.NotificadorFactory;
import br.com.jug.ecommerce.notificacao.factory.TipoNotificacao;

import static java.lang.IO.println;

public class NotificacaoService {

    public static void enviarNotificacoes(Pedido pedido) {

        TipoNotificacao tipoNotificacao = pedido.getCliente().getTipoNotificacao();

        Notificador notificador = NotificadorFactory.criar(tipoNotificacao);
        {
            println("\n📢 Enviando notificações via " + notificador.getTipoNotificacao());
        }

        notificador.enviarConfirmacaoPedido(pedido);

        if (pedido.isAprovado()) {
            notificador.enviarConfirmacaoPagamento(pedido);
            notificador.enviarNotificacaoEnvio(pedido, findCodRastreio());
        }
    }

    private static String findCodRastreio() {
        return "BR" + System.currentTimeMillis() % 1000000000;
    }
}
