# 🩸 Sistema de Gerenciamento de Banco de Sangue

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de **Sistemas para Internet** do **Instituto Federal do Acre (IFAC)**.

## 👥 Integrantes

- Elis Ananda Alves Valente
- Marisol de Sousa Assunção
- Pâmela Bruna da Silva Carioca

**Professor:** Jonas Pontes

---

# 📖 Sobre o projeto

O Sistema de Gerenciamento de Banco de Sangue foi desenvolvido com o objetivo de automatizar o controle de doadores, doações e estoque de bolsas de sangue, utilizando os conceitos de Programação Orientada a Objetos em Java.

O sistema simula o funcionamento de um banco de sangue, permitindo o cadastro de doadores, o registro de doações, o controle do estoque por tipo sanguíneo e a consulta das informações armazenadas.

---

# 🎯 Objetivos

- Cadastrar doadores;
- Registrar doações de sangue;
- Controlar o estoque de bolsas por tipo sanguíneo;
- Registrar a utilização das bolsas de sangue;
- Consultar o estoque disponível;
- Emitir alertas quando determinado tipo sanguíneo atingir o estoque mínimo.

---

# ⚙️ Funcionalidades

- ✅ Cadastro de doadores;
- ✅ Consulta de doadores;
- ✅ Registro de novas doações;
- ✅ Controle do estoque por tipo sanguíneo;
- ✅ Registro da utilização de bolsas;
- ✅ Consulta do estoque geral;
- ✅ Persistência simulada utilizando coleções (`List` e `Map`);
- ✅ Tratamento de exceções personalizadas.

---

# 🛠️ Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Coleções (`List`, `Map`)
- Git
- GitHub

---

# 📂 Estrutura do projeto

```
src/
│
├── model/
│   ├── Pessoa.java
│   ├── Doador.java
│   ├── Funcionario.java
│   ├── BolsaDeSangue.java
│   ├── Doacao.java
│   └── Estoque.java
│
├── control/
│   ├── DoadorController.java
│   ├── DoacaoController.java
│   └── EstoqueController.java
│
├── persistencia/
│   ├── DoadorRepositorio.java
│   ├── DoacaoRepositorio.java
│   └── EstoqueRepositorio.java
│
├── interfaces/
│   ├── Relatorio.java
│   └── Notificavel.java
│
├── exception/
│   ├── DoadorNaoEncontradoException.java
│   └── EstoqueInsuficienteException.java
│
└── view/
    ├── Menu.java
    └── Main.java
```

---

# 🧩 Conceitos de POO aplicados

O projeto contempla os principais conceitos da Programação Orientada a Objetos:

- Encapsulamento
- Herança
- Polimorfismo
- Interfaces
- Associação
- Agregação
- Composição
- Tratamento de exceções personalizadas
- Organização em pacotes
- Separação entre modelo, controle, persistência e interface

---

# 📋 Requisitos funcionais

| Código | Descrição |
|---------|-----------|
| RF01 | Cadastrar doadores |
| RF02 | Registrar novas doações |
| RF03 | Controlar estoque por tipo sanguíneo |
| RF04 | Registrar utilização das bolsas |
| RF05 | Consultar estoque geral |

---

# ▶️ Como executar

## Pré-requisitos

- Java JDK 17 ou superior
- IDE Java (IntelliJ IDEA, Eclipse, NetBeans ou VS Code)

## Passos

1. Clone o repositório:

```bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
```

2. Abra o projeto em sua IDE.

3. Execute a classe:

```
view/Main.java
```

4. Utilize o menu interativo para acessar as funcionalidades do sistema.

---

# 💾 Armazenamento de dados

Este projeto utiliza persistência simulada em memória, através de coleções do Java (`List` e `Map`).

Os dados permanecem armazenados apenas durante a execução do programa.

---

# 🚧 Possíveis melhorias

- Persistência em banco de dados (MySQL ou PostgreSQL);
- Interface gráfica (JavaFX ou Swing);
- Login de funcionários;
- Geração de relatórios em PDF;
- Pesquisa avançada de doadores;
- Histórico completo de movimentação das bolsas;
- API REST utilizando Spring Boot.

---

# 📚 Documentação

O projeto possui:

- Documento de requisitos;
- Casos de uso;
- Diagrama de Classes;
- Diagrama de Máquina de Estados;
- Documentação técnica da disciplina.

---

# 📄 Licença

Este projeto foi desenvolvido exclusivamente para fins acadêmicos na disciplina de Programação Orientada a Objetos do Instituto Federal do Acre (IFAC).
