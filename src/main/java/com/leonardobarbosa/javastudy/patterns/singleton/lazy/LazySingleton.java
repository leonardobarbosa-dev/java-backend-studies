package com.leonardobarbosa.javastudy.patterns.singleton.lazy;

public class LazySingleton {

    /*
    Lazy Initialization -> a instância é criada somente
    quando getInstance() é chamado pela primeira vez.

    Atenção: esta implementação básica não é thread-safe.
    */

    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
