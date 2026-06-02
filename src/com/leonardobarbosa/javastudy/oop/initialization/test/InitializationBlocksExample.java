package com.leonardobarbosa.javastudy.oop.initialization.test;

import com.leonardobarbosa.javastudy.oop.initialization.domain.InitializationBlocks;

public class InitializationBlocksExample {
    public static void main(String[] args) {

        InitializationBlocks anime = new InitializationBlocks();    // Bloco estático executado
        anime.printEpisodes();

        InitializationBlocks pokemon = new InitializationBlocks("Pokemon"); // Aqui o bloco estático não é mais executado
        pokemon.printEpisodes();
    }
}
