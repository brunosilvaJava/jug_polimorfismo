package br.com.jug.ecommerce.pedido;

import br.com.jug.ecommerce.desconto.DescontoService;
import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.frete.FreteService;
import br.com.jug.ecommerce.notificacao.NotificacaoService;
import br.com.jug.ecommerce.pagamento.PagamentoService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;

public class PedidoService {

    private static final List<Pedido> PEDIDOS = new ArrayList<>();

    public static void efetuarPedido(Pedido pedido) {
        {
            println("\n📦 Iniciando criação do pedido: " + pedido);
            println("   Total: R$ " + pedido.calcularSubtotal());
        }
        DescontoService.aplicarDesconto(pedido);
        FreteService.aplicarFrete(pedido);
        PEDIDOS.add(pedido);
        {
            println("\n📦 Pedido criado: " + pedido);
            println("   Subtotal: R$ " + pedido.calcularSubtotal());
        }
        PagamentoService.processarPagamento(pedido);
        NotificacaoService.enviarNotificacoes(pedido);
    }

    public static List<Pedido> findPedidos() {
        return PEDIDOS;
    }

}
