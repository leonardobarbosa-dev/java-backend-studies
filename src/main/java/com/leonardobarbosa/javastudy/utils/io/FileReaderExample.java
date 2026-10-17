package com.leonardobarbosa.javastudy.utils.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {

        /*
        FileReader -> lê caracteres de arquivos de texto (um caractere por vez)

        - retorna código Unicode do caractere lido
        - read() retorna um int
        - quando chega ao final do arquivo retorna -1
         */

        try  (FileReader fileReader = new FileReader("file.txt")) {

            /*
            read() retorna int para permitir o valor especial -1
            indicando o fim do arquivo
             */
            int character;
            while ((character = fileReader.read()) != -1) { // fim do arquivo retorna -1
                System.out.print((char) character); // converte o código Unicode para caractere (cast)
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
