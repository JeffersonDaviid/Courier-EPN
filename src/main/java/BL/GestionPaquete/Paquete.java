package BL.GestionPaquete;

import java.io.Serializable;

import BL.Administracion.Cliente;
import BL.Almacenamiento.Inventario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paquete implements Serializable {
    private static int contador;
    private String tracking;
    private float peso;
    private String tamanio;
    private Cliente cliente;
    private String sucursalOrigen;
    private String sucursalDestino;
    private String direccion;
    private String nombreDestinatario;
    private String correoDestinatario;
    private String telefonoDestinatario;
    private String fechaSalida;
    private EstadoPaquete estado;
    private Seguimiento seguimiento;

    public Paquete() {
        this.tracking = generarTracking();
        this.fechaSalida = obtenerFechaActual();

    }

    public Paquete(String tracking, float peso, String tamanio, Cliente cliente, String sucursalOrigen, String sucursalDestino, String direccion, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String fechaSalida, Seguimiento seguimiento) {
        this.tracking = tracking;
        this.peso = peso;
        this.tamanio = tamanio;
        this.cliente = cliente;
        this.sucursalOrigen = sucursalOrigen;
        this.sucursalDestino = sucursalDestino;
        this.direccion = direccion;
        this.nombreDestinatario = nombreDestinatario;
        this.correoDestinatario = correoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.fechaSalida = fechaSalida;
        this.estado = new Default(this);
        this.seguimiento = seguimiento;
    }

    private String generarTracking() {
        int  inventario = Inventario.getInstancia().getPaquetesInventario().size();
        return String.valueOf(inventario + 1);
    }
    
     private String obtenerFechaActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(formatter);
    }
    // Método para obtener el estado actual del paquete
    public EstadoPaquete obtenerEstadoActual() {
        return this.estado;
    }

    // Método para cambiar el estado del paquete (puede hacerse protected)
    public void cambiarEstado(EstadoPaquete nuevoEstado) {
        this.estado = nuevoEstado;
        this.fechaSalida = obtenerFechaActual(); // Actualiza la fecha de salida con la fecha actual
        System.out.println("Fecha de salida actualizada: " + this.fechaSalida); // Depuración
        if (seguimiento != null) {
            seguimiento.realizarSeguimiento();
        }
    }

    //getters

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Paquete.contador = contador;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(String sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public String getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(String sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    public void setCorreoDestinatario(String correoDestinatario) {
        this.correoDestinatario = correoDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public EstadoPaquete getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaquete estado) {
        this.estado = estado;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public String toString() {
        return "Paquete{" + "tracking=" + tracking + ", peso=" + peso + ", tamanio=" + tamanio + ", cliente=" + cliente + ", sucursalOrigen=" + sucursalOrigen + ", sucursalDestino=" + sucursalDestino + ", direccion=" + direccion + ", nombreDestinatario=" + nombreDestinatario + ", correoDestinatario=" + correoDestinatario + ", telefonoDestinatario=" + telefonoDestinatario + ", fechaSalida=" + fechaSalida + ", estado=" + estado + ", seguimiento=" + seguimiento + '}';
    }
    
    
   
    
    
    
}
