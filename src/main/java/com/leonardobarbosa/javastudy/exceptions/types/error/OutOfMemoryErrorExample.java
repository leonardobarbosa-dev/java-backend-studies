package com.leonardobarbosa.javastudy.exceptions.types.error;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorExample {
    public static void main(String[] args) {

        /*
        OutOfMemoryError ocorre quando a JVM não consegue
        alocar mais memória para novos objetos

        Neste exemplo, novos arrays são criados continuamente
        e armazenados na lista, impedindo que o Garbage Collector
        libere mais memória

        Quando a memória disponível se esgota,
        a JVM lança OutOfMemoryError.

        -> Assim como outros Errors, normalmente não é uma
        situação da qual a aplicação consegue recuperar
         */


        List<int[]> list = new ArrayList<>();

        while(true) {
            list.add(new int[1000000]);
        }

        /*
        Error x Exception

        Exception
        - representa situações que podem ser tratadas
        - faz parte do fluxo normal de tratamento de erros

        Error
        - representa falhas graves na JVM
        - normalmente não deve ser tratado
        - geralmente indica problemas de infraestrutura,
        memória ou execução

        Exemplos:
        - StackOverFlowError
            a pilha de chamadas (Call Stack) atingiu seu limite,
            geralmente causado por recursão infinita.

        - OutOfMemoryError
            a JVM não possui memória suficiente para alocar novos objetos

        - VirtualMachineError (StackOverFlowError e OutOfMemoryError são subclasses de VirtualMachineError)
            classe base para erros graves da JVM, indicando
            falhas internas ou falta crítica de recurso

            - NoClassDefFoundError
            a JVM encontrou uma classe durante a compilação,
            mas não conseguiu localizá-la em tempo de execução
         */
    }
}
