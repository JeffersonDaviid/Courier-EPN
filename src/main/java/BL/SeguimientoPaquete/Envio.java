package BL.SeguimientoPaquete;
import BL.GestionPaquete.Paquete;
import BL.Transporte.Vehiculo;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author TOMMY
 */
public class Envio {
    private int id;
    private List<Paquete> paquetes;
    private Vehiculo vehiculo;
    public Envio() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetesDomicilio(List<Paquete> paquetesDomicilio) {
        this.paquetes = paquetesDomicilio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
