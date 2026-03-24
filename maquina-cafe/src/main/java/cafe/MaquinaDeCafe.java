package cafe;

/**
 * Máquina dispensadora de café.
 * Orquesta los componentes: Vaso, Cafetera y Azucarero.
 *
 * Tamaños de vaso según la especificación:
 *   - Pequeño  → 3 oz de café
 *   - Mediano  → 5 oz de café
 *   - Grande   → 7 oz de café
 */
public class MaquinaDeCafe {

    private Cafetera cafe;
    public Vaso vasosPequeno;
    public Vaso vasosMediano;
    public Vaso vasosGrande;
    private Azucarero azucar;

    // ── Setters / Getters de componentes ────────────────────────────────────

    public void setCafetera(Cafetera cafe) {
        this.cafe = cafe;
    }

    public Cafetera getCafetera() {
        return cafe;
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public Vaso getVasosPequeno() {
        return vasosPequeno;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public Vaso getVasosMediano() {
        return vasosMediano;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public Vaso getVasosGrande() {
        return vasosGrande;
    }

    public void setAzucarero(Azucarero azucar) {
        this.azucar = azucar;
    }

    public Azucarero getAzucarero() {
        return azucar;
    }

    // ── Lógica principal ─────────────────────────────────────────────────────

    /**
     * Devuelve el objeto Vaso correspondiente al tipo solicitado.
     * @param tipoDeVaso "pequeno", "mediano" o "grande"
     * @return el Vaso correspondiente
     */
    public Vaso getTipoDeVaso(String tipoDeVaso) {
        switch (tipoDeVaso.toLowerCase()) {
            case "pequeno":  return vasosPequeno;
            case "mediano":  return vasosMediano;
            case "grande":   return vasosGrande;
            default:         return null;
        }
    }

    /**
     * Intenta servir un vaso de café con azúcar.
     *
     * @param vaso              el tipo de vaso seleccionado
     * @param cantidadDeVasos   cuántos vasos se solicitan (normalmente 1)
     * @param cantidadDeAzucar  cucharadas de azúcar deseadas
     * @return mensaje de resultado:
     *         "No hay Vasos"    → si no hay vasos del tipo pedido
     *         "No hay Cafe"     → si la cafetera no tiene café suficiente
     *         "No hay Azucar"   → si el azucarero no tiene suficiente azúcar
     *         "Felicitaciones"  → operación exitosa
     */
    public String getVasoDeCafe(Vaso vaso, int cantidadDeVasos, int cantidadDeAzucar) {

        // 1. Verificar vasos
        if (!vaso.hasVasos(cantidadDeVasos)) {
            return "No hay Vasos";
        }

        // 2. Verificar café (el contenido del vaso indica las oz requeridas)
        if (!cafe.hasCafe(vaso.getContenido())) {
            return "No hay Cafe";
        }

        // 3. Verificar azúcar
        if (!azucar.hasAzucar(cantidadDeAzucar)) {
            return "No hay Azucar";
        }

        // 4. Servir: descontar recursos
        vaso.giveVasos(cantidadDeVasos);
        cafe.giveCafe(vaso.getContenido());
        azucar.giveAzucar(cantidadDeAzucar);

        return "Felicitaciones";
    }
}
