package com.leonardobarbosa.javastudy.threads.synchronization;

import javax.swing.*;

class Message {

    /*
    wait()      -> a thread libera o lock e fica esperando até ser notificada
    notify()    -> acorda uma thread que esteja esperando nesse mesmo objeto
    notifyAll() -> acorda todas as threads que estejam esperando

    wait()/notify()/notifyAll() só podem ser chamados dentro de um
    bloco synchronized no mesmo objeto, senão lançam IllegalMonitorStateException

    Exemplo: produtor (sender) e consumidor (receiver) trocando mensagens
    - sender pergunta a mensagem via JOptionPane e chama send()
    - receiver fica em loop chamando receive(), esperando cada nova mensagem
    - ao cancelar a janela (ou enviar vazio), o sender interrompe o receiver
      e os dois loops terminam, encerrando o programa naturalmente
     */

    private String content;
    private boolean available = false;  // controla se há uma mensagem pronta para ser lida

    public synchronized void send(String content) {
        this.content = content;
        this.available = true;
        System.out.println("Enviando -> " + content);
        notify();   // acorda a thread presa em wait() dentro do receive()
    }

    public synchronized String receive() {
        while (!available) {
            /*
            while (não if) -> proteção contra spurious wakeup
            - a thread pode acordar sem ter sido notificada de verdade
            - com while, ela volta a checar a condição e espera de novo se necessário
             */
            try {
                wait();     // libera o lock e pausa até notify() ser notificado
            } catch (InterruptedException e) {
                /*
                interrupt() faz wait() lançar essa exceção -> é assim que o
                sender avisa "não vai ter mais mensagem, pode parar"

                content ainda não foi atribuído aqui (nenhum send() rodou
                antes dessa interrupção), então retornar null é o sinal
                de "não há mensagem, encerre o loop"
                 */
                Thread.currentThread().interrupt(); // restaura a flag de interrupção (boas práticas)
                return null;
            }
        }
        available = false;  // consome a mensagem -> libera o slot pro próximo send()
        return content;
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {

        Message message = new Message();

        /*
        receiver -> fica em loop, chamando receive() repetidamente
        - cada chamada bloqueia (via wait) até uma mensagem chegar
        - se receive() retornar null, é o sinal de encerramento -> break
         */
        Thread receiver = new Thread(() -> {
            while (true) {
                System.out.println("Receiver esperando mensagem...");
                String receive = message.receive();

                if (receive == null) {
                    // precisa checar ANTES de qualquer outra operação em cima do valor,
                    // senão um metodo como isBlank() lançaria NullPointerException
                    System.out.println("Receiver encerrando...");
                    break;
                }

                try {
                    Thread.sleep(2000); // simula processamento da mensagem recebida
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Receiver recebeu -> " + receive);
            }
        });

        /*
        sender -> pergunta uma mensagem por vez via JOptionPane
        - campo vazio ou cancelar -> interrompe o receiver e encerra

        - receiver.interrupt() (não Thread.currentThread()) -> interrompe
          a thread que está travada (receiver), não a própria thread sender
         */
        Thread sender = new Thread(() -> {
            while (true) {
                String string = JOptionPane.showInputDialog("Escreva sua mensagem: ");
                if (string == null || string.isBlank()) {
                    receiver.interrupt();
                    break;
                }
                message.send(string);
            }
        });

        receiver.start();
        sender.start();

        /*
        Sem join() aqui: main() termina rápido, mas a JVM continua rodando
        enquanto receiver e sender (threads não-daemon) estiverem vivas.
        O programa só encerra de verdade quando as duas terminam sozinhas.
         */
    }
}
