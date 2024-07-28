package BL.Facturacion;

import BL.GestionPaquete.Paquete;

public class TarifaDomicilio extends TarifaDecorador {

    private float valorDomicilio = 2.75f;
    private String nombreDescripcion = "Servicio a Domicilio";

    // VALOR FIJO PARA TODA LA CIUDAD
    public TarifaDomicilio(Tarifa tarifaDecorada) {
        super(tarifaDecorada);
    }

    public void calcularPrecio(Paquete paquete) {
        super.cargarIvar();
        tarifaDecorada.calcularPrecio(paquete);
        float subtotal = tarifaDecorada.getSubtotal();
        // valor quemado
        super.setSubtotal(subtotal + valorDomicilio);
        super.setTotal(getSubtotal() + (getSubtotal() * (super.getIva() / 100)));

        setDescripcionTarifa(
                getDescripcionTarifa() != null
                        ? getDescripcionTarifa() + ", " + nombreDescripcion + " " + valorDomicilio
                        : nombreDescripcion + " " + valorDomicilio);

    }

}
