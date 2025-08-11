import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = new Random().nextInt(1, 100);
                fila.adicionar(item);
                System.out.println("Produtor adicionou: " + item);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
