## Generics

Exemplos utilizando o sistema de tipos genéricos do Java, abordando
segurança de tipo em tempo de compilação, wildcards e criação de
classes e métodos reutilizáveis para qualquer tipo.

---

### 1. Intro
Comparação entre raw type e tipo genérico, mostrando os riscos do cast
manual e a segurança que generics oferece em tempo de compilação.

- IntroExample

---

### 2. Wildcard
Uso do operador ? para representar tipos desconhecidos, com unbounded,
upper bounded (? extends T) e lower bounded (? super T).

- WildcardExample

---

### 3. Classes Genéricas
Criação de classes com parâmetros de tipo, bounded type parameters e
múltiplos parâmetros de tipo.

- GenericClassExample -> Box -> MinBox -> Pair
- RentalExample -> Car -> Boat -> RentalService

---

### 4. Métodos Genéricos
Métodos com parâmetros de tipo próprios, independentes da classe,
com inferência de tipo pelo compilador.

- GenericMethodExample

---