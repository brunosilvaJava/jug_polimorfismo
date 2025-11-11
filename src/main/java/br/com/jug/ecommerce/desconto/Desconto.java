package br.com.jug.ecommerce.desconto;

import br.com.jug.ecommerce.dominio.Pedido;
import java.math.BigDecimal;

/**
 * POLIMORFISMO através de INTERFACE
 */
public interface Desconto {

    /**
     * Calcula o desconto aplicável ao pedido.
     * Cada estratégia implementa sua regra de negócio.
     */
    BigDecimal calcularDesconto(Pedido pedido);

    /**
     * Retorna descrição da estratégia para logs/relatórios
     */
    String getDescricao();
}