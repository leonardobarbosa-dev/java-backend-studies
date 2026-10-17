package com.leonardobarbosa.javastudy.oop.methods.overloading.domain;

public class MethodOverloading {

    /*
    Metodos sobrecarregados usam o mesmo nome,
    mas parâmetros diferentes (quantidade, tipo ou ordem).
     */

    private String name;
    private String genre;
    private int seasons;
    private int episodes;

    public void init(String name, String genre, int seasons) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }

    public void init(String name, String genre, int seasons, int episodes) {
        this.init(name, genre, seasons);    // Reutilização do metodo anterior para evitar repetição de código
        this.episodes = episodes;
    }

    public void print() {
        System.out.printf("\nAnime: %s | Gênero: %s | Temporadas: %d",
                this.name,
                this.genre,
                this.seasons);
        if (episodes > 0) {
            System.out.printf(" | Episódios: %d\n", this.episodes);
        } else {
            System.out.println();
        }
    }
}
