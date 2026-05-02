package com.leonardobarbosa.javastudy.utils.strings;

public class StringBuilderExample {
    public static void main(String[] args) {

        /*
         STRINGBUILDER vs STRING
         - String é imutável: concatenar em loop cria N objetos desnecessários na memória
         - StringBuilder é mutável: ideal para construção dinâmica de strings (não é thread-safe)
         - StringBuffer: igual ao StringBuilder, porém thread-safe (mais lento)

         REGRA PRÁTICA:
         - Use String para textos fixos ou poucas concatenações
         - Use StringBuilder dentro de loops ou quando montar strings dinamicamente
         */

        // String em loop -> cria um novo objeto a cada interação
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i;
        }
        System.out.println(result);     // 01234


        // Solução com StringBuilder -> modifica o mesmo objeto (mais rápido/eficiente)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            s.append(i);
        }
        System.out.println(s);

        // Principais métodos do StringBuilder
        StringBuilder sb = new StringBuilder("Java");

        sb.append(" é incrível");       // adiciona ao final -> "Java é incrível"
        sb.insert(4, " realmente");      // insere na posição -> "Java realmente é incrível"
        System.out.println(sb);
        sb.replace(5, 14, "21"); // substitui intervalo -> "Java 21 é incrível"
        System.out.println(sb);
        sb.delete(4, 7);       // remove intervalo
        System.out.println(sb);
        sb.reverse();           // inverte


        // Encadeamento de métodos (Fluent interface)
        String name = new StringBuilder()
                .append("Leonardo")
                .append(" ")
                .append("Barbosa").toString();
        System.out.println(name);       // Leonardo Barbosa

        // Capacidade -> tamanho interno do buffer (cresce automaticamente)
        StringBuilder stb = new StringBuilder(50);
        System.out.println(stb.capacity());
    }
}
