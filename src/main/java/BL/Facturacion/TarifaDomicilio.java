package BL.Facturacion;

public class TarifaDomicilio extends TarifaDecorador {

    private float valorDomicilio = 2.75f;
    private String nombreDescripcion = "Servicio a Domicilio";

    // VALOR FIJO PARA TODA LA CIUDAD
    public TarifaDomicilio(Tarifa tarifaDecorada) {
        super(tarifaDecorada);
    }

    public void calcularPrecioEnvio() {
        super.cargarIvar();
        tarifaDecorada.calcularPrecioEnvio();
        float subtotal = tarifaDecorada.getSubtotal();
        // valor quemado
        super.setSubtotal(subtotal + valorDomicilio);
        super.setTotal(getSubtotal() + (getSubtotal() * (super.getIvaPorcentaje() / 100)));

        setDescripcionTarifa(
                getDescripcionTarifa() != null
                        ? getDescripcionTarifa() + ", " + nombreDescripcion + " " + valorDomicilio
                        : nombreDescripcion + " " + valorDomicilio);

    }

}
