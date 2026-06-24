# Utils

Módulo focado em classes utilitárias, manipulação de dados
e APIs importantes da biblioteca padrão do Java.

Os exemplos deste pacote foram criados para praticar recursos bastante utilizados
no dia a dia do desenvolvimento, incluindo manipulação de Strings, datas,
expressões regulares, internacionalização e APIs utilitárias da linguagem.

Além dos exemplos vistos durante os estudos, alguns conteúdos também foram expandidos
com testes e implementações adicionais utilizadas para revisão e prática.

---

## Tópicos Estudados

### 1. Strings

Exemplos relacionados à manipulação e operações utilizando Strings.

- StringBasicsExample
- StringMethodsExample
- StringBuilderExample
- StringFormattingExample
- StringConversionExample
- StringComparisonExample

---

### 2. Wrappers

Exemplos utilizando wrapper classes, autoboxing, unboxing e métodos utilitários.

- WrapperBasicsExample
- WrapperComparisonExample
- WrapperMethodsExample
- WrapperCachingExample
- NullHandlingExample

---

### 3. Dates

Exemplos utilizando APIs de data e hora, incluindo a API legada
e a API moderna introduzida no Java 8.

- legacy/
   - LegacyDateExample
   - LegacyCalendarExample
- localdate/
   - LocalDateBasicExample
   - LocalDateAdvancedExample
- localtime/
   - LocalTimeExample
- datetime/
   - LocalDateTimeExample
- zoned/
   - ZonedDateTimeBasicExample
   - OffsetVsZoneExample
- instant/
   - InstantExample
- formatting/
   - DateFormattingExample
- operations/
   - AgeCalculationExample
   - BusinessDaysExample
   - DateRangeExample
- bridge/
   - LegacyToNewApiExample
---

### 4. ResourceBundle

Exemplos relacionados à internacionalização e externalização de mensagens
utilizando arquivos `.properties`.

- message bundles (.properties)
- ResourceBundleExample

---

### 5. Regular Expressions (Regex)

Exemplos utilizando expressões regulares para validação,
busca e manipulação de textos.

- RegexBasicsExample
- PatternMatcherExample
- RegexAdvancedExample
- RegexWithScannerExample

---

### 6. IO (Input/Output)

Exemplos utilizando a API clássica `java.io` para
criação de arquivos e diretórios, leitura, escrita
e uso de buffers para otimização de I/O.

- FileExample
- FileWriterExample
- FileReaderExample
- BufferedWriterExample
- BufferedReaderExample
- FileForDirectoryExample

---

### 7. NIO (New Input/Output)

Exemplos utilizando a API moderna `java.nio` para
manipulação de arquivos, diretórios, caminhos,
atributos e operações avançadas no sistema de arquivos.

- PathFilesExample
- PathManipulationExample
- FileAttributesExample
- DirectoryStreamExample
- SimpleFileVisitorExample
- PathMatcherExample
- PathMatcherExercise
- ZipOutputStreamExample

---

### 8. Serialization

Exemplos utilizando a API de serialização do Java para
converter objetos em bytes e reconstruí-los a partir de um arquivo.

- StudentClass -> Student
- SerializationExample

---

### 9. Collections

Exemplos utilizando o Collections Framework do Java, abordando o contrato
equals/hashCode, complexidade de algoritmos (Big-O), e as principais
implementações de List, Set, Map e Queue.

- contract/
  - EqualsExample -> Product
  - HashCodeExample


---

## Objetivo do Módulo

Este módulo foi desenvolvido para consolidar o uso das principais
classes utilitárias e APIs da linguagem Java, com foco em recursos
comuns no desenvolvimento e em situações práticas do dia a dia.