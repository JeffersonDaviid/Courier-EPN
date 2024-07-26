package BL.Transporte;

public class CamionFactory {
    public static Camion crearCamion(String tipo, String placa, String modelo, String marca, int capacidadCarga,
            int disponibilidad, String agencia) {
        return switch (tipo) {
            case "carga" -> new CamionCarga(placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
            case "entrega" -> new CamionEntrega(placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
            default -> throw new IllegalArgumentException("Tipo de camión desconocido: " + tipo);
        };
    }
}