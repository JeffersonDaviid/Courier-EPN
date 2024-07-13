package BL.Facturacion;

import BL.GestionPaquete.Paquete;

public class Precio implements ITarifa {
    private Paquete paquete;
    private TarifaAdicional tarifaAdicional;

    private float valorSinIva;
    private float valorConIva;
    private int iva = 15;

    public Precio(Paquete paquete, TarifaAdicional tarifaAdicional) {
        this.paquete = paquete;
        this.tarifaAdicional = tarifaAdicional;
    }

    public void calcularPrecioEnvio() {

    }
}
