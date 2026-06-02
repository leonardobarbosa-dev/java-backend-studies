package com.leonardobarbosa.javastudy.utils.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAdvancedExample {
    public static void main(String[] args) {

        /*
        0           -> inicia com 0
        [xX]        -> seguido de x minúsculo ou X maiúsculo
        [0-9a-fA-F] -> o a 9 ou de a-f ou A-F
        +           -> uma ou mais vezes
        (\\s|$)     -> termina com espaço ou fim da String
         */
        String text = "12 0x 0X 0xFFABC 0x10G 0x1";
        Pattern hexPattern = Pattern.compile("0[xX][0-9a-fA-F]+(\\s|$)");
        Matcher hexMatcher = hexPattern.matcher(text);

        while (hexMatcher.find()) {
            System.out.print("Position: " + hexMatcher.start() + " Text: " + hexMatcher.group() + "\n");
        }



        String email = "lu_ffy@hotmail.com, 123.zoro@gmail.com.br, #@!Joel-miller@mail.br, sakura@email";
        String emailRegex = "[a-zA-Z0-9._-]+@[a-zA-Z]+(\\.[a-zA-Z]+)+";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        while (emailMatcher.find()) {
            System.out.print("Email encontrado: " + emailMatcher.group() + "\n");
        }

    }
}
