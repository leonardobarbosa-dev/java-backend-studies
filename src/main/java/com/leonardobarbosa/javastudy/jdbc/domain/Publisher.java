package com.leonardobarbosa.javastudy.jdbc.domain;

import java.util.Objects;

public class Publisher {

    private final Integer id;
    private final String name;

    public Publisher(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private Integer id;
        private String name;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Publisher build() {

            if (name == null || name.isBlank()) {
                throw new IllegalStateException("nome é obrigatório");
            }

            return new Publisher(this);
        }
    }
}
