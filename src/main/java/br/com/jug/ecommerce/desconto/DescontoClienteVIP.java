package br.com.jug.ecommerce.desconto;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.dominio.TipoCliente;
import java.math.BigDecimal;

import static java.lang.IO.println;

/**
 * Estratégia CONCRETA: Desconto para Clientes VIP
 *
 * Regra de Negócio: 15% de desconto para clientes VIP
 */
public class DescontoClienteVIP implements Desconto {

    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.15");

    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        if (pedido.getCliente().getTipo() == TipoCliente.VIP) {
            BigDecimal desconto = pedido.calcularSubtotal().multiply(PERCENTUAL_DESCONTO);
            println("🌟 Desconto VIP aplicado: 15% = R$ " + desconto);
            return desconto;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String getDescricao() {
        return "Desconto Cliente VIP (15%)";
    }
}