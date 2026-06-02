package com.leonardobarbosa.javastudy.oop.constructors.domain;

public class Constructor {

    private String name;
    private String genre;
    private int seasons;
    private int episodes;

    /*
    Construtor: <public> -> <nome da classe>
    - construtores podem ser vazios ou receberem parâmetros
    - podem ser sobrecarregados (vários construtores com parâmetros diferentes)
     */

    public Constructor(String name) {
        this.name = name;
    }

    public Constructor(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Constructor(String name, String genre, int seasons) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }

    public Constructor(String name, String genre, int seasons, int episodes) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
        this.episodes = episodes;
    }


    public void print() {
        System.out.printf("\nAnime: %s | Gênero: %s | Temporadas: %d | Episódios: %d\n",
                this.name,
                this.genre,
                this.seasons,
                this.episodes);
    }


}
