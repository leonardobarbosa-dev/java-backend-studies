package com.leonardobarbosa.javastudy.utils.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {

        /*
        FileWriter

        - escreve texto em arquivos caractere a caractere
        - por padrão sobrescreve o conteúdo do arquivo
        - usando o segundo parâmetro como true: new FileWriter(file, true)
          o conteúdo é adicionado ao final do arquivo (append)
        - close() -> chama o flush() automaticamente antes de fechar
        - sempre usar o try-with-resources para fechar automaticamente
         */

        File file = new File("file.txt");

        try  (FileWriter fileWriter = new FileWriter(file, true)) { // append (true) -> adiciona ao final sem apagar conteúdo
            fileWriter.write("Hello World\nMensagem append");

            fileWriter.flush();
            /*
            - força a escrita dos dados do buffer para o arquivo físico
            - redundante nesse exemplo, close() chama flush() automaticamente
             */

        } catch (IOException e) {
            e.printStackTrace();
        }

//        boolean deleted = file.delete();
//        System.out.println("Arquivo deletado: " + deleted);
    }
}
