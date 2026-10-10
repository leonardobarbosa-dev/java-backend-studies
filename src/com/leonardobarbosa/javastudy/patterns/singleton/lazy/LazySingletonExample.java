package com.leonardobarbosa.javastudy.patterns.singleton.lazy;

import java.util.concurrent.TimeUnit;

public class LazySingletonExample {
    public static void main(String[] args) {

        System.out.println("Solicitando a primeira instancia...");
        LazySingleton lazy1 = LazySingleton.getINSTANCE();
        sleep();
        System.out.println(lazy1);

        System.out.println("Solicitando a segunda instancia...");
        LazySingleton lazy2 = LazySingleton.getINSTANCE();
        sleep();
        System.out.println(lazy2);


        System.out.println("Mesma instancia ? -> " + (lazy1 == lazy2));
    }

    static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
