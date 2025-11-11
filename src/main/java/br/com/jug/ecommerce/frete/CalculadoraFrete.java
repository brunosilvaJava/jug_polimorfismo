package br.com.jug.ecommerce.frete;

import br.com.jug.ecommerce.dominio.Pedido;
import java.math.BigDecimal;

/**
 * STRATEGY PATTERN - Interface para cálculo de frete
 *
 * POLIMORFISMO: Diferentes transportadoras calculam de formas diferentes
 */
public interface CalculadoraFrete {

    BigDecimal calcularFrete(Pedido pedido, String cep);

    String getNomeTransportadora();

    int getPrazoEntregaDias();
}