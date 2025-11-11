import br.com.jug.ecommerce.dominio.*;
import br.com.jug.ecommerce.frete.TipoFrete;
import br.com.jug.ecommerce.notificacao.factory.TipoNotificacao;
import br.com.jug.ecommerce.pagamento.PagamentoService;
import br.com.jug.ecommerce.pagamento.factory.TipoPagamento;
import br.com.jug.ecommerce.pedido.DadosPagamento;
import br.com.jug.ecommerce.pedido.PedidoService;
import br.com.jug.ecommerce.relatorio.GeradorRelatorio;
import br.com.jug.ecommerce.relatorio.RelatorioFinanceiro;
import br.com.jug.ecommerce.relatorio.RelatorioVendas;

import static java.lang.IO.println;

void main() {
    println("""
            ╔════════════════════════════════════════════════════════════════════════╗
            ║                                                                        ║
            ║           SISTEMA DE E-COMMERCE - DEMONSTRAÇÃO POLIMORFISMO            ║
            ║                      Comunidade JUG Brasil 🇧🇷☕                         ║
            ║                                                                        ║
            ╚════════════════════════════════════════════════════════════════════════╝
            """);

    // ====================================================================================
    // CENÁRIO 1: Cliente VIP com Pagamento em Cartão e entrega SEDEX
    // ====================================================================================
    {
        log("CENÁRIO 1: Cliente VIP - Pagamento Cartão de Crédito");
    }
    PedidoService.efetuarPedido(
        new Pedido(
            new Cliente("001", "Luana Silva", "luana@email.com", TipoCliente.VIP, "01310-100", TipoNotificacao.EMAIL),
            List.of(
                    new ItemPedido("Mochila", 1, new BigDecimal("500.00")),
                    new ItemPedido("Mouse Wireless", 1, new BigDecimal("200.00")),
                    new ItemPedido("Teclado Mecânico", 1, new BigDecimal("300.00"))),
            new DadosPagamento(
                    TipoPagamento.CARTAO_CREDITO,
                    new DadosCartao("1234567890123456", "Luana Silva", "123"),
                    3),
            TipoFrete.SEDEX));

    // ====================================================================================
    // CENÁRIO 2: Cliente Premium com Pagamento PIX e entrega Correios
    // ====================================================================================
    {
        log("CENÁRIO 2: Cliente Premium - Pagamento PIX");
    }
    PedidoService.efetuarPedido(
        new Pedido(
            new Cliente("002", "João Santos", "joao@email.com", TipoCliente.PREMIUM, "04567-890", TipoNotificacao.WHATSAPP),
            List.of(
                    new ItemPedido("Notebook", 1, new BigDecimal("3000.00"))
            ),
            new DadosPagamento(
                    TipoPagamento.PIX,
                    "joao@email.com"),
            TipoFrete.CORREIOS));

    // ========================================================================================================
    // CENÁRIO 3: Cliente Comum com Cupom de Desconto, com pagamento em Boleto e entrega por Transportadora
    // ========================================================================================================
    {
        log("CENÁRIO 3: Cliente Comum - Cupom + Boleto");
    }
    PedidoService.efetuarPedido(
        new Pedido(
            new Cliente("003", "Ana Costa", "ana@email.com", TipoCliente.COMUM, "12345-678", TipoNotificacao.SMS),
            List.of(
                    new ItemPedido("Cabo HDMI 2m", 2, new BigDecimal("40.00"))
            ),
            new DadosPagamento(
                    TipoPagamento.BOLETO
            ),
            TipoFrete.TRANSPORTADORA));

    // ====================================================================================
    // GERAÇÃO DE RELATÓRIOS
    // ====================================================================================
    {
        log("GERAÇÃO DE RELATÓRIOS");
    }
    List<Pedido> todosPedidos = PedidoService.findPedidos();

    // RELATÓRIO VENDAS
    GeradorRelatorio relatorioVendas = new RelatorioVendas();
    String vendas = relatorioVendas.gerarRelatorio(todosPedidos);
    println(vendas);

    // RELATÓRIO FINANCEIRO
    GeradorRelatorio relatorioFinanceiro = new RelatorioFinanceiro();
    String financeiro = relatorioFinanceiro.gerarRelatorio(todosPedidos);
    println(financeiro);

    // ====================================================================================
    // GERAÇÃO DE COMPROVANTES DE PAGAMENTO
    // ====================================================================================
    {
        log("GERAÇÃO DE COMPROVANTES DE PAGAMENTO");
    }
    PagamentoService.getPagamentos()
            .forEach(pagamento -> println(pagamento.gerarComprovante()));
}

private static void log(String log) {
    println("\n" + "=".repeat(80));
    println(log);
    println("=".repeat(80));
}
