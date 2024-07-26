package BL.Facturacion;

import BL.GestionPaquete.Paquete;

public class Tarifa {
    private float subtotal;
    private float total;
    private float iva = 0.15f;

    public void calcularPrecio(Paquete paquete) {

        // Calcula el precio del paquete
        switch (paquete.getTamanio()) {
            case "Pequeño":
                subtotal = 5;
                break;
            case "Mediano":
                subtotal = 10;
                break;
            case "Grande":
                subtotal = 15;
                break;
            default:
                subtotal = 0;
                break;
        }

        total = subtotal + (subtotal * iva);
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getTotal() {
        return total;
    }

    public float getIva() {
        return iva;
    }

    public Tarifa() {
    }

}
