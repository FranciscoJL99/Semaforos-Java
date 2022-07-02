package CajaTienda;
public class ControlCaja {
    static int[] cajas = new int[5];
    public static void cajaEnUso(int caja){
        for (int i = 0; i < 5; i++) {
            if (cajas[i] == 0) {
                cajas[i] = caja;
                break;
            }
        }
    }
    public static void liberarCaja(int caja){
        for (int i = 0; i < 5; i++) {
            if (cajas[i] == caja) {
                cajas[i] = 0;
            }
        }
    }
    public static boolean cajaDisponible(int caja){
        for (int i = 0; i < 5; i++) {
            if (cajas[i] == caja) {
                return false;
            }
        }
        return true;
    }
}
