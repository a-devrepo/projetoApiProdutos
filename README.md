# API de Controle de Produtos

Projeto simples para cadastro e consulta de produtos, construído com **Spring Boot** e **Java 21**.

---

## Tecnologias e Ferramentas

- Java 21  
- Spring Boot  
- Maven  
- Spring Data JPA  
- PostgreSQL (Docker)  
- Jakarta Validation  
- Swagger (OpenAPI)  
- Docker & Docker Compose  

---

## Estrutura do Projeto

Organizado em camadas para facilitar manutenção e evolução:

- **configurations**: Configurações da aplicação (CORS, Swagger, ModelMapper, etc.)  
- **controllers**: Endpoints REST para produtos  
- **dtos**: Objetos de transferência de dados (request e response)  
- **entities**: Entidades do banco de dados  
- **handlers**: Tratamento global de exceções  
- **repositories**: Interfaces para acesso a dados  
- **services**: Lógica de negócio  

---

## Endpoints da API

| Método | Endpoint           | Descrição           | Request                                   | Response                                    |
|--------|--------------------|---------------------|-------------------------------------------|---------------------------------------------|
| POST   | `/api/v1/produtos` | Cadastrar produto   | nome (String), preco (Double), quantidade (Integer) — todos obrigatórios | id (UUID), nome, preco, quantidade, dataHoraCriacao (LocalDateTime) |
| GET    | `/api/v1/produtos` | Listar produtos     | —                                         | Lista de produtos com campos acima          |

---

## Banco de Dados

Usa PostgreSQL em container Docker configurado no `docker-compose.yml`.

---

## Documentação da API

Acesse a documentação Swagger em:  
`http://localhost:8081/swagger-ui/index.html`

---

## Como executar o projeto

Você pode rodar a aplicação de duas formas:

---

### 1. Executar localmente (sem Docker)

Roda a aplicação direto no seu computador usando Maven.

**Passos:**

- Abra o terminal na pasta do projeto.
- Execute o comando:

```bash
./mvnw spring-boot:run
```

### 2. Executar via Docker

Roda a aplicação direto no seu computador usando Maven.

**Passos:**

 - Certifique-se que o Docker está instalado e rodando.
 - Na pasta do projeto, onde está o arquivo docker-compose.yml, execute:

```bash
docker-compose up -d
```