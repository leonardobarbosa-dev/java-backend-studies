## Method Reference

Exemplos dos três tipos de referência a métodos do Java, mostrando
a equivalência com lambdas e quando cada tipo é aplicável.

---

### 1. Referência a Método Estático
Substitui uma lambda que apenas chama um método estático existente.
Sintaxe: ClassName::staticMethod
- StaticMethodReferenceExample

---

### 2. Referência a Método de Instância
Dois tipos: bound (objeto fixo conhecido) e unbound (objeto vem do fluxo).
Sintaxe: object::method ou ClassName::method
- InstanceMethodReferenceExample -> Car

---

### 3. Referência a Construtor
Substitui uma lambda que apenas instancia um objeto.
Sintaxe: ClassName::new
- ConstructorReferenceExample -> Car

---