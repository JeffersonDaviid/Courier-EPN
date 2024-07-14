package BL.Facturacion;

public class TarifaDomicilio extends TarifaDecorador {

    private float valorDomicilio = 2.75f;
    private String nombreDescripcion = "Servicio a Domicilio";

    // VALOR FIJO PARA TODO LA CIUDAD
    public TarifaDomicilio(Tarifa tarifaDecorada) {
        super(tarifaDecorada);
    }

    public void calcularPrecioEnvio() {
        // valor quemado
        setPrecio(getPrecio() + valorDomicilio);
        setDescripcionTarifa(
                getDescripcionTarifa() != null ? getDescripcionTarifa() + ", " + nombreDescripcion : nombreDescripcion);

    }

}
