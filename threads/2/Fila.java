import java.util.LinkedList;

public class Fila {
    private int capacidadeMaxima;
    private LinkedList<Integer> fila;

    public Fila(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        fila = new LinkedList<>();
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() >= capacidadeMaxima) {
            wait();
        }
        fila.add(item);
        System.out.println("Produzido: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.size() == 0) {
            wait();
        }
        int item = fila.removeLast();
        System.out.println("Consumido: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
        return item;
    }
}
