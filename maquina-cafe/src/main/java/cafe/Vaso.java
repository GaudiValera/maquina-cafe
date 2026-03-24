package cafe;

/**
 * Representa un tipo de vaso en la máquina de café.
 * Almacena la cantidad de vasos disponibles y el contenido (oz) de ese tipo.
 */
public class Vaso {

    private int cantidadVasos;
    private int contenido; // oz de café que corresponden a este tamaño

    public Vaso(int cantidadVasos, int contenido) {
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public void setCantidadVasos(int cantidadVasos) {
        this.cantidadVasos = cantidadVasos;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    /**
     * Verifica si hay suficientes vasos disponibles.
     * @param cantidad cuántos vasos se necesitan
     * @return true si hay suficientes, false si no
     */
    public boolean hasVasos(int cantidad) {
        return cantidadVasos >= cantidad;
    }

    /**
     * Entrega (descuenta) la cantidad indicada de vasos.
     * @param cantidad vasos a descontar
     */
    public void giveVasos(int cantidad) {
        this.cantidadVasos -= cantidad;
    }
}
