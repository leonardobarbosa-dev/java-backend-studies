package com.leonardobarbosa.javastudy.patterns.factory;

public class FactoryExample {

    /*
    Factory Pattern -> centraliza a criação de objetos,
    escondendo a lógica de qual implementação instanciar.

    - A interface define o contrato.
    - A fábrica decide qual implementação criar.
    - O enum define os tipos disponíveis.
     */

    public static void main(String[] args) {

        Notification email = NotificationFactory.create(NotificationType.EMAIL);
        email.send("(Seu e-mail foi confirmado. Bem vindo ao sistema!)");

        Notification sms = NotificationFactory.create(NotificationType.SMS);
        sms.send("(Seu código de confirmação é: 1983647843)");
    }
}
