# 🏢 Sistema de Reserva de Salas

Este projeto consiste em um **Sistema de Reserva de Salas desenvolvido em Java**, com foco na **prática de Programação Orientada a Objetos**, **modelagem de domínio** e **aplicação de regras de negócio reais**, sem uso de frameworks.

O sistema simula o funcionamento de reservas de salas em ambientes corporativos ou educacionais, garantindo consistência, validações e controle de conflitos.

---

## 🎯 Objetivo do Desafio

* Consolidar conceitos de **POO em Java**
* Praticar **boas decisões de modelagem**
* Implementar **regras de negócio no local correto**
* Separar responsabilidades entre **modelo, serviço e aplicação**
* Evoluir lógica e organização sem dependências externas

---

## 🧩 Funcionalidades Implementadas

### 👤 Usuários

* Cadastro de usuários com validação de nome e email
* Evita duplicidade de usuários por email

### 🏢 Salas

* Cadastro de salas com nome e capacidade
* Evita duplicidade de salas
* Identificação única por ID

### 📅 Reservas

* Criar reservas com:

    * Sala
    * Usuário
    * Data e hora de início e fim
* Validações:

    * Não permite datas inválidas
    * Não permite reservas no passado
    * Uma sala **não pode ter reservas sobrepostas**
* Controle de status:

    * `RESERVADA`
    * `CANCELADA`
    * `FINALIZADA`
* Regras de transição de status respeitadas

### 📋 Consultas

* Listar todas as reservas
* Listar reservas por usuário
* Listar reservas por sala
* Listar salas disponíveis em determinado período

---

## 🗂️ Estrutura de Pacotes

```
br.com.nadson.sistema_de_reserva_de_salas
├── enums
│   └── StatusReserva
├── modelo
│   ├── Sala
│   ├── Usuario
│   └── Reserva
├── service
│   └── ReservaService
└── principal
    └── Main
```

---

## 🧠 Decisões de Projeto

* **Regras de negócio concentradas no Service**
* Entidades focadas apenas em representar o domínio
* Uso de `Set` para evitar duplicidades
* Uso de `LocalDateTime` para controle preciso de horários
* `equals` e `hashCode` baseados em ID
* Service implementado como **Singleton** para centralizar o estado do sistema

---

## ▶️ Execução

O sistema pode ser executado diretamente pela classe:

```
br.com.nadson.sistema_de_reserva_de_salas.principal.Main
```

A classe `Main` demonstra:

* Criação de usuários e salas
* Criação de reservas válidas
* Tentativas de reservas inválidas
* Cancelamento e finalização de reservas
* Consultas de disponibilidade

---

## 📌 Status do Projeto

✅ **Desafio concluído**
🛠️ Próximo passo planejado: **refatoração e melhorias após a conclusão de novos desafios**

---

## 🚀 Próximos Possíveis Passos (Futuros)

* Refatorar Service em interfaces
* Criar testes unitários
* Separar regras de validação
* Persistência em memória ou arquivo
* Evoluir para API REST futuramente

---

📚 **Projeto desenvolvido para fins de estudo e evolução técnica em Java.**
