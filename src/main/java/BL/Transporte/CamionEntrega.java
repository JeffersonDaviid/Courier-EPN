package BL.Transporte;

import java.util.List;

import BL.GestionPaquete.Paquete;

public class CamionEntrega extends Vehiculo {

    public CamionEntrega(String modelo, String marca, int capacidadCarga, int disponibilidad,
            List<Paquete> paquetes, int ruta) {
        super(modelo, marca, capacidadCarga, disponibilidad, paquetes, ruta);
    }
}
