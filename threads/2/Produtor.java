import java.util.concurrent.ThreadLocalRandom;

public class Produtor extends Thread {
    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = ThreadLocalRandom.current().nextInt(1, 101);
                fila.adicionar(item);
                System.out.println("Produtor adicionou: " + item);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
