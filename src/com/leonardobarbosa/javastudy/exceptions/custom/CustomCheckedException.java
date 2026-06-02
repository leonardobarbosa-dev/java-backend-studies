package com.leonardobarbosa.javastudy.exceptions.custom;

public class CustomCheckedException {
    public static void main(String[] args) {

        /*
        Criar exception que seja obrigatória tratar ou declarar

        Exception
        - obrigatório tratar ou declarar
         */


        try {
            process();
        } catch (ProcessingException e) {
            System.out.println("Tratado no main: " + e.getMessage());
        }
    }

    static void process() throws ProcessingException {
        throw new ProcessingException();
    }
}

class ProcessingException extends Exception {

    public ProcessingException() {
        super("Falha no processamento");
    }

    public ProcessingException(String message) {
        super(message);
    }
}