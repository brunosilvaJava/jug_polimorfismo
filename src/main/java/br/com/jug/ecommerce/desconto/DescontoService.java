package br.com.jug.ecommerce.desconto;

import br.com.jug.ecommerce.dominio.Pedido;
import br.com.jug.ecommerce.dominio.TipoCliente;

import java.math.BigDecimal;
import java.util.Optional;

import static java.lang.IO.println;

public class DescontoService {

    public static void aplicarDesconto(Pedido pedido) {

        TipoCliente tipoCliente = pedido.getCliente().getTipo();

        Optional<Desconto> descontoOptional = switch (tipoCliente) {
            case VIP -> Optional.of(new DescontoClienteVIP());
            case PREMIUM -> Optional.of(new DescontoClientePremium());
            default -> Optional.empty();
        };

        if (descontoOptional.isEmpty()) {
            {
                println("\n💰 Nenhum desconto aplicável para o cliente do tipo: " + tipoCliente);
            }
            return;
        }
        {
            println("\n💰 Aplicando desconto: " + descontoOptional.get().getDescricao());
        }
        BigDecimal valorDoDesconto = descontoOptional.get().calcularDesconto(pedido);
        pedido.setDesconto(valorDoDesconto);
        {
            println("   Subtotal após desconto: R$ " + pedido.calcularSubtotal().subtract(valorDoDesconto));
        }
    }
}
