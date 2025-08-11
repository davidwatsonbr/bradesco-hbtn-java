public class Principal {
    Contador contador = new Contador();
    ThreadContador thread1 = new ThreadContador(contador);
    ThreadContador thread2 = new ThreadContador(contador);
 
    thread1.run();
    thread2.run();

    System.out.println("1 -> contagem: " + thread1.getContagem());
    System.out.println("2 -> contagem: " + thread2.getContagem());
}
