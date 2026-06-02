package com.leonardobarbosa.javastudy.oop.enums.domain;

public class Client {

    private final String name;
    private final ClientType clientType;
    private final PaymentType paymentType;

    public Client(String name, ClientType clientType, PaymentType paymentType) {
        this.name = name;
        this.clientType = clientType;
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", clientTypeID=" + clientType.getId() +
                ", clientDescription=" + clientType.getClientDescription() +
                ", paymentType=" + paymentType.getPayment() +
                '}';
    }
}
