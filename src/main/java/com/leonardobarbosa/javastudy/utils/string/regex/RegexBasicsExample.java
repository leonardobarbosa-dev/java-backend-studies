package com.leonardobarbosa.javastudy.utils.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasicsExample {
    public static void main(String[] args) {

        /*
        EXPRESSÕES REGULARES (regex)    -> Linguagem para descrever padrões de texto

        Metodos mais usados da String:
        - matches()
        - replaceAll()
        - split()

        Metacaracteres mais importantes:

        .           -> qualquer caractere
        \d          -> dígito [0-9]       |         \D -> não dígito
        \w          -> palavra [a-zA-Z0-9_] |       \W -> não palavra
        \s          -> espaço/tab/newline  |        \S -> não espaço (tudo dentro do texto, exceto espaços)
        ^           -> início da linha
        $           -> fim
        ?           -> zero ou uma
        *           -> zero ou mais
        +           -> uma ou mais
        []          -> conjunto
        ()          -> grupo de captura
        |           -> ou                           o(v|c)o  -> ovo ou oco
        {n,m}       -> entre n e m vezes            {n,}     -> n ou mais vezes
        [abc]       -> a, b ou c                    [^abc]   -> negação = tudo o que NÃO forem a,b ou c
        [a-zA-Z]    -> de a até z (minúsculo), de A até Z (maisúsculo)
        (a|b)       -> a ou b
         */


        // matches() -> verifica se a string inteira bate com o padrão
        System.out.println("12345".matches("\\d+"));         // só dígitos
        System.out.println("abc123".matches("\\d+"));
        System.out.println("teste@email.com".matches(".+@.+\\..+")); // formato básico e-mail


        // replaceAll() -> substitui usando regex
        String cpf = "123.456.789-09";
        System.out.println(cpf.replaceAll("[.-]", "")); // "12345678909" -> remove pontos e traço


        // split() com regex -> divide a string com base em um regex separador
        String data = "2024-05-01";
        String[] parts = data.split("-");
//        System.out.println(parts[0] + "/" + parts[1] + "/" + parts[2]); // 2024/05/01

        for (String part : parts) {
            System.out.print(part + " ");
        }
    }
}
