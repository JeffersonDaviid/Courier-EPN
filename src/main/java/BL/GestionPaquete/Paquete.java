package BL.GestionPaquete;

public class Paquete {
    private String tracking;
    private float peso;
    private String tamanio;
    private String cliente;
    private String sucursalOrigen;
    private String sucursalDestino;
    private String direccion;
    private EstadoPaquete estado;

    public Paquete() {
        this.tracking = generarTracking();
    }

    public Paquete(String tracking, float peso, String tamanio, String cliente, String sucursalOrigen, String sucursalDestino, String direccion, EstadoPaquete estado) {
        this.tracking = tracking;
        this.peso = peso;
        this.tamanio = tamanio;
        this.cliente = cliente;
        this.sucursalOrigen = sucursalOrigen;
        this.sucursalDestino = sucursalDestino;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    private String generarTracking() {
        // Generar un número de tracking de 7 dígitos
        return String.format("%07d", (int)(Math.random() * 10000000));
    }

    // Método para obtener el estado actual del paquete
    public EstadoPaquete obtenerEstadoActual() {
        return this.estado;
    }

    // Método para cambiar el estado del paquete (puede hacerse protected)
    public void cambiarEstado(EstadoPaquete nuevoEstado) {
        this.estado = nuevoEstado;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
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

    public EstadoPaquete getEstado() {
        return estado;
    }

    // Métodos getter y setter
    public void setEstado(EstadoPaquete estado) {
        this.estado = estado;
    }

    /*
    public String getDescripcionCompleta() {
    return String.format("Paquete[Tracking: %s, Peso: %.2f kg, Tamaño: %s, Cliente: %s, Sucursal Origen: %s, Sucursal Destino: %s, Dirección: %s, Estado: %s]",
    tracking, peso, tamanio, cliente, sucursalOrigen, sucursalDestino, direccion, estado);
    }
     */
    @Override
    public String toString() {
        return "Paquete{" + "tracking=" + tracking + ", peso=" + peso + ", tamanio=" + tamanio + ", cliente=" + cliente + ", sucursalOrigen=" + sucursalOrigen + ", sucursalDestino=" + sucursalDestino + ", direccion=" + direccion + ", estado=" + estado + '}';
    }
    
    
}
