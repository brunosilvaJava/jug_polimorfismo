package br.com.jug.ecommerce.pagamento;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.dominio.StatusPedido;
import br.com.jug.ecommerce.pagamento.factory.PagamentoFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;

public class PagamentoService {

    private static final List<Pagamento> PAGAMENTOS = new ArrayList<>();

    public static void processarPagamento(Pedido pedido) {

        Pagamento pagamento = PagamentoFactory.criar(pedido.getDadosPagamento(), pedido.calcularValorTotal());

        pagamento.processar();
        PAGAMENTOS.add(pagamento);

        if (pagamento.isAprovado()) {
            {
                println("✓ Pagamento registrado no sistema");
                println("  ID: " + pagamento.getId());
                println("  Valor: R$ " + pagamento.getValor());
                println("  Data/Hora: " + pagamento.getDataHora());
            }
            pedido.setStatus(StatusPedido.PAGAMENTO_APROVADO);
            {
                println("   ✅ Status do pedido: " + pedido.getStatus());
            }
        } else if(pagamento.isPendente()) {
            pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
            {
                println("   ❌ Falha no pagamento");
            }
        } else {
            pedido.setStatus(StatusPedido.CANCELADO);
            {
                println("   ❌ Falha no pagamento");
            }
        }
    }

    public static List<Pagamento> getPagamentos() {
        return PAGAMENTOS;
    }
}
