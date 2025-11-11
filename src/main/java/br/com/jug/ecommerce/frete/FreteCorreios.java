package br.com.jug.ecommerce.frete;

import br.com.jug.ecommerce.dominio.Pedido;
import java.math.BigDecimal;

import static java.lang.IO.println;

public class FreteCorreios implements CalculadoraFrete {

    @Override
    public BigDecimal calcularFrete(Pedido pedido, String cep) {

        BigDecimal taxaBase = new BigDecimal("10.00");
        BigDecimal valorPorItem = new BigDecimal("2.00");

        int quantidadeItens = pedido.getItens().size();

        BigDecimal frete = taxaBase.add(valorPorItem.multiply(BigDecimal.valueOf(quantidadeItens)));

        {
            println("📦 Correios PAC: R$ " + frete + " (Prazo: " + getPrazoEntregaDias() + " dias)");
        }
        return frete;
    }

    @Override
    public String getNomeTransportadora() {
        return "Correios PAC";
    }

    @Override
    public int getPrazoEntregaDias() {
        return 10;
    }
}