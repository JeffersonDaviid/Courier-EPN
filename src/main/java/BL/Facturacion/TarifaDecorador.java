package BL.Facturacion;

public abstract class TarifaDecorador extends Tarifa {

    protected Tarifa tarifaDecorada;

    public TarifaDecorador(Tarifa tarifaDecorada) {
        this.tarifaDecorada = tarifaDecorada;
    }

    public void agregarTarifa() {

    }

    // public abstract void calcularPrecioEnvio();

}
