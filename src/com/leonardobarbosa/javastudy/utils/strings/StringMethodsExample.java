package com.leonardobarbosa.javastudy.utils.strings;

public class StringMethodsExample {
    public static void main(String[] args) {

        /*
        Principais métodos de Strings:
        - Strings possuem uma API rica. Os métodos não alteram o original
        -sempre retornam um novo objeto
         */

        String text = "  Java é poderoso  ";

        // Limpeza
        System.out.println(text.trim());           // remove os espaços nas bordas (não remove no meio)
        System.out.println(text.strip());          // igual ao trim, mas suporta unicode (preferível desde Java 11)
        System.out.println(text.stripLeading());   // remove só do início
        System.out.println(text.stripTrailing());  // remove só do fim

        // Busca
        String message = "Java é uma linguagem Java";
        System.out.println(message.contains("linguagem"));   // true
        System.out.println(message.indexOf("Java"));         // 0 (primeira ocorrência)
        System.out.println(message.lastIndexOf("Java")); // 21 (ultima ocorrência)
        System.out.println(message.startsWith("Java"));      // true
        System.out.println(message.endsWith("Java"));        // true

        // Extração
        String word = "programming";
        System.out.println(word.substring(0, 5));           // "progr" -> índice final exclusivo (0 até 5-1)
        System.out.println(word.substring(8));    // "ção"-> até o fim (8+1 até o final)

        // Transformação
        System.out.println("hello".toUpperCase());      // "HELLO"
        System.out.println("HELLO".toLowerCase());      // "hello"
        System.out.println("Java".replace('a', 'e'));   // "Jeve"
        System.out.println("Java".replace("Java", "Python"));   // "Python"
        System.out.println("a,b,c".replaceAll("[,]", " - "));   // usa regex

        // Divisão e junção
        String list = "nome,idade,cidade";
        String[] wordsList = list.split("[,]");
        for (String w : wordsList) {
            System.out.println(w);
        }
        /*
        O metodo .split() serve para dividir uma String em várias partes, baseando-se em um
        delimitador que você define. Ele "corta" o texto nos pontos onde encontra o delimitador
        (no exemplo acima a vírgula[,] e devolve as partes resultantes dentro de um
        Array de Strings
         */

        String[] words = {"Java", "é", "incrível"};
        System.out.println(String.join(" ", words));
        /*
        O String.join() serve para juntar várias Strings (ou elementos de uma lista)
        em um único texto, colocando um delimitador a escolha entre eles sem usar regex
        (no caso do exemplo acima um espaço " ") junta as palavras do Array e faz uma frase
         */

        // Repetição (Java 11+)
        System.out.println("Ha".repeat(3));     // HAHAHA


        // Verificação de conteúdo
        System.out.println("12345".chars().allMatch(Character::isDigit));       // true
        System.out.println("abc".chars().anyMatch(Character::isUpperCase));     // false
        /*
        - .chars(): Transforma a sua String em um fluxo (Stream) de números inteiros,
          onde cada número representa o código Unicode (ASCII) de um caractere.

        - allMatch(condição): Retorna true se todos os caracteres da String atenderem à condição.
          Se um único falhar, retorna false.

        - anyMatch(condição): Retorna true se pelo menos um caractere da String atender à condição.
         */
    }
}
