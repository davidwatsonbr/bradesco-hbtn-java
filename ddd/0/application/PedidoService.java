package application;

import domain.Cliente;
import domain.Pedido;
import domain.Produto;
import infrastructure.PedidoRepository;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Cliente cliente) {
        // implementar
        Pedido pedido = new Pedido(cliente);
        pedidoRepository.salvar(pedido);
        return pedido;
    }

    public void adicionarProduto(String pedidoId, Produto produto) {
        // implementar
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.adicionarProduto(produto);
        pedidoRepository.salvar(pedido);
    }

    public void pagarPedido(String pedidoId) {
        // implementar
        pedidoRepository.buscarPorId(pedidoId).pagar();
    }

    public void cancelarPedido(String pedidoId) {
        // implementar
        pedidoRepository.buscarPorId(pedidoId).cancelar();
    }
}