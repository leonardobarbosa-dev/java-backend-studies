package com.leonardobarbosa.javastudy.oop.polymorphism.service;

import com.leonardobarbosa.javastudy.oop.polymorphism.domain.Butter;
import com.leonardobarbosa.javastudy.oop.polymorphism.domain.Product;

public class TaxCalculator {

    public static void calculateTax(Product product) {
        System.out.println("Relatório do produto:");

        double tax = product.calculateTax();
        System.out.println("Produto: " + product.getName());
        System.out.println("Valor: " + product.getValue());
        System.out.println("Imposto sobre o valor do produto: " + tax);

        if (!product.getAdditionalInfo().isEmpty()) {
            System.out.println(product.getAdditionalInfo());
        }

        /*
        Tem maneiras melhores de fazer isso (getAdditionalInfo();), mas esse é apenas um exemplo e, como o Produto(Butter)
        é o único que tem esse atributo (expirationDate), o instanceof resolve...

        - instanceof = último recurso, não primeira opção

        instanceof -> verifica o tipo real do objeto em tempo de execução.
        - É util em alguns cenários específicos,
        mas normalmente o polimorfismo deve ser preferido
        para evitar verificadores de tipo excessivas.
         */
        if (product instanceof Butter butter){
            System.out.println("Validade: " + butter.getExpirationDate());
        }
    }
}
