package com.leonardobarbosa.javastudy.patterns.factory;

import java.util.concurrent.TimeUnit;

public interface Notification {

    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("E-mail enviado: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS enviado: " + message);
    }
}

class NotificationFactory {

    public static Notification create(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("O tipo de notificação não pode ser nulo");
        }

        return switch (type) {
            case EMAIL -> {
                System.out.println("Enviando e-mail...");
                yield new EmailNotification();
            }
            case SMS -> {
                System.out.println("Enviando SMS...");
                yield new SMSNotification();
            }
        };
    }
    /*
     Switch tradicional -> controla o fluxo de execução.
     Switch expression -> produz um valor, que pode ser retornado.

     return switch (...) -> retorna o valor produzido pela expressão.
     -> evita fall-through entre os cases.
     Se precisar executar várias instruções, utilizar um bloco com chaves
     yield -> fornece um valor quando o case usa um bloco com várias instruções.

     Se precisa escolher entre valores e retornar um deles,
     return switch costuma deixar o código mais direto.
     Se precisa executar várias instruções independentes em cada caso,
     o switch tradicional também continua sendo uma boa opção.

     */
}
