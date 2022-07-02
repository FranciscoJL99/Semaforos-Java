package CajaTienda;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
    int idCliente;
    Caja caja;
    static int numeroCajas = 5; // Numero de cajas en la tienda.
    static Semaphore semaforo = new Semaphore(numeroCajas);
    public Cliente(int id, Caja caja){
        this.idCliente = id;
        this.caja = caja;
    }
    @Override
    public void run() {
        try {
            /**
             * bloquea la ejecución del hilo en curso y queda a la espera
             * de que otro hilo llame a release()
             * **/
            semaforo.acquire(); //Hace down al semaforo
            this.caja.usarCaja(this.idCliente);
        } catch (InterruptedException E) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, E);
        }
        /**
         * Liberar un semáforo, incrementando su contador interno en una unidad. Si era cero a la entrada
         * y otro hilo está esperando a que sea mayor que cero, despertar a dicho hilo.
         * **/
        semaforo.release(); //Hace up al semaforo
    }
}