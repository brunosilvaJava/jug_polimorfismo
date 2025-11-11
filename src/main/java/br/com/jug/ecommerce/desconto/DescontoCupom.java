package br.com.jug.ecommerce.desconto;

import br.com.jug.ecommerce.dominio.Pedido;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.IO.println;

public class DescontoCupom implements Desconto {

    private final String codigoCupom;

    // Simulação de base de cupons válidos
    private static final Map<String, BigDecimal> CUPONS_VALIDOS = new HashMap<>();

    static {
        CUPONS_VALIDOS.put("BEMVINDO10", new BigDecimal("0.10"));
        CUPONS_VALIDOS.put("BLACKFRIDAY", new BigDecimal("0.30"));
        CUPONS_VALIDOS.put("NATAL2024", new BigDecimal("0.20"));
    }

    public DescontoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom.toUpperCase();
    }

    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        BigDecimal percentual = CUPONS_VALIDOS.get(codigoCupom);

        if (percentual != null) {
            BigDecimal desconto = pedido.calcularSubtotal().multiply(percentual);
            {
                println("🎫 Cupom '" + codigoCupom + "' aplicado: " +
                        percentual.multiply(new BigDecimal("100")) + "% = R$ " + desconto);
            }
            return desconto;
        }

        {
            println("❌ Cupom inválido: " + codigoCupom);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String getDescricao() {
        return "Desconto por Cupom (" + codigoCupom + ")";
    }
}