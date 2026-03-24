package cafe;

/**
 * Representa el azucarero de la máquina.
 * Gestiona la cantidad de cucharadas de azúcar disponibles.
 */
public class Azucarero {

    private int cantidadDeAzucar;

    public Azucarero(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public int getCantidadAzucar() {
        return cantidadDeAzucar;
    }

    /**
     * Verifica si hay suficiente azúcar disponible.
     * @param cantidad cucharadas requeridas
     * @return true si hay suficiente, false si no
     */
    public boolean hasAzucar(int cantidad) {
        return cantidadDeAzucar >= cantidad;
    }

    /**
     * Sirve (descuenta) la cantidad indicada de azúcar.
     * @param cantidad cucharadas a descontar
     */
    public void giveAzucar(int cantidad) {
        this.cantidadDeAzucar -= cantidad;
    }
}
