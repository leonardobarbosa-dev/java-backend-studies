package com.leonardobarbosa.javastudy.utils.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {

        /*
        BufferedWriter -> adiciona um buffer à escrita de caracteres

        - funciona como um bloco de notas temporário na memória
        - acumula vários dados antes de gravá-los no arquivo
        - é como juntar várias cartas e fazer uma única viagem aos correios
        - reduz acessos ao disco, melhorando a performance
        - normalmente é usado em conjunto com FileWriter
        - newLine() -> quebra de linha independente do sistema operacional
         */

        try  (FileWriter fileWriter = new FileWriter("file.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // escreve igual ao FileWriter, mas guarda temporariamente os dados em memória para escrever de forma mais eficiente
            bufferedWriter.write("Testando BufferedWriter");
            bufferedWriter.newLine();
            bufferedWriter.write("Segunda linha");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
