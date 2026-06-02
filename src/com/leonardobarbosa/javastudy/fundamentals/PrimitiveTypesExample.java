package com.leonardobarbosa.javastudy.fundamentals;


public class PrimitiveTypesExample {
    public static void main(String[] args) {

        /*
        byte = (1 byte) -128 to 127
        short = (2 bytes) -32768 to 32767
        int = (4 bytes) -2,147,483,648 to 2,147,483,647
        long = (8 bytes) -9,223,372,036,854,775,808 to 9223372036854750000

        float = (4 bytes) decimal 2.500f
        double = (8 bytes) 125.000

        boolean = (1 bit) true - false

        char = (2 bytes) 'M' - (number) Table ASCII - (number) Unicode Table
         */

        byte byteNumber = 127;
        short shortNumber = 32767;
        int intNumber = 2147483647;
        long longNumber = 9223372036854750000L;

        float floatNumber = 2.500f;
        double doubleNumber = 125.000;

        boolean booleanTrue = true;

        char charCode = '\u0041';

        System.out.println("Byte " + byteNumber);
        System.out.println("Short " + shortNumber);
        System.out.println("Int " +intNumber);
        System.out.println("Long " + longNumber);
        System.out.printf("Float %.3f%n" , floatNumber);
        System.out.printf("Double %.3f%n" , doubleNumber);
        System.out.println("Boolean " + booleanTrue);
        System.out.println("Char " + charCode);

        /*
        Eu <name>, morando no endereço <endereço>, confirmo que recebi
        o salário de <salário>, na data <date>
         */

        String name = "Leonardo";
        String adress = "Rua: José Soares de Assunção";
        float salary = 2359f;
        String paymentDate = "11/02/2026";

        /*
        Especificadores de formato:

        %s = String
        %d = byte, short, int, long
        %f = float, double
        %c = char
        %n ou \n = quebra de linha
        %b = boolean

        Comandos de formatação:

        %.2f = Limita para 2 casas após a vírgula
        %, = adiciona separador de milhar (1000 = 1,000)
         */

        System.out.printf("\nEu %s, morando no endereço %s, confirmo que recebi " +
                "o salário de R$: %,.2f na data %s", name, adress, salary, paymentDate, "\n");

    }
}
