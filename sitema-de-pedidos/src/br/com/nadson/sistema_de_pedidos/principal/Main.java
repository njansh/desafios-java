package br.com.nadson.sistema_de_pedidos.principal;

import br.com.nadson.sistema_de_pedidos.modelo.Cliente;
import br.com.nadson.sistema_de_pedidos.modelo.ItemPedido;
import br.com.nadson.sistema_de_pedidos.modelo.Pedido;
import br.com.nadson.sistema_de_pedidos.modelo.Produto;
import br.com.nadson.sistema_de_pedidos.service.PedidoService;

public class Main {
    public static void main(String[] args) {
        PedidoService ps = new PedidoService();

        // Criando clientes
        Cliente c1 = ps.criarCliente("Nadson", "nadson@example.com");
        Cliente c2 = ps.criarCliente("Maria", "maria@example.com");
        System.out.println("Clientes criados: " + c1.getNome() + ", " + c2.getNome());

        // Criando produtos
        Produto p1 = ps.criarProduto("Notebook", 2500.00);
        Produto p2 = ps.criarProduto("Mouse", 75.00);
        Produto p3 = ps.criarProduto("Teclado", 150.00);
        System.out.println("Produtos criados: " + p1.getNome() + ", " + p2.getNome() + ", " + p3.getNome());

        // Criando itens de pedido
        ItemPedido ip1 = ps.criarIntem(1, p1);
        ItemPedido ip2 = ps.criarIntem(2, p2);
        ItemPedido ip3 = ps.criarIntem(1, p3);
        System.out.println("Itens de pedido criados.");

        // Criando um pedido para o cliente 1
        Pedido pedido1 = ps.criarPedido(c1);
        System.out.println("Pedido 1 criado para " + pedido1.getCliente().getNome() + ". Status: " + pedido1.getStatus());

        // Adicionando itens ao pedido 1
        ps.adicionarItem(pedido1, ip1);
        ps.adicionarItem(pedido1, ip2);
        System.out.println("Itens adicionados ao Pedido 1.");
        System.out.println("Valor total do Pedido 1: " + ps.calcularValorTotal(pedido1));

        // Criando um pedido para o cliente 2
        Pedido pedido2 = ps.criarPedido(c2);
        ps.adicionarItem(pedido2, ip3);
        System.out.println("Pedido 2 criado para " + pedido2.getCliente().getNome() + ". Status: " + pedido2.getStatus());
        System.out.println("Valor total do Pedido 2: " + ps.calcularValorTotal(pedido2));

        // Removendo um item do pedido 1
        ps.removerItem(pedido1, ip2);
        System.out.println("Item " + ip2.getProduto().getNome() + " removido do Pedido 1.");
        System.out.println("Novo valor total do Pedido 1: " + ps.calcularValorTotal(pedido1));

        // Processando o pedido 1
        ps.pagar(pedido1);
        System.out.println("Pedido 1 pago. Status: " + pedido1.getStatus());

        ps.entregar(pedido1);
        System.out.println("Pedido 1 entregue. Status: " + pedido1.getStatus());

        // Tentando cancelar um pedido entregue (deve lançar exceção)
        try {
            ps.cancelar(pedido1);
        } catch (IllegalStateException e) {
            System.out.println("Erro ao tentar cancelar Pedido 1: " + e.getMessage());
        }

        // Cancelando o pedido 2
        ps.cancelar(pedido2);
        System.out.println("Pedido 2 cancelado. Status: " + pedido2.getStatus());
    }
}
