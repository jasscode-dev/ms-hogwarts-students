# 🧙‍♂️ Hogwarts Students Service

Microservice responsável pelo cadastro de estudantes e pelo envio de seus dados ao **Sorting Hat Service** por meio do **RabbitMQ**. Faz parte do ecossistema de serviços da Hogwarts School.

---

## 🚀 Funcionalidades

* Cadastro de estudantes
* Validação de dados com Bean Validation (Jakarta)
* Persistência em banco de dados via Spring Data JPA
* Envio do estudante cadastrado para a fila do RabbitMQ
* Integração com o Sorting Hat Service

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Web**
* **Spring Validation**
* **Spring Data JPA**
* **PostgreSQL**
* **RabbitMQ**
* **Maven**

---

## 📦 Arquitetura do Serviço

```
Client → Students API → PostgreSQL
                      → RabbitMQ → Sorting Hat Service
```

---

## 📌 Endpoints

### **POST /students**

Cadastra um estudante e envia a mensagem ao RabbitMQ.

#### **Request Body**

```json
{
  "name": "Harry Potter",
  "email": "harry@hogwarts.com",
  "answers": ["A", "B", "C"]
}
```

#### **Response (201 CREATED)**

```json
{
  "id": "uuid",
  "name": "Harry Potter",
  "email": "harry@hogwarts.com",
  "answers": ["A", "B", "C"]
}
```

---

## 🐇 Fluxo RabbitMQ

1. O estudante é salvo no banco
2. O serviço envia uma mensagem para a fila:

   ```
   hogwarts.students
   ```
3. O Sorting Hat Service consome essa mensagem e determina a casa do aluno.

---

## 📝 Licença

Este projeto está sob a licença MIT.
