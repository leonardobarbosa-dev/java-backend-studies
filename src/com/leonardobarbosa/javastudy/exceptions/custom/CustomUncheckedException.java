package com.leonardobarbosa.javastudy.exceptions.custom;

public class CustomUncheckedException {
    public static void main(String[] args) {

        /*
        Criar exception que não necessita de try/catch

        RuntimeException
        - não necessita de tratamento
         */


        validateAge(15);
    }

    static void validateAge(int age) {
        if (age <18) {
            throw new InvalidAgeException("Idade não pode ser menor que 18 anos");
        }
    }
}

class InvalidAgeException extends RuntimeException {

    public InvalidAgeException() {
        super("Menor de idade");
    }

    public InvalidAgeException(String message) {
        super(message);
    }
}
