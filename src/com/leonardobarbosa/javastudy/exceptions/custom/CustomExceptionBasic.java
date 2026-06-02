package com.leonardobarbosa.javastudy.exceptions.custom;

public class CustomExceptionBasic {
    public static void main(String[] args) {

        /*
        Criar primeira exception
        - ela herda de RuntimeException

        class Custom exception
        - é uma classe que representa um erro específico
         */


        throw new CustomException();

        /*
        Custom Exceptions

        São exceções criadas pelo desenvolvedor para representar
        erros específicos da aplicação.

        Vantagens:
        - melhora a legibilidade do código
        - dão dignificado aos erro
        - facilitam manutenção
        - evitam uso excessivo de exceções genéricas

        Podem ser:
        - unchecked (extends RuntimeException)
        - checked (extends Exception)

        Na maioria das aplicações modernas, exceções customizadas
        costumam herdar de RuntimeException
         */
    }
}

class CustomException extends RuntimeException {

    public CustomException() {
        super("Erro customizado");
    }

    // Opção para escrever a mensagem de erro
    public CustomException(String message) {
        super(message);
    }
}



