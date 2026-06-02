package com.leonardobarbosa.javastudy.exceptions.types.error;

public class StackOverflowErrorExample {
    public static void main(String[] args) {

        /*
        Hierarquia simplificada:

         Throwable
           ├── Error        (não tratar) - “Error faz parte da hierarquia, mas não do fluxo de tratamento.”
           └── Exception    (tratar ou propagar)

           Error representa falhas graves da JVM ou do ambiente
           de execução e normalmente não deve ser tratado

           StackOverflowError ocorre quando a pilha de chamadas
           (Call Stack) atinge seu limite
           - uma causa comum é recursão infinita,
           onde um metodo chama a si mesmo sem condição de parada

           -> Diferente das Exceptions, Errors normalmente indicam
           problemas que a aplicação não consegue recuperar
         */


        recursion();
    }

    static void recursion() {
        recursion();
    }
}
