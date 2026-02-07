# desafio-backend-transacao

Esta é uma API REST robusta para gerenciamento de transações financeiras, desenvolvida com foco em escalabilidade, segurança e integridade de dados (ACID).

## 🚀 Sobre o Projeto

O sistema permite a criação de contas, processamento de pagamentos e transferências entre usuários, garantindo que as operações sejam atômicas — ou seja, se uma parte da transação falhar, o saldo não é alterado indevidamente.

### Principais Funcionalidades
* **Processamento de Transações:** Transferências entre carteiras com rollback automático.
* **Validações:** Verificação de saldo suficiente e autorização de serviços externos.
* **Notificações:** Simulação de envio de comprovantes pós-transação.

---

## 🛠 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3** (Data JPA, Hibernate, Web)
* **MySQL** (Banco de dados relacional)

---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos
* JDK 17 e Maven.
