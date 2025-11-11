package br.com.jug.ecommerce.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Pagamento {

    protected String id;
    protected BigDecimal valor;
    protected LocalDateTime dataHora;
    protected StatusPagamento status;

    public Pagamento(BigDecimal valor) {
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.status = StatusPagamento.PENDENTE;
    }

    public abstract void processar();

    public abstract String gerarComprovante();

    public boolean isAprovado() {
        return this.status == StatusPagamento.APROVADO;
    }

    public boolean isPendente() {
        return this.status == StatusPagamento.PENDENTE;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    protected void setStatus(StatusPagamento status) {
        this.status = status;
    }
}