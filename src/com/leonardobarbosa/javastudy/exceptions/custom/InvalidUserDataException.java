package com.leonardobarbosa.javastudy.exceptions.custom;

public class InvalidUserDataException {
    public static void main(String[] args) {

        /*
        Padrão comum em sistemas reais
        Validação clara e reutilizável

        Custom Exception
        - evita uso genérico de IllegalArgumentException
         */

        try {
            register("");
        } catch (InvalidDataException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        /*
        Boas práticas:
        - Nome claro
        - Evitar excesso
        - Na maioria dos casos se usa exceções do tipo unchecked (RuntimeException)
        - Sempre passar uma mensagem

        Custom Exception cria um erro com significado, melhora leitura e manutenção
         */
    }

    static void register(String name) throws InvalidDataException {
        if (name == null || name.isBlank()) {
            throw new InvalidDataException();
        }
        System.out.println("Usuário cadastrado com sucesso");
    }
}

class InvalidDataException extends Exception {

    public InvalidDataException() {
        super("Dados inválidos");
    }
}
