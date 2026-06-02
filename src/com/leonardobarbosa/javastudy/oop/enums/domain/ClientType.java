package com.leonardobarbosa.javastudy.oop.enums.domain;

public enum ClientType {

    /*
    Enum é um tipo especial usado para representar
    um conjunto fixo de constantes.

   - Enums ajudam a evitar valores inválidos
   e deixam o código mais organizado e legível

   - Cada constante do enum representa um objeto único
     */

    NATURAL_PERSON(1, "Pessoa Física"),
    LEGAL_ENTITY(2, "Pessoa Jurídica");

    /*
    Cada constante pode possuir valores próprios
    através do construtor do enum.
     */

    private final int id;
    private final String clientDescription;

    /*
    Construtores são implicitamente private.
    Não é possível criar enums usando new.
     */

    ClientType(int id, String clientDescription) {
        this.id = id;
        this.clientDescription = clientDescription;
    }

    /*
    Metodo de busca que converte
    um código (int) para o enum correspondente.

    - values() retorna todas as constantes do enum
    em formato de array.
     */
    public static ClientType findByCode(int id) {
        for (ClientType clientType : values()) {
            if (clientType.getId() == (id)) {
                return clientType;
            }
        }
        return null;
    }


    // GET
    public int getId() {
        return id;
    }

    public String getClientDescription() {
        return clientDescription;
    }
}
