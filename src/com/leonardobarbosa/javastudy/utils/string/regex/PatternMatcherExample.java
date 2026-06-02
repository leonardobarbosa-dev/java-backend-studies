package com.leonardobarbosa.javastudy.utils.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {
    public static void main(String[] args) {

        /*
        Pattern -> regex compilada
        Matcher -> executa buscas sobre o texto

        find()      -> procura ocorrências
        group()     -> retorna texto encontrado
        group(n)    -> retorna grupo de captura
         */

        String text = "Emails: joao@email.com e maria@test.org";

        Pattern pattern = Pattern.compile("[\\w.]+@[\\w.]+\\.[a-z]{2,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        // Grupos de captura
        String log = "2026-05-01 ERROR NullPointerException";

        Pattern logPattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}) (\\w+) (.+)");
        Matcher logMatcher = logPattern.matcher(log);

        if (logMatcher.matches()) {
            System.out.println(logMatcher.group(1));
            System.out.println(logMatcher.group(2));
            System.out.println(logMatcher.group(3));
        }
    }
}
