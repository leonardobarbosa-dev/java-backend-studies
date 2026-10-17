package com.leonardobarbosa.javastudy.oop.interfaces.test;

import com.leonardobarbosa.javastudy.oop.interfaces.domain.DataLoader;
import com.leonardobarbosa.javastudy.oop.interfaces.domain.DatabaseLoader;
import com.leonardobarbosa.javastudy.oop.interfaces.domain.FileLoader;

public class InterfacesExample {
    public static void main(String[] args) {

        DatabaseLoader dataBaseLoader = new DatabaseLoader();
        dataBaseLoader.load();
        dataBaseLoader.checkPermission();


//        ------------------------------------------------------------


        FileLoader fileLoader = new FileLoader();
        fileLoader.load();
        fileLoader.checkPermission();

//        ------------------------------------------------------------


        /*
        Metodos static da interface pertencem a própria interface,
        não aos objetos que a implementam.
         */
        DataLoader.retrieveMaxDataSize();

        /*
        Outra forma de pegar o valor -> pela constante
         */
        System.out.println("\nTamanho máximo dos dados: " + DataLoader.MAX_DATA_SIZE);
    }
}
