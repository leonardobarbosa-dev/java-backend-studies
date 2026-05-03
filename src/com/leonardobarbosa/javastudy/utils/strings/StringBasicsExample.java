package com.leonardobarbosa.javastudy.utils.strings;

public class StringBasicsExample {
    public static void main(String[] args) {

        /*
         String é um objeto imutável (qualquer alteração cria um novo objeto na memória)
         Literais são armazenados no String Pool (área especial do Heap)

         Por que é imutável:
         - Segurança: strings são usadas como chaves em HashMap, em paths,
           credenciais. Se fossem mutáveis, seriam vulneráveis.
         - Thread-safety: múltiplas threads podem ler o mesmo objeto sem risco.
         - String Pool: permite reuso de objetos idênticos na memória.
         */

        // Imutabilidade
        String s1 = "Java";
        String s2 = s1;             // Aponta para o mesmo objeto
        s1 = s1.concat(" 21");  // Cria um novo objeto e s1 passa a apontar para ele

        System.out.println(s1);    // Java 21
        System.out.println(s2);    // Java = o original não mudou

        // String poll (Heap vs Pool)
        String a = "Java";                     // vai para o String Pool
        String b = "Java";                     // reutiliza o mesmo objeto do pool
        String c = new String("Java");  // FORÇA criação no heap comum

        System.out.println(a == b);       // true  — mesmo objeto no pool
        System.out.println(a == c);       // false — objetos diferentes (c está fora do pool)
        System.out.println(a.equals(c));  // true  — mesmo CONTEÚDO


        // intern() - força String do heap para o pool
        String d = new String("Java").intern();     // vai para o pool
        System.out.println(a == d);                        // true = agora é o mesmo
        /*
        String Pool existe para economizar memória.
        Literais idênticos apontam para o mesmo objeto. new String() contorna isso propositalmente
        --------------------------------------------------------------------------------------------
        */

        // Case-insensitive
        System.out.println("java".equalsIgnoreCase("JAVA")); // true

        /*
        Literal "abc"           - vai para o String pool
        new String("abc")       - vai para o Heap comum
        == compara referência   - onde está na memória
        .equals()               - compara o conteúdo

        NUNCA compare Strings com ==.
        Use sempre equals() ou equalsIgnoreCase().
        O == compara endereço de memória, não conteúdo
         */

    }
}
