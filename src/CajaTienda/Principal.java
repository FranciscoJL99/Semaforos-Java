package CajaTienda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

    public static void main(String[] args) {
        int CLIENTES = 20;

        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
          for (int i = 0; i < CLIENTES; i++) {
              ejecutor.execute(new Cliente(i + 1, new Caja()));
          }
          ejecutor.shutdown();
         while (!ejecutor.isTerminated()) ;

    }
}

