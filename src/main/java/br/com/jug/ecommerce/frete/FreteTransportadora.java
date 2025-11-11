package br.com.jug.ecommerce.frete;

import br.com.jug.ecommerce.dominio.Pedido;
import java.math.BigDecimal;

import static java.lang.IO.println;

public class FreteTransportadora implements CalculadoraFrete {

    @Override
    public BigDecimal calcularFrete(Pedido pedido, String cep) {
        // Cálculo baseado no subtotal
        BigDecimal percentual = new BigDecimal("0.10"); // 10% do subtotal
        BigDecimal frete = pedido.calcularSubtotal().multiply(percentual);

        // Mínimo de R$ 20
        if (frete.compareTo(new BigDecimal("20.00")) < 0) {
            frete = new BigDecimal("20.00");
        }

        {
            println("🚚 " + getNomeTransportadora() + ": R$ " + frete +
                    " (Prazo: " + getPrazoEntregaDias() + " dias)");
        }
        return frete;
    }

    @Override
    public String getNomeTransportadora() {
        return "Transportadora Parceira";
    }

    @Override
    public int getPrazoEntregaDias() {
        return 7;
    }
}