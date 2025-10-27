# 🧾 ComandaAPI - Sistema de Gerenciamento de Comandas

**Autor:** Lucas Eduardo  
**Linguagem:** Java 21  
**Framework:** Spring Boot 3.5.7  
**Banco de Dados:** H2 (ou PostgreSQL via Docker)  
**Gerenciador de dependências:** Maven  

---

## 🧠 Visão Geral

O **ComandaAPI** é uma aplicação RESTful desenvolvida com **Java + Spring Boot**, projetada para gerenciar **clientes, produtos e comandas** de um estabelecimento (como barbearia, restaurante ou salão).

A aplicação foi construída seguindo boas práticas de **arquitetura em camadas (MVC)**, com um domínio rico e escalável para futuras integrações com front-end web ou mobile.

---

## 🧱 Objetivos Principais

- 📋 Cadastrar clientes e produtos  
- 🧾 Criar comandas associadas a um cliente  
- ➕ Adicionar múltiplos produtos a uma comanda  
- 🔎 Buscar, editar e excluir comandas  
- 💾 Persistir os dados em H2 (modo arquivo) ou PostgreSQL (via Docker)

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|-------------|------------|
| **Java 21** | Linguagem base |
| **Spring Boot 3.5.7** | Framework principal |
| **Spring Data JPA** | ORM e persistência de dados |
| **H2 Database** | Banco leve embutido (padrão) |
| **PostgreSQL (opcional)** | Banco real via Docker |
| **Maven** | Build e dependências |

---

## 🧩 Estrutura do Projeto

src/
└── main/
├── java/com/lucas/comanda/
│ ├── controller/ → Controladores REST (API)
│ ├── dto/ → Classes auxiliares de requisição
│ ├── model/ → Entidades JPA
│ ├── repository/ → Interfaces JPA
│ └── service/ → Lógica de negócio
└── resources/
└── application.properties


---

## 🗃️ Modelo Entidade-Relacionamento (MER)

Client (1)───(N) Command (1)───(N) CommandItem (N)───(1) Product


- Um **cliente** pode ter várias **comandas**  
- Cada **comanda** possui vários **itens**  
- Cada **item** está associado a um **produto**

---

## 🧭 UML Simplificado (Diagrama de Classes)


- Um **cliente** pode ter várias **comandas**  
- Cada **comanda** possui vários **itens**  
- Cada **item** está associado a um **produto**

---

## 🧭 UML Simplificado (Diagrama de Classes)

┌────────────────────┐
│ Client │
├────────────────────┤
│ - id: Long │
│ - nome: String │
│ - email: String │
└────────────────────┘
│
│ 1..N
▼
┌────────────────────┐
│ Command │
├────────────────────┤
│ - id: Long │
│ - client: Client │
│ - itens: List<CommandItem> │
│ - dataCriacao: LocalDateTime │
└────────────────────┘
│
│ 1..N
▼
┌────────────────────┐
│ CommandItem │
├────────────────────┤
│ - id: Long │
│ - product: Product │
│ - amount: Integer │
└────────────────────┘
▲
│ N..1
│
┌────────────────────┐
│ Product │
├────────────────────┤
│ - id: Long │
│ - nome: String │
│ - preco: Double │
└────────────────────┘


---

## 🧩 Entidades Principais

### 🧍 Cliente (`Client`)
| Campo | Tipo | Descrição |
|--------|------|------------|
| id | Long | Identificador |
| nome | String | Nome do cliente |
| email | String | E-mail do cliente |

---

### 🧾 Comanda (`Command`)
| Campo | Tipo | Descrição |
|--------|------|------------|
| id | Long | Identificador |
| client | Client | Cliente vinculado |
| itens | List<CommandItem> | Itens da comanda |
| dataCriacao | LocalDateTime | Data/hora de criação |

---

### 📦 Produto (`Product`)
| Campo | Tipo | Descrição |
|--------|------|------------|
| id | Long | Identificador |
| nome | String | Nome do produto |
| preco | Double | Valor unitário |

---

### 🧮 Item da Comanda (`CommandItem`)
| Campo | Tipo | Descrição |
|--------|------|------------|
| id | Long | Identificador |
| command | Command | Comanda associada |
| product | Product | Produto vinculado |
| amount | Integer | Quantidade solicitada |

---

## 🌐 Endpoints REST

### 🧍 Clientes
| Método | Endpoint | Descrição |
|----------|-----------|-------------|
| `GET` | `/clients` | Lista todos os clientes |
| `GET` | `/clients/find/{id}` | Busca cliente por ID |
| `GET` | `/clients/name/{name}` | Busca cliente por nome |
| `GET` | `/clients/count` | Retorna total de clientes |
| `POST` | `/clients` | Cria um novo cliente |
| `DELETE` | `/clients/{id}` | Exclui um cliente |

---

### 📦 Produtos *(para uso futuro)*
| Método | Endpoint | Descrição |
|----------|-----------|-------------|
| `GET` | `/products` | Lista todos os produtos |
| `POST` | `/products` | Cadastra novo produto |

---

### 🧾 Comandas
| Método | Endpoint | Descrição |
|----------|-----------|-------------|
| `POST` | `/commands?clientId={id}` | Cria uma nova comanda |
| `GET` | `/commands` | Lista todas as comandas |
| `GET` | `/commands/{id}` | Busca comanda por ID |
| `PUT` | `/commands/{id}` | Atualiza os itens da comanda |
| `DELETE` | `/commands/{id}` | Exclui uma comanda |

### 🧪 Como Executar o Projeto
### 🔧 Pré-requisitos

Java 21 instalado

Maven configurado (mvn -v deve funcionar)

▶️ Comandos
mvn clean spring-boot:run


Acesse:

API: http://localhost:8081

H2 Console: http://localhost:8081/h2-console

JDBC URL: jdbc:h2:file:./data/comanda_db
Usuário: sa
Senha: (vazio)

### 🗄️ Banco de Dados

Por padrão, a aplicação usa H2 em memória, ou seja, os dados somem ao encerrar o app.

Para persistir em arquivo local, edite o application.properties:

spring.datasource.url=jdbc:h2:file:./data/comanda_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

### 🐳 Configuração com Docker (PostgreSQL)

Arquivo docker-compose.yml:

version: '3.8'

services:
  postgres:
    image: postgres:16
    container_name: postgres_comanda
    restart: always
    environment:
      POSTGRES_USER: lucas
      POSTGRES_PASSWORD: 123456
      POSTGRES_DB: comanda_db
    ports:
      - "5432:5432"
    volumes:
      - ./data:/var/lib/postgresql/data


E no application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/comanda_db
spring.datasource.username=lucas
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

### 🔍 Boas Práticas Aplicadas

✅ Arquitetura em camadas (controller → service → repository)

✅ Uso de DTO (ItemRequest) para entrada de dados

✅ Relacionamentos modelados com CascadeType.ALL

✅ Lançamento de exceções claras em caso de entidades inexistentes

✅ Separação de responsabilidades e reuso de código

### 🏁 Conclusão

O ComandaAPI é um projeto de arquitetura sólida e moderna, com uma base escalável para qualquer tipo de aplicação que envolva comandas e pedidos.
A aplicação combina simplicidade, clareza e boas práticas, servindo tanto como MVP quanto como base para sistemas de produção mais robustos.

© 2025 - Lucas Eduardo
Projeto desenvolvido como desafio final da Pós-Graduação em Arquitetura de Software.