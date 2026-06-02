package com.leonardobarbosa.javastudy.oop.constructors.test;
import com.leonardobarbosa.javastudy.oop.constructors.domain.Constructor;

public class ConstructorExample {
    public static void main(String[] args) {

        Constructor anime = new Constructor("Pokemon");
        anime.print();

        anime = new Constructor("Dragon Ball Z", "Luta");
        anime.print();

        anime = new Constructor("Vinland Saga", "Relgião", 2);
        anime.print();

        anime = new Constructor("Death Note", "Suspense/Investigação", 2, 44);
        anime.print();
    }
}
