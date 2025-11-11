package br.com.jug.ecommerce.pagamento;

import java.math.BigDecimal;
import java.util.UUID;

import static java.lang.IO.println;

public class PagamentoCartao extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;
    private String cvv;
    private int parcelas;

    public PagamentoCartao(BigDecimal valor, String numeroCartao, String nomeTitular,
                           String cvv, int parcelas) {
        super(valor);
        this.id = "CARD-" + UUID.randomUUID().toString().substring(0, 8);
        this.numeroCartao = mascararCartao(numeroCartao);
        this.nomeTitular = nomeTitular;
        this.cvv = cvv;
        this.parcelas = parcelas;
    }

    @Override
    public void processar() {
        {
            println("\n💳 Processando Pagamento com Cartão de Crédito...");
            println("   Cartão: " + numeroCartao);
            println("   Titular: " + nomeTitular);
            println("   Parcelas: " + parcelas + "x de R$ " +
                    valor.divide(BigDecimal.valueOf(parcelas), 2, BigDecimal.ROUND_HALF_UP));
        }
        // Simulação de processamento
        try {
            Thread.sleep(1000);
            {
                println("   ✓ Pagamento aprovado pela operadora");
            }
            this.status = StatusPagamento.APROVADO;
        } catch (InterruptedException e) {
            this.status = StatusPagamento.RECUSADO;
        }
    }

    @Override
    public String gerarComprovante() {
        return String.format("""
            ========================================
                 COMPROVANTE DE PAGAMENTO
            ========================================
            Método: Cartão de Crédito
            ID Transação: %s
            Cartão: %s
            Titular: %s
            Valor: R$ %.2f
            Parcelas: %dx de R$ %.2f
            Status: %s
            ========================================
            """,
                id, numeroCartao, nomeTitular, valor, parcelas,
                valor.divide(BigDecimal.valueOf(parcelas), 2, BigDecimal.ROUND_HALF_UP),
                status);
    }

    private String mascararCartao(String numero) {
        return "**** **** **** " + numero.substring(numero.length() - 4);
    }
}