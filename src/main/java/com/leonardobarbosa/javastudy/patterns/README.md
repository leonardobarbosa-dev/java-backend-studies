# Patterns

Exemplos de padrões de projeto em Java, abordando a construção de objetos,
a criação de instâncias e o transporte de dados entre diferentes partes de
uma aplicação.

---

### 1. Builder

Padrão de projeto que permite construir objetos passo a passo, 
tornando a criação mais legível e facilitando o uso de parâmetros opcionais.
- BuilderExample -> Car

---

### 2. Factory

Padrão de projeto que centraliza a criação de objetos e 
escolhe qual implementação instanciar com base no tipo solicitado.
- FactoryExample
- Notification -> EmailNotification, SMSNotification, NotificationFactory
- NotificationType

---

### 3. Singleton

Padrão de projeto que controla a criação de uma única 
instância compartilhada, oferecendo um ponto de acesso a ela.

**Eager Initialization**
- EagerSingleton
- EagerSingletonExample

**Lazy Initialization**
- LazySingleton
- LazySingletonExample

**Enum**
- Singleton
- EnumSingletonExample

---

### 4. Data Transfer Object (DTO)

Objeto utilizado para agrupar e transportar dados entre 
diferentes partes de uma aplicação, permitindo reunir informações 
provenientes de diferentes objetos.
- User
- Address
- UserDto
- UserDtoMapper
- DataTransferObjectExample