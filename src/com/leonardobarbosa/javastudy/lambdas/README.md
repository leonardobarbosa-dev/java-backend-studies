## Lambdas

Exemplos das principais interfaces funcionais do Java, abordando
parametrização de comportamento e o uso de Predicate, Consumer e Function.

---

### 1. Parametrizando Comportamentos
Demonstra o problema de duplicação de código com múltiplos métodos
de filtro e como parametrizar o comportamento resolve com um único método.
- BehaviorParameterizationExample -> Car

---

### 2. Predicate
Interface funcional que recebe T e retorna boolean. Usada para
testar e filtrar elementos, com suporte a composição via and, or e negate.
- PredicateExample -> Car

---

### 3. Consumer
Interface funcional que recebe T e não retorna nada. Usada para
executar ações com efeito colateral, com suporte a encadeamento via andThen.
- ConsumerExample -> Car

---

### 4. Function
Interface funcional que recebe T e retorna R. Usada para transformar
e converter elementos, com suporte a composição via andThen e compose.
- FunctionExample -> Car

---