package com.leonardobarbosa.javastudy.utils.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasicsExample {
    public static void main(String[] args) {

        /**
         * EXPRESSÕES REGULARES (REGEX) COM STRINGS
         * - Regex é uma linguagem para descrever padrões em texto
         * - Java usa java.util.regex.Pattern e Matcher
         * - String possui atalhos: matches(), replaceAll(), split() que aceitam regex
         *
         * PADRÕES ESSENCIAIS:
         * .       -> qualquer caractere
         * \d      -> dígito [0-9]       |      \D -> não dígito
         * \w      -> palavra [a-zA-Z0-9_] |    \W -> não palavra
         * \s      -> espaço/tab/newline  |     \S -> não espaço
         * ^       -> início da string
         * $       -> fim da string
         * +       -> 1 ou mais
         * *       -> 0 ou mais
         * ?       -> 0 ou 1
         * {n,m}   -> entre n e m vezes
         * [abc]   -> a, b ou c
         * (a|b)   -> a ou b
         */



        // matches() -> verifica se a string INTEIRA bate com o padrão
        System.out.println("12345".matches("\\d+"));         // true -> só dígitos
        System.out.println("abc123".matches("\\d+"));        // false -> tem letras
        System.out.println("teste@email.com".matches(".+@.+\\..+")); // true -> formato básico e-mail

        // replaceAll() com regex
        String text = "Olá   mundo,  tudo  bem?";
        System.out.println(text.replaceAll("\\s+", " ")); // remove espaços duplos

        String cpf = "123.456.789-09";
        System.out.println(cpf.replaceAll("[.\\-]", "")); // "12345678909" -> remove pontos e traço

        // split() com regex
        String data = "2024-05-01";
        String[] parts = data.split("-");   // O metodo split divide a string com base em um regex separador.
        System.out.println(parts[0] + "/" + parts[1] + "/" + parts[2]); // 2024/05/01

        // Pattern e Matcher -> para buscas e grupos
        String message = "Meu e-mail é joao@email.com e backup@test.org";
        Pattern pattern = Pattern.compile("[\\w.]+@[\\w.]+\\.[a-z]{2,}");
        Matcher matcher = pattern.matcher(message);

        // find() -> encontra a próxima ocorrência (não precisa casar a string toda)
        while (matcher.find()) {
            System.out.println("Email encontrado: " + matcher.group()); // cada e-mail
        }

        // Grupos de captura com ()
        String log = "2024-05-01 ERROR NullPointerException";
        Pattern logPattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}) (\\w+) (.+)");
        Matcher logMatcher = logPattern.matcher(log);

        if (logMatcher.matches()) {
            System.out.println("Data: "  + logMatcher.group(1)); // 2024-05-01
            System.out.println("Nível: " + logMatcher.group(2)); // ERROR
            System.out.println("Msg: "   + logMatcher.group(3)); // NullPointerException
        }
    }
}
