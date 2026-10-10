package com.leonardobarbosa.javastudy.patterns.singleton.eager;

public class EagerSingletonExample {
    public static void main(String[] args) {

        EagerSingleton eager1 = EagerSingleton.getINSTANCE();
        EagerSingleton eager2 = EagerSingleton.getINSTANCE();

        System.out.println(eager1);
        System.out.println(eager2);

        System.out.println("Mesma instancia ? -> " + (eager1 == eager2));
    }
}
