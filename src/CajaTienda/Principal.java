package CajaTienda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

    public static void main(String[] args) {
        int CLIENTES = 20;

        /**
        ExecutorServies nos simplifica las tareas proveyendo un pool de hilos
        que son manejados por esta API abstrayendonos del trabajo de crearlos
        y asignarles tareas a estos hilos.
        **/
        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
          for (int i = 0; i < CLIENTES; i++) {
              ejecutor.execute(new Cliente(i + 1, new Caja()));
          }
          /**
           * deja de aceptar nuevas tareas y cuando las finaliza se cierra
           * espera a que las tareas actualmente en ejecución o en la cola se realicen
           * */
          ejecutor.shutdown();
         while (!ejecutor.isTerminated()) ;

    }
}

