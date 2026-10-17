package com.leonardobarbosa.javastudy.utils.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {

        /*
        BufferedReader -> adiciona um buffer à leitura de caracteres

        - melhora a performance, assim como o BufferedWriter

        - permite ler o arquivo linha por linha
        - normalmente é usado em conjunto com FileReader

        - readLine() retorna uma String com a linha que foi lida
          e retorna null ao chegar no final do arquivo
         */

        try  (FileReader fileReader = new FileReader("file.txt");
              BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {    // readLine() retorna null no final do arquivo
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
