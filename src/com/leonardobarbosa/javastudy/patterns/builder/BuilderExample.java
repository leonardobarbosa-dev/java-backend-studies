package com.leonardobarbosa.javastudy.patterns.builder;

class Car {

    private final String model;
    private final String color;
    private final int year;
    private final boolean automatic;    // opcional
    private final int doors;    // opcional

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.automatic = builder.automatic;
        this.doors = builder.doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", automatic=" + automatic +
                ", doors=" + doors +
                '}';
    }

    static class Builder {

        private String model;
        private String color;
        private int year;
        private boolean automatic = true;  // valor padrão
        private int doors = 4;  // valor padrão

        public Builder model(String model) {
            this.model = model;
            return this;    // retorna o próprio Builder -> permite encadear chamadas
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder automatic(boolean automatic) {
            this.automatic = automatic;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Car build() {
            if (model == null || model.isBlank()) {
                throw new IllegalStateException("O modelo é obrigatório");
            }

            if (color == null || color.isBlank()) {
                throw new IllegalStateException("A cor é obrigatória");
            }

            if (year <= 0) {
                throw new IllegalStateException("O ano deve ser positivo");
            }

            return new Car(this);
        }
    }
}

public class BuilderExample {

    /*
    Builder -> padrão de projeto que permite construir objetos passo a passo,
    evitando construtores com muitos parâmetros.

    - Métodos nomeados deixam a construção mais legível.
    - Campos opcionais podem ser omitidos e usar valores padrão.
    - build() cria o objeto com os valores configurados.
     */
    
    public static void main(String[] args) {

        // todos os campos informados
        Car civic = new Car.Builder()
                .model("Civic")
                .color("Blue")
                .year(2014)
                .automatic(false)
                .doors(2)
                .build();

        System.out.println(civic);

        // campos opcionais omitidos -> usam o valor padrão do Builder
        Car passat = new Car.Builder()
                .model("Passat")
                .color("Black")
                .year(2018)
                .build();

        System.out.println(passat);
    }
}
