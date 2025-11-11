package br.com.jug.ecommerce.frete;

import br.com.jug.ecommerce.dominio.Pedido;

import java.math.BigDecimal;

import static java.lang.IO.println;

public class FreteService {

    public static void aplicarFrete(Pedido pedido) {

        CalculadoraFrete calculadora = switch (pedido.getTipoFrete()) {
            case SEDEX -> new FreteSedex();
            case CORREIOS -> new FreteCorreios();
            case TRANSPORTADORA -> new FreteTransportadora();
        };
        {
            println("\n🚚 Calculando frete para CEP: " + pedido.getCliente().getCep());
            println("   Transportadora: " + calculadora.getNomeTransportadora());
        }
        BigDecimal frete = calculadora.calcularFrete(pedido, pedido.getCliente().getCep());
        pedido.setValorFrete(frete);
        {
            println("   Prazo de entrega: " + calculadora.getPrazoEntregaDias() + " dias");
            println("   💵 Valor total do pedido: R$ " + pedido.calcularValorTotal());
        }
    }
}
