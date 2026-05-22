# 🤖 Projeto Automanager (Autobots)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![FATEC SJC](https://img.shields.io/badge/FATEC-SJC-red?style=for-the-badge)](#)

Repositório destinado à **ATV3** da disciplina de **Desenvolvimento Web III**, do curso de Desenvolvimento de Software Multiplataforma (DSM) da **FATEC São José dos Campos**. 

O projeto consiste em uma API RESTful desenvolvida com Spring Boot para o gerenciamento de uma loja de manutenção veicular e venda de autopeças. O sistema permite o controle de empresas, usuários (clientes, funcionários, fornecedores), veículos, estoques de mercadorias, serviços prestados e emissão de ordens de serviço (vendas).

---

## 🚀 Como Executar

### Pré-requisitos

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalado em sua máquina.
- Git para clonar o repositório.

### Passo a Passo

1. Clone o repositório:

```bash
git clone https://github.com/lais-zanardi/atv3-dwIII.git
```

2. Acesse a pasta raiz da aplicação:

```bash
cd atv3-dwIII/automanager
```

3. Instale as dependências e execute a aplicação (o Maven baixará tudo automaticamente):

**No Windows:**
```cmd
mvnw.cmd spring-boot:run
```

**No Linux/Mac:**
```bash
./mvnw spring-boot:run
```

4. A aplicação estará rodando localmente. Você pode acessar os endpoints (ex: usuarios) através da URL base:
```
http://localhost:8080/
```
