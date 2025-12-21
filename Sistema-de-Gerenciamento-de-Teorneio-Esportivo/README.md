# 🏆 Sistema de Gerenciamento de Torneio Esportivo

Este projeto consiste em um **Sistema de Gerenciamento de Torneio Esportivo**, desenvolvido em **Java puro**, com foco na **prática de Programação Orientada a Objetos (POO)**, **modelagem de domínio**, **regras de negócio** e **boas práticas de organização de código**, **sem uso de frameworks**.

O sistema simula a criação de **jogadores**, **times**, **partidas (ida e volta)**, controle de **pontuação** e geração de **classificação final**.

---

## 🎯 Objetivos do Projeto

* Consolidar conceitos de **POO em Java**
* Aplicar **encapsulamento, abstração, composição e enums**
* Separar corretamente **modelo, serviço e lógica de negócio**
* Utilizar **equals e hashCode** para evitar duplicidades
* Modelar um sistema próximo de um **cenário real**
* Servir como **projeto de portfólio** ou **trabalho acadêmico**

---

## 🧩 Funcionalidades

* Cadastro de jogadores com posição
* Cadastro de times
* Adição de jogadores aos times (mín. 7, máx. 11)
* Criação de partidas (IDA e VOLTA)
* Controle de status da partida:

    * AGENDADA
    * EM_ANDAMENTO
    * FINALIZADA
* Marcação de gols
* Definição automática do resultado da partida
* Distribuição de pontos:

    * Vitória: 3 pontos
    * Empate: 1 ponto para cada time
* Geração de classificação ordenada por pontos
* Validações de regras de negócio

---

## 🗂️ Estrutura do Projeto

```
br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo
│
├── enums
│   ├── Posicao
│   ├── ResultadoPartida
│   ├── StatusPartida
│   └── Turno
│
├── interfaces
│   ├── Competidor
│   ├── Finalizavel
│   ├── Pontuavel
│   └── Validavel
│
├── modelo
│   ├── Jogador
│   ├── Time
│   └── Partida
│
├── service
│   ├── JogadorService
│   ├── TimeService
│   ├── TorneioService
│   └── ClassificacaoService
│
└── principal
    └── Main
```

---

## 📐 Diagrama UML

O projeto possui um **diagrama UML simples de classes**, representando:

* `Jogador`
* `Time`
* `Partida`
* Serviços (`Service`)
* Relacionamentos entre as entidades

📍 **Local recomendado para o diagrama UML:**

```
/docs/uml/diagrama-classes.png
```

E referenciado neste README.

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/njansh/desafios-java.git
```

2. Abra o projeto em uma IDE Java (IntelliJ, Eclipse, VS Code)

3. Execute a classe:

```text
principal.Main
```

O sistema irá:

* Criar jogadores
* Criar times
* Simular partidas de ida e volta
* Exibir placar, resultados e classificação final

---

## 🛠️ Tecnologias Utilizadas

* Java 17+ (ou compatível)
* Java Collections (List, Set)
* Streams API
* Programação Orientada a Objetos
* UML (modelagem)

---

## 📌 Destaques de Design

* Uso de **Set** para evitar duplicidades
* Regras de negócio concentradas nas entidades
* Services responsáveis por orquestração
* `equals` e `hashCode` bem definidos
* Separação clara de responsabilidades
* Código legível e organizado

---

## 📚 Possíveis Melhorias Futuras

* Persistência em banco de dados
* Interface gráfica ou API REST
* Critérios de desempate na classificação
* Estatísticas por jogador
* Suporte a múltiplos torneios

---

## 👤 Autor

**Nadson Jhony**
Projeto desenvolvido para estudo e prática de **Java e Programação Orientada a Objetos**.

---