## Classes Internas

Exemplos dos quatro tipos de classes internas do Java, mostrando
como cada uma acessa membros da classe externa e como são instanciadas.

---

### 1. Intro
Classe interna de instância: definida dentro da classe externa,
acessa membros private e precisa de uma instância da classe externa
para ser instanciada.
- InnerClassIntroExample

---

### 2. Classes Locais
Classe definida dentro de um método, existe apenas no escopo desse
método e só acessa variáveis locais que sejam effectively final.
- LocalClassExample

---

### 3. Classes Anônimas
Implementa uma interface ou estende uma classe diretamente no ponto
de uso, sem nome e sem arquivo .java separado. Predecessor das lambdas.
- AnonymousClassExample -> Greeting

---

### 4. Classes Aninhadas Estáticas
Declarada com static, não acessa membros de instância da classe externa
e não precisa de uma instância dela para ser instanciada.
- StaticNestedClassExample

---