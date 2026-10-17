package com.leonardobarbosa.javastudy.oop.enums.domain;

public enum PaymentType {

    DEBIT_CARD("Débito"){
        @Override
        public double calculateDiscount(double valor) {
            return valor * 0.1;
        }
    },
    CREDIT_CARD("Crédito"){
        @Override
        public double calculateDiscount(double valor) {
            return valor * 0.05;
        }
    };

    private final String payment;

    PaymentType(String payment) {
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }


    // Metodo abstract = criado apenas para ser sobrescrito (obrigatoriamente), não pode ter corpo
    public abstract double calculateDiscount(double valor);
}
