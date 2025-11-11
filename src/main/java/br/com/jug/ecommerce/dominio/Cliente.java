package br.com.jug.ecommerce.dominio;

import br.com.jug.ecommerce.notificacao.factory.TipoNotificacao;

/**
 * Classe que representa um Cliente do sistema.
 * Demonstra encapsulamento e será utilizada no contexto de polimorfismo.
 */
public class Cliente {

    private final String id;
    private final String nome;
    private final String email;
    private final TipoCliente tipo;
    private final String cep;
    private final TipoNotificacao tipoNotificacao;

    public Cliente(String id, String nome, String email, TipoCliente tipo, String cep, TipoNotificacao tipoNotificacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.cep = cep;
        this.tipoNotificacao = tipoNotificacao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public String getCep() {
        return cep;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}