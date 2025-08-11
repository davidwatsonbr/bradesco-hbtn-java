import java.util.LinkedList;

public class Fila {
    private int capacidadeMaxima;
    private LinkedList<Integer> fila;

    public Fila(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        fila = new LinkedList<>();
    }

    public boolean estaCheia() {
        return fila.size() >= capacidadeMaxima;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (estaCheia()) {
            wait();
        }
        fila.add(item);
        notifyAll();
    }

    public synchronized void retirar() throws InterruptedException {
        while (estaVazia()) {
            wait();
        }
        fila.removeFirst();
        notifyAll();;
    }
}
