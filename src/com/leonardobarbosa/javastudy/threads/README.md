## Threads

Exemplos sobre programação concorrente em Java, abordando criação e
ciclo de vida de threads, controle de execução (prioridade, sleep,
yield, join) e sincronização entre threads (thread safety, deadlock,
wait/notify).

---

### 1. Introdução
As duas formas de criar uma Thread: estendendo Thread e implementando
Runnable, e a diferença entre chamar start() e run() diretamente.
- ThreadIntroExample

---

### 2. Estados das Threads
Os estados do ciclo de vida de uma Thread (NEW, RUNNABLE, TIMED_WAITING,
WAITING, TERMINATED, BLOCKED), consultados via getState().
- ThreadStatesExample

---

### 3. Prioridade e Sleep
Prioridade como sugestão (não garantia) ao escalonador do sistema
operacional, e sleep() para pausar a execução por tempo determinado.
- PrioritySleepExample

---

### 4. Yield e Join
yield() como sugestão de ceder a vez a outras threads, e join() para
esperar uma thread específica terminar, com ou sem timeout.
- YieldJoinExample

---

### 5. Sincronismo de Thread
Classes thread-safe com synchronized, condição de corrida em coleções
concorrentes, deadlock por espera circular de locks, e comunicação
entre threads com wait/notify.
- ThreadSafeExample -> NameList -> SynchronizedNameList
- DeadlockExample
- WaitNotifyExample -> Message

---