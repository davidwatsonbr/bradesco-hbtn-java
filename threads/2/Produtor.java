import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = random.nextInt(100) + 1;
                fila.adicionar(item);
                System.out.println(Thread.currentThread().getName() + " processando: " + item);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Produtor " + getName() + " interrompido.");
        }
    }
}
