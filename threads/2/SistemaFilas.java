public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10);
        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);
        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        produtor1.start();
        produtor2.start();

        try {
            Thread.sleep(5000);
            consumidor1.start();
            consumidor2.start();
            Thread.sleep(15000);
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
