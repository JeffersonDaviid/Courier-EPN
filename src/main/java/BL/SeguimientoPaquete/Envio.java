package BL.SeguimientoPaquete;
import BL.GestionPaquete.Paquete;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author TOMMY
 */
public class Envio {
    private int id;
    private List<Paquete> paquetesDomicilio;
    private List<Paquete>paquetesAgencia;
    private List<Paquete>paquetes;
    private boolean isLocal;
    private String fecha;
    private String agenciaRemitente;
    private String destino;
    private boolean isComplete;
    private Seguimiento seguimiento;
    private CamionCarga camionCarga;
    private CamionEntrega camionEntrega;
    public Envio(int id, String fecha, String agenciaRemitente, String destino) {
        this.id = id;
        this.paquetes = new ArrayList<>();
        this.fecha = fecha;
        this.agenciaRemitente = agenciaRemitente;
        this.destino = destino;
        this.isComplete = false;
    }
        // Métodos
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }
    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    public void verificarTipoEnvio() {
        for (Paquete paquete : paquetes) {
            if (paquete.getEntrega().getTipoentrega().contentEquals("Domicilio")) {
                destino="Domicilio";
            } else {
                destino="Agencia";
            }
        }
    }

    public void asignarPaquetes(List<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }

    public void registrarEnvio() {
        // Implementación
    }

    public void asignarCamion() {
        this.camionCarga = camionCarga;
        this.camionEntrega = camionEntrega;
        // Separar paquetes en dos listas según el destino
        for (Paquete paquete : paquetes) {
            if (paquete.getEntrega().getTipoentrega().equalsIgnoreCase("Domicilio")) {
                paquetesDomicilio.add(paquete);
            } else if (paquete.getEntrega().getTipoentrega().equalsIgnoreCase("Agencia")) {
                paquetesAgencia.add(paquete);
            }
        }
    }

    public void verificarLlegada() {
        if (seguimiento.getUbicacion().equalsIgnoreCase(destino)) {
            this.isComplete = true;
            System.out.println("El envío con ID " + this.id + " ha sido completado.");
        } else {
            this.isComplete = false;
            System.out.println("El envío con ID " + this.id + " está en progreso.");
        }
    }  
}
