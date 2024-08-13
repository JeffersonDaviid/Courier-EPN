package BL.Transporte;

import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public enum Ubicacion {
    CUENCA,
    GUARANDA,
    AZOGUES,
    TULCAN,
    LATACUNGA,
    RIOBAMBA,
    MACHALA,
    ESMERALDAS,
    GUAYAQUIL,
    IBARRA,
    LOJA,
    BABAHOYO,
    PORTOVIEJO,
    MACAS,
    TENA,
    FRANCISCO_DE_ORELLANA,
    PUYO,
    QUITO,
    SANTA_ELENA,
    SANTO_DOMINGO,
    NUEVA_LOJA,
    AMBATO,
    ZAMORA;

    // Método estático para retornar todos los valores del enum como una lista
    public static List<Ubicacion> obtenerTodasLasUbicaciones() {
        return Arrays.asList(Ubicacion.values());
    }
}