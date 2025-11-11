package br.com.jug.ecommerce.relatorio;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.dominio.StatusPedido;
import java.math.BigDecimal;
import java.util.List;

import static java.lang.IO.println;

public class RelatorioVendas extends GeradorRelatorio {

    @Override
    protected String getTituloRelatorio() {
        return "RELATÓRIO DE VENDAS";
    }

    @Override
    protected String gerarConteudo(List<Pedido> pedidos) {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("PEDIDOS:\n\n");

        for (Pedido pedido : pedidos) {
            conteudo.append(String.format(
                    "ID: %-10s | Cliente: %-20s | Valor: R$ %8.2f | Status: %s\n",
                    pedido.getId().substring(0, 8),
                    pedido.getCliente().getNome(),
                    pedido.calcularValorTotal(),
                    pedido.getStatus()
            ));
        }

        return conteudo.toString();
    }

    @Override
    protected String gerarEstatisticas(List<Pedido> pedidos) {
        int totalPedidos = pedidos.size();

        BigDecimal valorTotal = pedidos.stream()
                .map(Pedido::calcularValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorMedio = totalPedidos > 0
                ? valorTotal.divide(BigDecimal.valueOf(totalPedidos), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        long pedidosPagos = pedidos.stream()
                .filter(p -> p.getStatus() == StatusPedido.PAGAMENTO_APROVADO)
                .count();

        return String.format("""
            
            ESTATÍSTICAS:
            - Total de Pedidos: %d
            - Pedidos Pagos: %d
            - Valor Total: R$ %.2f
            - Ticket Médio: R$ %.2f
            """,
                totalPedidos, pedidosPagos, valorTotal, valorMedio);
    }

}