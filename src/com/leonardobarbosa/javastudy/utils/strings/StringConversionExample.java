package com.leonardobarbosa.javastudy.utils.strings;

public class StringConversionExample {
    public static void main(String[] args) {

        /*
         CONVERSÃO ENTRE STRING E OUTROS TIPOS:
         - String para primitivo: métodos parse* da classe Wrapper
         - Primitivo para String: String.valueOf() ou concatenação com ""
         - valueOf() é mais seguro que concatenar pois trata null sem NPE
         */

        // String -> Primitivo
        int numInt = Integer.parseInt("42");
        double numDouble = Double.parseDouble("3.14");
        boolean flag = Boolean.parseBoolean("true");    // case insensitive
        long numLong = Long.parseLong("9999999999");

        System.out.println(numInt + 1);      // 43
        System.out.println(numDouble * 2);   // 6.28
        System.out.println(flag);            // true

        // Lança NumberFormatException se o formato for inválido
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Formato inválido: " + e.getMessage());
        }

        // Primitivo -> String
        String s1 = String.valueOf(42);        // "42"
        String s2 = String.valueOf(3.14);     // "3.14"
        String s3 = String.valueOf(true);     // "true"
        String s4 = String.valueOf('A');      // "A"

        // Alternativa com toString() das wrappers
        String s5 = Integer.toString(42);     // "42"
        String s6 = Double.toString(3.14);    // "3.14"

        // Concatenação com "" também funciona, mas é menos explícito
        String s7 = 42 + "";                  // "42" (evite: mistura tipo e semântica)

        System.out.println(s1 + s2 + s3);     // 423.14true

        // String -> char[] e char[] -> String
        char[] letters = "Java".toCharArray();
        for (char c : letters) {
            System.out.print(c + " ");      // J a v a
        }
        System.out.println();

        String returnString = new String(letters);
        System.out.println(returnString);   // "Java"
    }
}
