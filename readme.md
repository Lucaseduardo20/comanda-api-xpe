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

Cliente (1)───(N) Command (1)───(N) CommandItem (N)───(1) Produto