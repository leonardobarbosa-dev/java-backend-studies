package com.leonardobarbosa.javastudy.threads.synchronization;

import java.util.ArrayList;
import java.util.List;

class NameList {

    /*
    Classe não thread-safe -> ArrayList não foi feito para uso concorrente
    - duas threads chamando add() ao mesmo tempo podem corromper
      a estrutura interna do array
    - resultado é imprevisível: elementos perdidos (size menor que o
      esperado) ou ArrayIndexOutOfBoundsException, dependendo do
      momento exato em que as threads colidem durante o redimensionamento
    - já observado em execução real: ArrayIndexOutOfBoundsException
      lançada dentro de ArrayList.add(), derrubando a thread no meio do loop
     */

    private final List<String> names = new ArrayList<>();

    public void add(String name) {
        names.add(name);
    }

    public int size() {
        System.out.print("Tamanho do array não sincronizado -> ");
        return names.size();
    }
}

class SynchronizedNameList {

    /*
    Classe thread-safe -> synchronized garante que só uma thread
    por vez execute add(), evitando acesso concorrente à lista
     */

    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized int size() {
        System.out.print("Tamanho do array sincronizado -> ");
        return names.size();
    }
}

public class ThreadSafeExample {
    public static void main(String[] args) throws InterruptedException {

        // duas threads adicionando "Leon" 50_000 vezes cada -> esperado: 100_000

        NameList nameList = new NameList();
        Runnable addNameList = () -> {
            for (int i = 0; i < 50000; i++) {
                nameList.add("Leon");
            }
        };

        Thread t1 = new Thread(addNameList);
        Thread t2 = new Thread(addNameList);

        t1.start();
        t2.start();
        t1.join();  // garante que a main só continue depois que as threads terminarem (evita leitura prematura do size())
        t2.join();

        System.out.println("NameList (não thread-safe), size -> " + nameList.size() + " Esperado -> 100000");

        SynchronizedNameList synchronizedNameList = new SynchronizedNameList();
        Runnable addSynchronizedNameList = () -> {
            for (int i = 0; i < 50000; i++) {
                synchronizedNameList.add("Leon");
            }
        };

        Thread t3 = new Thread(addSynchronizedNameList);
        Thread t4 = new Thread(addSynchronizedNameList);

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("SynchronizedNameList (thread-safe), size -> " + synchronizedNameList.size() + " Esperado -> 100000");
    }
}
