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
        // valor quemado
        super.setSubtotal(super.getSubtotal() + valorDomicilio);
        super.setTotal(super.getSubtotal() + (super.getSubtotal() * (super.getIva() / 100)));

        setDescripcionTarifa(
                getDescripcionTarifa() != null ? getDescripcionTarifa() + ", " + nombreDescripcion : nombreDescripcion);

    }

}
