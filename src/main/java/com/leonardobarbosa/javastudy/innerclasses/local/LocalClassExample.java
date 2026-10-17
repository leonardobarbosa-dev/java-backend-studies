package com.leonardobarbosa.javastudy.innerclasses.local;

public class LocalClassExample {

    private String name = "LocalClassExample";

    public void printMessage(String message) {

        /*
        Classe local -> definida dentro de um metodo
        - existe apenas dentro do escopo do metodo
        - acessa membros da classe externa (inclusive private)
        - acessa variáveis locais do metodo, mas apenas se forem
          effectively final (não reatribuídas após a primeira atribuição)
         */

        String prefix = "-> ";   // effectively final -> não é reatribuída

        class LocalPrinter {
            void print() {
                System.out.println(name + " " + prefix + message);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.print();
    }

    public static void main(String[] args) {
        LocalClassExample example = new LocalClassExample();
        example.printMessage("hello from local class");
        example.printMessage("second call");
    }
}