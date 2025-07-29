import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {
    private List<PedidoCookie> cookies;

    public Pedido() {
        cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int totalCaixas = 0;
        Iterator<PedidoCookie> i = cookies.iterator();
        while (i.hasNext()) {
            totalCaixas += i.next().getQuantidadeCaixas();
        }

        return totalCaixas;
    }

    public int removerSabor(String sabor) {
        int quantidadeCaixasRemovidas = 0;
        Iterator<PedidoCookie> i = cookies.iterator();
        while (i.hasNext()) {
            PedidoCookie pedido = i.next();
            if (pedido.getSabor() == sabor) {
                quantidadeCaixasRemovidas += pedido.getQuantidadeCaixas();
                i.remove();
            }
        }

        return quantidadeCaixasRemovidas;
    }
}
