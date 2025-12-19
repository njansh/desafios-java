# 📦 Sistema de Pedidos (Java)

Este projeto consiste em um **Sistema de Pedidos desenvolvido em Java**, com foco na **prática de Programação Orientada a Objetos**, **modelagem de domínio** e **implementação de regras de negócio**, sem o uso de frameworks.

O objetivo principal é **consolidar fundamentos essenciais para back-end Java**, simulando um sistema real de pedidos, desde a criação de clientes e produtos até o processamento completo de um pedido.

---

## 🎯 Objetivo do Projeto

* Praticar **POO na prática**, indo além de exemplos simples
* Aplicar **regras de negócio reais**
* Trabalhar com **validações, exceções e estados**
* Organizar o código em **camadas bem definidas**
* Criar uma base sólida para **refatorações futuras**

Este projeto faz parte de uma sequência de desafios, onde a evolução e melhoria do código acontecerão **após a conclusão de vários exercícios**.

---

## 🧠 Conceitos Aplicados

* Encapsulamento
* Composição de objetos
* Enum para controle de estado
* Validações no construtor e nos métodos
* Regras de transição de estado
* Separação de responsabilidades
* Uso de `List` e cópias defensivas
* Exceções para garantir consistência do sistema

---

## 📁 Estrutura de Pacotes

```text
br.com.nadson.sistema_de_pedidos
│
├── enums
│   └── StatusPedido.java
│
├── modelo
│   ├── Cliente.java
│   ├── Produto.java
│   ├── ItemPedido.java
│   └── Pedido.java
│
├── service
│   └── PedidoService.java
│
└── principal
    └── Main.java
```

---

## 📌 Regras de Negócio Implementadas

### Cliente

* Nome e email não podem ser nulos ou vazios

### Produto

* Nome obrigatório
* Preço deve ser maior que zero

### Pedido

* Um pedido sempre pertence a um cliente
* Status inicial: `CRIADO`
* Não é possível:

    * Modificar itens após o pedido ser pago
    * Ir direto de `CRIADO` para `ENTREGUE`
    * Alterar pedidos `ENTREGUE` ou `CANCELADO`
    * Reverter estados inválidos

### ItemPedido

* Quantidade deve ser maior que zero
* Produto não pode ser nulo
* Valor total calculado automaticamente

---

## 🔄 Fluxo do Sistema

1. Criar clientes
2. Criar produtos
3. Criar itens de pedido
4. Criar pedidos vinculados a clientes
5. Adicionar/remover itens (somente enquanto `CRIADO`)
6. Calcular valor total do pedido
7. Processar pedido:

    * Pagar
    * Entregar **ou**
    * Cancelar

O fluxo completo é demonstrado na classe `Main`.

---

## ▶️ Execução

Basta executar a classe:

```java
br.com.nadson.sistema_de_pedidos.principal.Main
```

Ela simula:

* Criação de clientes e produtos
* Criação de pedidos
* Adição e remoção de itens
* Pagamento, entrega e cancelamento
* Tratamento de erros de regras de negócio

---

## 🚀 Estado do Projeto

✔ **Desafio concluído (versão 1.0)**

🔧 Melhorias planejadas para versões futuras:

* Refatoração de responsabilidades
* Uso de interfaces
* Testes unitários
* Persistência de dados
* Evolução para API REST
* Tratamento global de exceções

Essas melhorias serão feitas **após a conclusão de novos desafios**, como parte da evolução contínua do aprendizado.

---

## 👨‍💻 Autor

Projeto desenvolvido por **Nadson Jhony**, com foco em evolução técnica rumo ao **nível pleno em Java back-end**.

