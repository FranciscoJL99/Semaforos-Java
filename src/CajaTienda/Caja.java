package CajaTienda;
import java.util.logging.Level;
import java.util.logging.Logger;
import static CajaTienda.ControlCaja.*;
public class Caja {
    long tiempoNecesitado = (long) (Math.random() * 10000) + 100;
    int numeroCajas;
    long tiempoControlCaja = (long) (Math.random() * 1000);

 public void usarCaja(int idCliente) {
     try {
         boolean control = true;
         while (control){
          numeroCajas =  (int)(Math.random() * 5) + 1;
             Thread.sleep(tiempoControlCaja);
             if(cajaDisponible(numeroCajas)) {
            cajaEnUso(numeroCajas);
            System.out.println("El cliente " + idCliente + " esta usando el cajero " + numeroCajas);
            Thread.sleep(tiempoNecesitado);
            System.out.println("El cliente " + idCliente + " ha salido de la caja " + numeroCajas + " en " + tiempoNecesitado/1000 + " minutos");
            control = false;
            liberarCaja(numeroCajas);
          }
         }
     } catch (InterruptedException E) {
         Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, E);
        }
    }

}
