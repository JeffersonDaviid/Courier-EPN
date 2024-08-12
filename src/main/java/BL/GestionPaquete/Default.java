package BL.GestionPaquete;

public class Default extends EstadoPaquete {

    public Default(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void gestionarPaquete(Paquete paquete) {
        // Implementación del método gestionarPaquete
        System.out.println("Gestionando el paquete en estado Default.");
    }

    @Override
    public void realizarEnvio(Paquete paquete) {
        // Implementar la lógica de cambio de estado
        System.out.println("El paquete ha sido aceptado. Moviéndolo a la bodega.");
        paquete.cambiarEstado(new EnBodega(paquete));
    }

    @Override
    public String toString() {
        return "Aceptado";
    }
}
