package br.com.jug.ecommerce.pagamento.factory;

import br.com.jug.ecommerce.dominio.DadosCartao;
import br.com.jug.ecommerce.pagamento.Pagamento;
import br.com.jug.ecommerce.pagamento.PagamentoBoleto;
import br.com.jug.ecommerce.pagamento.PagamentoCartao;
import br.com.jug.ecommerce.pagamento.PagamentoPix;
import br.com.jug.ecommerce.pedido.DadosPagamento;

import java.math.BigDecimal;

public class PagamentoFactory {

    public static Pagamento criar(DadosPagamento dadosPagamento, BigDecimal valor) {

        switch (dadosPagamento.getTipoPagamento()) {
            case CARTAO_CREDITO -> {
                DadosCartao dadosCartao = dadosPagamento.getDadosCartao().orElseThrow();
                return new PagamentoCartao(
                        valor,
                        dadosCartao.getNumeroCartao(),
                        dadosCartao.getNomeTitular(),
                        dadosCartao.getCodigoSeguranca(),
                        dadosPagamento.getQuantidadeParcelas());
            }
            case PIX -> {
                String chavePix = dadosPagamento.getChavePix().orElseThrow();
                return new PagamentoPix(valor, chavePix);
            }
            case BOLETO -> {
                return new PagamentoBoleto(valor);
            }
            default -> throw new IllegalArgumentException("Tipo de pagamento não suportado: " + dadosPagamento.getTipoPagamento());
        }
    }
}