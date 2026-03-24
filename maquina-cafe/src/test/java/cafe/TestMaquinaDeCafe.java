package cafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests de integración para MaquinaDeCafe.
 *
 * Incluye:
 *  - Los 10 tests del PDF (igual estructura).
 *  - Los 5 casos de prueba adicionales del estudiante:
 *      CP1: Servir vaso pequeño  (3 oz)
 *      CP2: Servir vaso mediano  (5 oz)
 *      CP3: Servir vaso grande   (7 oz)
 *      CP4: Agregar azúcar
 *      CP5: No hay vasos disponibles
 *
 * Estudiante : Gaudi Valera  |  Matrícula: 2024-1398
 * Período    : Enero – Abril 2026 – C1
 * Profesora  : Eduandy Isabel Cruz Abreu
 */
public class TestMaquinaDeCafe {

    Cafetera cafetera;
    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;
    Azucarero azucarero;
    MaquinaDeCafe maquinaDeCafe;

    @Before
    public void setUp() {
        cafetera     = new Cafetera(50);
        vasosPequeno = new Vaso(5, 3);   // 3 oz  → vaso pequeño
        vasosMediano = new Vaso(5, 5);   // 5 oz  → vaso mediano
        vasosGrande  = new Vaso(5, 7);   // 7 oz  → vaso grande
        azucarero    = new Azucarero(20);

        maquinaDeCafe = new MaquinaDeCafe();
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    // ════════════════════════════════════════════════════════════════════════
    // Tests del PDF
    // ════════════════════════════════════════════════════════════════════════

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        assertEquals(maquinaDeCafe.vasosPequeno, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("mediano");
        assertEquals(maquinaDeCafe.vasosMediano, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("grande");
        assertEquals(maquinaDeCafe.vasosGrande, vaso);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 10, 2);

        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        cafetera = new Cafetera(5);
        maquinaDeCafe.setCafetera(cafetera);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno"); // necesita 3 oz

        // Con solo 5 oz en la cafetera pero solicitando un vaso que necesita
        // más de lo disponible → reconfiguramos cafetera a 2 oz para forzar fallo
        cafetera = new Cafetera(2);
        maquinaDeCafe.setCafetera(cafetera);

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);

        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        azucarero = new Azucarero(2);
        maquinaDeCafe.setAzucarero(azucarero);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafe() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno"); // 3 oz

        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

        // 50 oz iniciales − 3 oz = 47
        assertEquals(47, maquinaDeCafe.getCafetera().getCantidadCafe());
    }

    @Test
    public void deberiaRestarVaso() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

        // 5 vasos iniciales − 1 = 4
        assertEquals(4, maquinaDeCafe.getVasosPequeno().getCantidadVasos());
    }

    @Test
    public void deberiaRestarAzucar() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

        // 20 cucharadas iniciales − 3 = 17
        assertEquals(17, maquinaDeCafe.getAzucarero().getCantidadAzucar());
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

        assertEquals("Felicitaciones", resultado);
    }

    // ════════════════════════════════════════════════════════════════════════
    // Casos de Prueba del estudiante (Gaudi Valera – 2024-1398)
    // ════════════════════════════════════════════════════════════════════════

    /**
     * CP1 – Servir café en vaso pequeño
     * Entrada : seleccionar vaso pequeño
     * Esperado: la máquina sirve 3 oz de café (cafetera pasa de 50 a 47)
     */
    @Test
    public void CP1_servirVasoPequeno_debeSirvarTresOzDeCafe() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 0);

        assertEquals("Felicitaciones", resultado);
        // Verifica que se descontaron exactamente 3 oz
        assertEquals(47, maquinaDeCafe.getCafetera().getCantidadCafe());
    }

    /**
     * CP2 – Servir café en vaso mediano
     * Entrada : seleccionar vaso mediano
     * Esperado: la máquina sirve 5 oz de café (cafetera pasa de 50 a 45)
     */
    @Test
    public void CP2_servirVasoMediano_debeSirvarCincoOzDeCafe() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("mediano");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 0);

        assertEquals("Felicitaciones", resultado);
        assertEquals(45, maquinaDeCafe.getCafetera().getCantidadCafe());
    }

    /**
     * CP3 – Servir café en vaso grande
     * Entrada : seleccionar vaso grande
     * Esperado: la máquina sirve 7 oz de café (cafetera pasa de 50 a 43)
     */
    @Test
    public void CP3_servirVasoGrande_debeSirvarSieteOzDeCafe() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("grande");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 0);

        assertEquals("Felicitaciones", resultado);
        assertEquals(43, maquinaDeCafe.getCafetera().getCantidadCafe());
    }

    /**
     * CP4 – Agregar azúcar al café
     * Entrada : seleccionar 2 cucharadas de azúcar
     * Esperado: el café se sirve con 2 cucharadas de azúcar (azucarero: 20 → 18)
     */
    @Test
    public void CP4_agregarAzucar_debDescontarDosAzucar() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);

        assertEquals("Felicitaciones", resultado);
        assertEquals(18, maquinaDeCafe.getAzucarero().getCantidadAzucar());
    }

    /**
     * CP5 – Sin vasos disponibles
     * Entrada : usuario intenta pedir café cuando no hay vasos
     * Esperado: la máquina muestra "No hay Vasos"
     */
    @Test
    public void CP5_sinVasosDisponibles_debeMostrarMensajeNoHayVasos() {
        // Reemplazamos el vaso pequeño con uno que tiene 0 vasos
        Vaso vasoSinStock = new Vaso(0, 3);
        maquinaDeCafe.setVasosPequeno(vasoSinStock);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);

        assertEquals("No hay Vasos", resultado);
    }
}
