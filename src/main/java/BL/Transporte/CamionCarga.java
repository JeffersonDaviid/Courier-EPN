package BL.Transporte;

import java.util.List;

import BL.GestionPaquete.Paquete;

public class CamionCarga extends Vehiculo {

    public CamionCarga(String modelo, String marca, int capacidadCarga, boolean disponibilidad,
            List<Paquete> paquetes) {
        super(modelo, marca, capacidadCarga, disponibilidad, paquetes);
    }

}
