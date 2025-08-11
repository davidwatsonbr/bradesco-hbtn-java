public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = fila.retirar();
                System.out.println(Thread.currentThread().getName() + " processando: " + item);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Consumidor " + getName() + " interrompido.");
        }
    }
}
