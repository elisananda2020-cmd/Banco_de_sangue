# 🩸 Sistema de Gerenciamento de Banco de Sangue

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de **Sistemas para Internet** do **Instituto Federal do Acre (IFAC)**.

O sistema simula o funcionamento básico de um banco de sangue, permitindo o gerenciamento de doadores, doações e estoque de bolsas de sangue, aplicando os principais conceitos de Programação Orientada a Objetos em Java.

---

## 👥 Integrantes

* Elis Ananda Alves Valente
* Marisol de Sousa Assunção
* Pâmela Bruna da Silva Carioca

**Professor:** Jonas Pontes

---

# 📌 Objetivo

Desenvolver um sistema orientado a objetos capaz de automatizar processos básicos de um banco de sangue, como:

* Cadastro de doadores;
* Registro de doações;
* Controle do estoque de bolsas;
* Registro da utilização das bolsas;
* Consulta ao histórico de doações;
* Emissão de alertas de estoque crítico.

Todo o armazenamento é realizado em memória, utilizando coleções do Java (`List`), simulando um banco de dados.

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

# ✨ Funcionalidades

## Cadastro de Doadores

* Cadastro de nome, CPF, telefone, tipo sanguíneo e peso;
* Impede cadastro de CPF duplicado;
* Validação dos tipos sanguíneos permitidos:

  * A+
  * A-
  * B+
  * B-
  * AB+
  * AB-
  * O+
  * O-
* Listagem de todos os doadores cadastrados;
* Consulta de doador pelo CPF.

---

# 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- UML
- Git
- GitHub

---

## Registro de Doações
Regras implementadas:

* Peso mínimo de **50 kg** para realizar uma doação;
* Volume permitido entre **420 mL e 470 mL**;
* Cada doação gera uma nova bolsa de sangue.

---

## Controle de Estoque

O sistema mantém um estoque organizado por tipo sanguíneo.

Cada bolsa possui um ciclo de vida representado pelos seguintes estados:

* COLETADA
* EM_ANALISE
* APROVADA
* DISPONIVEL
* RESERVADA
* UTILIZADA
* VENCIDA
* REPROVADA

Também é possível:

* Consultar o estoque completo;
* Registrar saídas de bolsas;
* Listar todas as bolsas cadastradas;
* Emitir alertas quando o estoque atingir nível crítico.

---

## Histórico de Doações

Permite consultar todas as doações registradas durante a execução do sistema.

Cada registro contém:

* Código da doação;
* Doador;
* Data;
* Quantidade coletada.

---

# 🛡️ Validações Implementadas

O sistema realiza diversas validações para garantir a consistência dos dados.

### Cadastro

* CPF não pode ser duplicado;
* Tipo sanguíneo deve ser válido.

### Doação

* Peso mínimo de 50 kg;
* Quantidade entre 420 e 470 mL.

### Estoque

* Não permite retirar mais bolsas do que o disponível;
* Emite alerta quando determinado tipo sanguíneo fica abaixo do estoque mínimo.

---

# 🧩 Conceitos de Programação Orientada a Objetos Aplicados

O projeto foi desenvolvido utilizando os principais pilares da Programação Orientada a Objetos.

### Encapsulamento

Os atributos das classes são privados, sendo acessados por meio de métodos públicos (getters e setters quando necessário).

### Herança

A classe `Pessoa` é utilizada como classe base para:

* Doador
* Funcionario

evitando repetição de atributos comuns.

### Polimorfismo

Implementação de interfaces para abstração de comportamentos, permitindo maior flexibilidade do sistema.

### Interfaces

Foram utilizadas:

* `Notificavel`
* `Relatorio`

para representar diferentes responsabilidades dentro da aplicação.

### Coleções

Utilização de coleções do Java para simular a persistência dos dados:

* List: utilizada para armazenar doadores, doações e bolsas de sangue.
* Map: utilizada para gerar o resumo do estoque, relacionando cada tipo sanguíneo à quantidade de bolsas disponíveis.

---

# ⚠️ Exceções Personalizadas

O sistema utiliza exceções customizadas para representar situações específicas:

* `DoadorNaoEncontradoException`
* `EstoqueInsuficienteException`
* `TipoSanguineoInvalidoException`

---

# ▶️ Como Executar

1. Clone este repositório.

```
git clone https://github.com/elisananda2020-cmd/Banco_de_sangue
```

2. Abra o projeto em uma IDE Java (IntelliJ IDEA, Eclipse ou NetBeans).

3. Execute a classe:

```
view.Main
```

4. Utilize o menu interativo exibido no console.

---

# 📚 Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* Coleções (`List`)
* Tratamento de Exceções
* UML (Casos de Uso, Diagrama de Classes e Máquina de Estados)
