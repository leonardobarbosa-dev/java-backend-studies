package com.leonardobarbosa.javastudy.exceptions.types.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionBasic {
    public static void main(String[] args) {

        /*
        Checked Exceptions:

        - o compilador obriga o tratamento ou declaração com throws
        - geralmente representam problemas externos ao programa
        - não são necessariamente erros de programação

        Exemplos:
        - IOException
        - FileNotFoundException
        - SQLException

        Tratamento possível:
        - try/catch
        - throws
         */

//        FileReader fileR = new FileReader("text.txt");      // o código não compila

        /*
        Demonstrar a propagação de uma Checked Exception:

        Fluxo:
        readFileTwo() -> lança
        readFileOne() -> repassa
        main() -> trata

        Uma Checked Exception pode se propagar pela call stack,
        mas obrigatoriamente deve ser tratada ou declarada com throws
         */

        try {
            readFileTwo();
        } catch (FileNotFoundException e) {
            System.out.println("Erro capturado no main: " + e.getMessage());
        }
    }

    public static void readFileTwo() throws FileNotFoundException {
        readFileOne();
    }

    public static void readFileOne() throws FileNotFoundException {
        FileReader fileReader = new FileReader("text.txt");
    }

}
