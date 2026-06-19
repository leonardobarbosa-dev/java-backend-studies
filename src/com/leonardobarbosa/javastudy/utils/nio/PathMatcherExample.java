package com.leonardobarbosa.javastudy.utils.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherExample {
    public static void main(String[] args) {

        /*
        PathMatcher -> verifica se um Path corresponde a um padrão

        *   -> qualquer sequência de caracteres -> glob:*.java

        **  -> qualquer sequência de caracteres incluindo diretórios    -> glob:** /*.java

        ?   -> exatamente uma quantidade de caracteres  -> glob:*.??

        [abc]   -> um dos caracteres informados -> glob:[abc].txt
        [!abc]  -> qualquer caractere menos os informados

        {README,file}   -> uma das opçoes

        *.{java,xml,json}   -> múltiplas extensões

        ** -> qualquer quantidade de diretórios    -> glob:src/** /*.java
         */

        Path path = Paths.get("fundamentals/README.md");

        matches(path, "glob:**/*.??");

    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + " = " + matcher.matches(path));
    }
}
