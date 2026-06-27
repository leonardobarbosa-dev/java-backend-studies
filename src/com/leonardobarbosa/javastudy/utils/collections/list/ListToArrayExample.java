package com.leonardobarbosa.javastudy.utils.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrayExample {
    public static void main(String[] args) {

        // List to Array
        List<String> names = new ArrayList<>(List.of("Amanda", "Bruno", "Carlos", "João"));

        String[] namesToArray = names.toArray(new String[0]); // [0] -> tamanho ajustado automaticamente
        System.out.println(Arrays.toString(namesToArray));

        System.out.println("----------------------------");

        // Array to List (forma errada)
        String[] personNames = {"Alceu", "Ash", "Jubileu"};

        List<String> personNamesToArray = Arrays.asList(personNames);   // view de tamanho fixo -> continua ligado ao array original

        try {
            personNamesToArray.add(0, "Vegeta");
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao adicionar -> " + e.getMessage());
        }

        personNamesToArray.set(0, "Vegeta");    // os dois são alterados (não é possível alterar o tamanho)

        System.out.println(Arrays.toString(personNames));
        System.out.println(personNamesToArray);

        System.out.println("----------------------------");

        // Array to List (forma correta)
        String[] namesArray = {"Alceu", "Ash", "Jubileu"};

        List<String> namesArrayToList = new ArrayList<>(Arrays.asList(namesArray));

        namesArrayToList.add("Vegeta");
        System.out.println(namesArrayToList);
    }
}
