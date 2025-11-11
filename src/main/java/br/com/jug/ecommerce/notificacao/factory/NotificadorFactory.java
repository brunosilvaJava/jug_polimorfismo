package br.com.jug.ecommerce.notificacao.factory;

import br.com.jug.ecommerce.notificacao.*;

public class NotificadorFactory {

    public static Notificador criar(TipoNotificacao tipo) {
        return switch (tipo) {
            case EMAIL -> new NotificadorEmail();
            case SMS -> new NotificadorSMS();
            case WHATSAPP -> new NotificadorWhatsApp();
        };
    }
}