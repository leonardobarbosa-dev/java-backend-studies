package com.leonardobarbosa.javastudy.oop.interfaces.domain;

public interface DataLoader {

    /*
    Todos os atributos de uma interface são implicitamente:
    public static final -> constantes

    - pertencem a classe
    - são compartilhados
    - não podem ser alterados
     */
    int MAX_DATA_SIZE = 10;


    /*
    Por padrão, todos os métodos da interface são:
    public abstract
     */
    void load();


    /*
    Metodos default possuem implementação.

    A classe pode:
    - usar a implementação padrão
    - sobrescrever o metodo
     */
    default void checkPermission() {
        System.out.println("Método default dentro da interface");
    }


    /*
    É possivel criar metodos static (publicos por padrão)
    <Nao podem ser sobrescritos>
     */
    static void retrieveMaxDataSize() {
        System.out.println("\nTamanho máximo dos dados : " + DataLoader.MAX_DATA_SIZE);
    }

}
