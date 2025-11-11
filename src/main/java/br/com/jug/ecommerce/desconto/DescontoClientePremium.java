package br.com.jug.ecommerce.desconto;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.dominio.TipoCliente;
import java.math.BigDecimal;

import static java.lang.IO.println;

/**
 * Estratégia CONCRETA: Desconto para Clientes Premium
 *
 * Regra de Negócio: 25% de desconto para clientes Premium
 */
public class DescontoClientePremium implements Desconto {

    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.25");

    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        if (pedido.getCliente().getTipo() == TipoCliente.PREMIUM) {
            BigDecimal desconto = pedido.calcularSubtotal().multiply(PERCENTUAL_DESCONTO);
            {
                println("💎 Desconto Premium aplicado: 25% = R$ " + desconto);
            }
            return desconto;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String getDescricao() {
        return "Desconto Cliente Premium (25%)";
    }
}