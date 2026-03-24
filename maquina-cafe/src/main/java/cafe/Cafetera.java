package cafe;

/**
 * Representa la cafetera de la máquina.
 * Gestiona la cantidad de café disponible en onzas.
 */
public class Cafetera {

    private int cantidadCafe; // onzas de café disponibles

    public Cafetera(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public void setCantidaDeCafe(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public int getCantidadCafe() {
        return cantidadCafe;
    }

    /**
     * Verifica si hay suficiente café disponible.
     * @param cantidad onzas de café requeridas
     * @return true si hay suficiente, false si no
     */
    public boolean hasCafe(int cantidad) {
        return cantidadCafe >= cantidad;
    }

    /**
     * Sirve (descuenta) la cantidad indicada de café.
     * @param cantidad onzas a descontar
     */
    public void giveCafe(int cantidad) {
        this.cantidadCafe -= cantidad;
    }
}
