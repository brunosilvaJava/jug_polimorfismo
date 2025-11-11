package br.com.jug.ecommerce.dominio;

public class DadosCartao {

    private final String numeroCartao;
    private final String nomeTitular;
    private final String codigoSeguranca;

    public DadosCartao(String numeroCartao, String nomeTitular, String codigoSeguranca) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

}
