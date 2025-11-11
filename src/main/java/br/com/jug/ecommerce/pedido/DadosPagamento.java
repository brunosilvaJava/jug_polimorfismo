package br.com.jug.ecommerce.pedido;

import br.com.jug.ecommerce.dominio.DadosCartao;
import br.com.jug.ecommerce.pagamento.factory.TipoPagamento;

import java.util.Optional;

public class DadosPagamento {

    private final TipoPagamento tipoPagamento;
    private final DadosCartao dadosCartao;
    private final Integer quantidadeParcelas;
    private final String chavePix;

    public DadosPagamento(TipoPagamento tipoPagamento, DadosCartao dadosCartao, Integer quantidadeParcelas) {
        this.tipoPagamento = tipoPagamento;
        this.dadosCartao = dadosCartao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.chavePix = null;
    }

    public DadosPagamento(TipoPagamento tipoPagamento, String chavePix) {
        this.tipoPagamento = tipoPagamento;
        this.dadosCartao = null;
        this.quantidadeParcelas = 1;
        this.chavePix = chavePix;
    }

    public DadosPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        this.dadosCartao = null;
        this.quantidadeParcelas = 1;
        this.chavePix = null;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Optional<DadosCartao> getDadosCartao() {
        return Optional.ofNullable(dadosCartao);
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public Optional<String> getChavePix() {
        return Optional.ofNullable(chavePix);
    }
}
