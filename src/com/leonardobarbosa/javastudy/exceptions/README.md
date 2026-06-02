# Exceptions

Módulo focado em tratamento de exceções, propagação de erros
e controle de fluxo utilizando exceptions.

Os exemplos deste pacote foram criados para demonstrar situações comuns
do dia a dia, funcionamento do fluxo de exceções e criação de exceções customizadas.

---

## Tópicos Estudados

### 1. Flow

Exemplos mostrando como exceções se propagam pela stack de chamadas (call stack)
e afetam o fluxo de execução da aplicação.

- ExceptionPropagationExample
- CallStackExceptionFlow
- UnhandledExceptionDemo
- HandledExceptionFlow
- FinallyBlockExample
- MultipleCatchFlowExample
- TryWithResourcesExample

---

### 2. Unchecked Exceptions (RuntimeException)

Exemplos relacionados a exceções que ocorrem em tempo de execução
e não precisam ser tratadas obrigatoriamente.

- UncheckedExceptionBasic
- NullPointerExample
- ArithmeticExceptionExample
- IndexOutOfBoundsExample
- UncheckedPropagationDemo

---

### 3. Checked Exceptions

Exemplos utilizando exceções que precisam ser tratadas
ou declaradas utilizando `throws`.

- CheckedExceptionBasic
- IOExceptionExample
- FileNotFoundHandling
- ThrowsKeywordExample

---

### 4. Throwing Exceptions

Exemplos utilizando `throw` e `throws`
para criação e propagação de exceções.

- ThrowKeywordBasic
- IllegalArgumentExample
- CustomValidationThrow
- BusinessRuleValidation
- ThrowVsThrowsExample

---

### 5. Custom Exceptions

Exemplos de criação e utilização de exceções customizadas
para regras específicas da aplicação.

- CustomExceptionBasic
- CustomUncheckedException
- CustomCheckedException
- BusinessExceptionExample
- InvalidUserDataException

---

### 6. Error

Exemplos relacionados a erros graves da JVM
que normalmente não devem ser tratados pela aplicação.

Errors representam falhas internas graves da JVM
ou do ambiente de execução.

- StackOverflowErrorExample
- OutOfMemoryErrorExample

---

## Objetivo do Módulo

Este módulo foi desenvolvido para consolidar os principais conceitos
relacionados ao tratamento de exceções em Java, incluindo propagação,
tratamento, criação de exceções customizadas e entendimento do fluxo de execução.