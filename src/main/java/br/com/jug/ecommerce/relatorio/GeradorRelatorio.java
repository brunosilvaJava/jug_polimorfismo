package br.com.jug.ecommerce.relatorio;

import br.com.jug.ecommerce.dominio.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class GeradorRelatorio {

    public final String gerarRelatorio(List<Pedido> pedidos) {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append(gerarCabecalho());
        relatorio.append("\n");

        relatorio.append(gerarConteudo(pedidos));
        relatorio.append("\n");

        relatorio.append(gerarEstatisticas(pedidos));
        relatorio.append("\n");

        relatorio.append(gerarRodape());

        posProcessamento();

        return relatorio.toString();
    }

    private String gerarCabecalho() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("""
            ================================================================================
                                    %s
            ================================================================================
            Data de Geração: %s
            --------------------------------------------------------------------------------
            """,
                getTituloRelatorio(),
                LocalDateTime.now().format(formatter));
    }

    private String gerarRodape() {
        return """
            --------------------------------------------------------------------------------
            Relatório gerado automaticamente pelo Sistema de E-commerce
            ================================================================================
            """;
    }

    protected abstract String getTituloRelatorio();

    protected abstract String gerarConteudo(List<Pedido> pedidos);

    protected abstract String gerarEstatisticas(List<Pedido> pedidos);

    protected void posProcessamento() {
        // Subclasses podem sobrescrever se necessário
    }
}