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
            semaforo.acquire();
            this.caja.usarCaja(this.idCliente);
        } catch (InterruptedException E) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, E);
        }
        semaforo.release();
    }
}