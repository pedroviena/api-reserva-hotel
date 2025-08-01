# Sistema de Reserva de Hotel - API REST

![Status do Projeto](https://img.shields.io/badge/status-em--desenvolvimento-yellow)
![Linguagem](https://img.shields.io/badge/Java-17-blue)
![Framework](https://img.shields.io/badge/Spring%20Boot-3.x.x-brightgreen)
![Licença](https://img.shields.io/badge/license-MIT-blue.svg)

Uma API REST completa para um sistema de gestão de reservas de hotel, desenvolvida com Spring Boot. O projeto inclui funcionalidades de cadastro de hóspedes, gerenciamento de reservas, controle de disponibilidade, autenticação segura com JWT e uma suíte de testes de integração robusta.

---

## 📋 Índice

* [Sobre o Projeto](#-sobre-o-projeto)
* [Funcionalidades](#-funcionalidades)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Estrutura do Projeto](#-estrutura-do-projeto)
* [Como Executar](#-como-executar)
* [Endpoints da API](#-endpoints-da-api)
* [Testes](#-testes)
* [Autor](#-autor)
* [Licença](#-licença)

---

## 🚀 Sobre o Projeto

Este projeto foi criado como um portfólio para demonstrar habilidades em desenvolvimento back-end com Java e Spring Boot, seguindo as melhores práticas de arquitetura de software, segurança e qualidade de código através de testes automatizados.

A API permite gerenciar todo o ciclo de vida de uma reserva, desde a consulta de disponibilidade de quartos até o check-out do hóspede.

---

## ✨ Funcionalidades

-   [x] **Autenticação e Autorização**: Sistema seguro com Tokens JWT.
-   [x] **Gestão de Hóspedes**: CRUD completo para cadastro de hóspedes.
-   [ ] **Gestão de Quartos**: CRUD para tipos e numeração de quartos.
-   [ ] **Sistema de Reservas**:
    -   [ ] Criar nova reserva com validação de disponibilidade.
    -   [ ] Consultar reservas (por hóspede, por data).
    -   [ ] Cancelar uma reserva.
-   [ ] **Controle de Disponibilidade**: Endpoint para verificar quais quartos estão livres em um determinado período.
-   [ ] **Check-in / Check-out**: Atualização do status da reserva.
-   [ ] **Relatórios**: Geração de relatórios básicos de ocupação.

---

## 🛠️ Tecnologias Utilizadas

As seguintes ferramentas e tecnologias foram utilizadas na construção do projeto:

* **Backend**:
    * [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
    * [Spring Boot 3](https://spring.io/projects/spring-boot)
    * [Spring Web](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
    * [Spring Security](https://spring.io/projects/spring-security)
    * [Hibernate](https://hibernate.org/)
* **Banco de Dados**:
    * [PostgreSQL](https://www.postgresql.org/) (Produção/Desenvolvimento)
    * [H2 Database](https://www.h2database.com/html/main.html) (Testes)
* **Segurança**:
    * [JSON Web Tokens (JWT)](https://jwt.io/)
* **Testes**:
    * [JUnit 5](https://junit.org/junit5/)
    * [Mockito](https://site.mockito.org/)
    * [MockMvc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html)
* **Build & Dependências**:
    * [Maven](https://maven.apache.org/)
    * [Lombok](https://projectlombok.org/)

---

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura em camadas para garantir a separação de responsabilidades e a manutenibilidade do código.

```
/src/main/java/br/com/hotel/reservasapi/
├── controller/  # Camada de API REST (Endpoints)
├── service/     # Camada de Lógica de Negócio
├── repository/  # Camada de Acesso a Dados (Spring Data JPA)
├── model/       # Camada de Entidades (JPA) e DTOs
├── security/    # Configurações de segurança e JWT
└── config/      # Classes de configuração geral
/src/test/java/  # Testes de unidade e integração
```

---

## ▶️ Como Executar

Siga os passos abaixo para executar o projeto localmente.

### Pré-requisitos

* Java 17 ou superior
* Maven 3.8 ou superior
* Git
* PostgreSQL instalado e rodando

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/api-reserva-hotel.git](https://github.com/seu-usuario/api-reserva-hotel.git)
    cd api-reserva-hotel
    ```

2.  **Configure o banco de dados:**
    * Abra o arquivo `src/main/resources/application.properties`.
    * Altere as propriedades `spring.datasource.username` e `spring.datasource.password` com as suas credenciais do PostgreSQL.
    * Crie um banco de dados no PostgreSQL com o nome que você definir em `spring.datasource.url`.

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

---

## Endpoints da API

A documentação completa dos endpoints pode ser encontrada via Swagger/OpenAPI (após implementação) em `/swagger-ui.html`. Abaixo estão alguns exemplos principais:

| Método | Endpoint                | Protegido | Descrição                        |
| :----- | :---------------------- | :-------- | :--------------------------------- |
| `POST` | `/api/auth/login`       | Não       | Autentica um usuário e retorna um token JWT. |
| `POST` | `/api/hospedes`         | Sim       | Cria um novo hóspede.              |
| `GET`  | `/api/hospedes/{id}`    | Sim       | Busca um hóspede pelo seu ID.      |
| `POST` | `/api/reservas`         | Sim       | Cria uma nova reserva.             |
| `GET`  | `/api/quartos/disponiveis` | Não       | Lista quartos disponíveis por data.|

---

## ✅ Testes

O projeto possui um foco em qualidade, com testes de integração que cobrem os principais fluxos da aplicação.

Para rodar todos os testes automatizados, execute o comando:
```bash
mvn test
```

Os testes cobrem cenários como:
* Conflitos de reserva (tentativa de reservar quarto já ocupado).
* Validação de dados de entrada (datas inválidas, emails, etc.).
* Controle de acesso baseado em autenticação.

---

## 👨‍💻 Autor

Desenvolvido por **Pedro Viena**.

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pedro-arian-viena)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/pedroviena)

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
