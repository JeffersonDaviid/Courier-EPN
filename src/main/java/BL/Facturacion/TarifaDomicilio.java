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
        float subtotal = super.getSubtotal();

        // valor quemado
        System.out.println(subtotal);
        super.setSubtotal(subtotal + valorDomicilio);
        System.out.println(subtotal);
        super.setTotal(subtotal + (subtotal * (super.getIvaPorcentaje() / 100)));

        setDescripcionTarifa(
                getDescripcionTarifa() != null
                        ? getDescripcionTarifa() + ", " + nombreDescripcion + " " + valorDomicilio
                        : nombreDescripcion + " " + valorDomicilio);

    }

}
