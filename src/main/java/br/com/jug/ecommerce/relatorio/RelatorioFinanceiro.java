package br.com.jug.ecommerce.relatorio;

import br.com.jug.ecommerce.dominio.Pedido;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioFinanceiro extends GeradorRelatorio {

    @Override
    protected String getTituloRelatorio() {
        return "RELATÓRIO FINANCEIRO";
    }

    @Override
    protected String gerarConteudo(List<Pedido> pedidos) {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("MOVIMENTAÇÃO FINANCEIRA:\n\n");

        for (Pedido pedido : pedidos) {
            conteudo.append(String.format(
                    "Pedido: %-10s | Subtotal: R$ %8.2f | Desconto: R$ %6.2f | Frete: R$ %6.2f | Total: R$ %8.2f\n",
                    pedido.getId().substring(0, 8),
                    pedido.calcularSubtotal(),
                    pedido.getDesconto(),
                    pedido.getValorFrete(),
                    pedido.calcularValorTotal()
            ));
        }

        return conteudo.toString();
    }

    @Override
    protected String gerarEstatisticas(List<Pedido> pedidos) {
        BigDecimal totalSubtotal = pedidos.stream()
                .map(Pedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDescontos = pedidos.stream()
                .map(Pedido::getDesconto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalFrete = pedidos.stream()
                .map(Pedido::getValorFrete)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal receitaLiquida = pedidos.stream()
                .map(Pedido::calcularValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return String.format("""
            
            RESUMO FINANCEIRO:
            - Receita Bruta (Subtotais): R$ %.2f
            - Total em Descontos: R$ %.2f
            - Total em Fretes: R$ %.2f
            - Receita Líquida: R$ %.2f
            - Margem de Desconto: %.2f%%
            """,
                totalSubtotal,
                totalDescontos,
                totalFrete,
                receitaLiquida,
                totalSubtotal.compareTo(BigDecimal.ZERO) > 0
                        ? totalDescontos.divide(totalSubtotal, 4, BigDecimal.ROUND_HALF_UP)
                        .multiply(new BigDecimal("100"))
                        : BigDecimal.ZERO);
    }

}