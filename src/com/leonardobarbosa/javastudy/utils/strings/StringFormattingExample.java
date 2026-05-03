package com.leonardobarbosa.javastudy.utils.strings;

public class StringFormattingExample {
    public static void main(String[] args) {
        /*
        Formatação de Strings
        - String.format() -> cria uma String formatada
        - formatted() -> metodo de instancia equivalente
        - printf() -> imprime diretamente formatado
        - text blocks -> String multilinhas com identação limpa
         */

        /*
        Especificadores comuns
        %s = String | %d = inteiro | %f = float | %n = quebra de linha
        */
        String name = "Leonardo";
        int age = 27;
        double pay = 4500.75;

        String formatted = String.format("Nome: %s | Idade: %d | Salário: %.2f", name, age, pay);
        System.out.println(formatted);

        // Alinhamento e largura
        System.out.printf("%-15s %5d%n", "Java", 2024);   // alinha à esquerda / direita
        System.out.printf("%-15s %5d%n", "Python", 1991);

        // Java 15+: metodo formatted() na instância
        String msg = "Olá, %s! Você tem %d anos.".formatted(name, age);
        System.out.println(msg);

        // --- Text Block (Java 15+) ---
        // Ideal para JSON, SQL, HTML embutidos no código
        // A identação é removida automaticamente com base na posição do """

        String json = """
                {
                    "nome": "%s"
                    "idade": %d
                }
                """.formatted(name, age);
        System.out.println(json);

        String sql = """
                SELECT *
                FROM usuarios
                WHERE nome = '%s'
                """.formatted(name);
        System.out.println(sql);

        /*
        São uma sintaxe para strings multilinhas, delimitadas por três aspas duplas ("""),
        que facilitam a criação de textos estruturados como JSON, HTML ou SQL.
        Eles eliminam a necessidade de concatenações (+) e caracteres de escape (\n, \"),
        preservando a formatação original.
         */
    }
}
