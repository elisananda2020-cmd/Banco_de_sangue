# 🩸 Sistema de Gerenciamento de Banco de Sangue

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de **Sistemas para Internet** do **Instituto Federal do Acre (IFAC)**.

## 👥 Integrantes

- Elis Ananda Alves Valente
- Marisol de Sousa Assunção
- Pâmela Bruna da Silva Carioca

Professor: Jonas Pontes

---

# 📖 Sobre o Projeto

O Sistema de Gerenciamento de Banco de Sangue tem como objetivo informatizar o controle de um banco de sangue, permitindo o cadastro de doadores, registro de doações, gerenciamento do estoque de bolsas de sangue e controle das retiradas realizadas.

O projeto foi desenvolvido em **Java**, aplicando os principais conceitos da Programação Orientada a Objetos, como:

- Encapsulamento;
- Herança;
- Polimorfismo;
- Interfaces;
- Coleções (`List` e `Map`);
- Tratamento de exceções;
- Organização em pacotes;
- Simulação de persistência de dados.

---

# 🎯 Objetivos

O sistema permite:

- Cadastro de doadores;
- Consulta de doadores cadastrados;
- Registro de novas doações;
- Controle do estoque por tipo sanguíneo;
- Registro da utilização de bolsas de sangue;
- Consulta do estoque geral;
- Consulta do histórico de doações;
- Emissão de alertas quando determinado tipo sanguíneo atingir estoque crítico.

---

# 📋 Requisitos Funcionais

| Código | Descrição |
|---------|-----------|
| RF01 | Cadastrar doadores |
| RF02 | Registrar novas doações |
| RF03 | Controlar estoque por tipo sanguíneo |
| RF04 | Registrar utilização das bolsas |
| RF05 | Consultar estoque geral |

---

# 🧩 Modelagem

O projeto foi modelado utilizando UML.

### Diagrama de Classes

O diagrama contempla:

- Herança entre Pessoa, Doador e Funcionário;
- Associação entre Doador e Doação;
- Composição entre Doação e BolsaDeSangue;
- Composição entre BancoDeSangue e Estoque;
- Agregação entre BancoDeSangue, Doadores e Doações;
- Realização de interfaces pelo Funcionário.

### Diagrama de Máquina de Estados

Foi desenvolvido um diagrama para representar o ciclo de vida de uma Bolsa de Sangue, desde sua coleta até sua utilização.

---

# 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- UML
- Git
- GitHub

---

# 📂 Persistência dos Dados

O sistema utiliza persistência **simulada**, armazenando as informações em estruturas de dados da linguagem Java, como:

- List
- Map

Não há utilização de banco de dados nesta versão do projeto.

---

# ⚙️ Como Executar

## Pré-requisitos

- Java JDK 17 ou superior (ou a versão utilizada pelo projeto)
- IDE Java (IntelliJ IDEA, Eclipse, NetBeans ou VS Code)

## Passos

1. Clone o repositório:

```bash
git clone https://github.com/elisananda2020-cmd/Banco_de_sangue
```

2. Abra o projeto em sua IDE.

3. Compile o projeto.

4. Execute a classe:

```
view/Main.java
```

5. Utilize o menu textual para acessar as funcionalidades do sistema.

---

# 📌 Conceitos de POO Aplicados

Durante o desenvolvimento foram utilizados diversos conceitos da Programação Orientada a Objetos, como:

- Classes e Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Interfaces;
- Composição;
- Agregação;
- Associação;
- Tratamento de exceções personalizadas;
- Organização em pacotes;
- Separação entre modelo, controle, persistência e interface.

---


# 📚 Disciplina

Programação Orientada a Objetos

Curso: Sistemas para Internet

Instituto Federal do Acre (IFAC)

Ano: 2026
