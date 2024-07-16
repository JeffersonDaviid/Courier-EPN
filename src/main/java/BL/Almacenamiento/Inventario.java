package BL.Almacenamiento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import BL.GestionPaquete.Paquete;

/**
 *
 * @author BugsBusters
 */

public class Inventario {
    private double capacidadTotal;
    private double capacidadOcupada;
    private int tiempoMaximo;
    private String agencia;

    public Inventario(int tiempoMaximo, double capacidadTotal,double capacidadOcupada ){
        this.tiempoMaximo = tiempoMaximo;
        this.capacidadTotal = capacidadTotal;
        this.capacidadOcupada = capacidadOcupada;
        this.agencia = "Quito";
        //this.paquetes = new HashMap<>();
        //this.historial = new Historial();
    }

        //Metodo que registra un paquete que se ha recibido la agencia

         //Metodo que actualiza la Capacidad Ocupada del Inventario
    public void actualizarBodega(double cantidad){
        capacidadOcupada += cantidad;
    }

    public void actualizarCapacidadTotal(double nuevaCapacidad){
        this.capacidadTotal = nuevaCapacidad;
    }

    // Calcular fecha límite

    public double getCapacidadTotal(){
        return capacidadTotal;
    }

    public double getCapacidadOcupada(){
        return capacidadOcupada;
    }

    //Mostrar paquete

    //Buscar paquete

    private void notificarCapacidadCompleta(){
        System.out.println("Capacidad total alcanzada");
    }

    //Retirar paquete

    private String getFecha(){
        return LocalDate.now().toString();
    }
    private String getHora(){
        return LocalTime.now().toString();
    }

    private String getAgencia(){
        return agencia;
    }

   /*  public void mostrarHistorial() {
        historial.consultarHistorial();
    }

    public void mostrarHistorialIngresos() {
        historial.consultarHistorialIngreso();
    }

    public void mostrarHistorialSalidas() {
        historial.consultarHistorialSalida();
    }
        */
}
