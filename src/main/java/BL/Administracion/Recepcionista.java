package BL.Administracion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.Facturacion.Factura;
import BL.GestionPaquete.Paquete;
import BL.Transporte.Camion;
import BL.Transporte.GestorTransporte;
import BL.Transporte.Ubicacion;

public class Recepcionista extends Perfil{
    private Paquete paqueteEnRegistro;
    private Ubicacion sucursal;
    private GestorTransporte transporte;
    private Factura facturacion;

    public Recepcionista(String nombre, String apellido, String cedula, String correo, String contrasena,
            Ubicacion agencia) {
        super(nombre, apellido, cedula, correo, contrasena);
        sucursal = agencia;
        transporte = GestorTransporte.getInstancia();
        facturacion = Factura.getIntancia();
    }

    public void registrarPaquete(Paquete paquete){
        paqueteEnRegistro = paquete;
        //Inventario.obtenerInstancia().agregarPaquete(paquete);
    }

    public void eliminarPaqueteRegistrado() {
        paqueteEnRegistro = null;
    }

    public void registrarPaqueteEnInventario(){
        inventario.agregarPaquete(paqueteEnRegistro);
    }

    public void consultarSeguimientoPaquete(String idPaquete){
        //Logica para llamar a Seguimiento
    }

    public float previsualizarPrecioPaquete(){
        float precio = facturacion.getPrecio().calcularPrecio(paqueteEnRegistro);
        return precio;
    }

    public void generarFactura(){
        facturacion.generarFactura(paqueteEnRegistro);
    }

    public void asignarTransportistaACamion(Transportista transportista, Camion camion){
        transporte.asignarTransportistaACamion(transportista, camion);
    }
    
    public boolean asignarPaqueteACamion(Camion camion, Ubicacion destino){
        return transporte.asignarPaqueteACamion(camion, destino);
    }

    public ArrayList<Paquete> obtenerPaquetes() {
        return inventario.getPaquetesInventario();
    }

    // public void eliminarPaqueteInventario(Paquete paquete) {
    //     inventario.eliminarPaquete(paquete);
    // }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario(String agencia, String contrasena, String rol, String cedula, String nombre, String apellido, String correo) throws ClassNotFoundException {
        if(agencia == null || contrasena == null || nombre == null || rol == null || agencia.equals("") || contrasena.equals("") || nombre.equals("") || rol.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario. Verificar entradas.");
            return;
        }
        GestorPerfiles gestorPerfiles = GestorPerfiles.getInstance();
        switch (rol) {
            case "Transportista":
                Transportista transportista = new Transportista(nombre, apellido, cedula, correo, contrasena);
                GestorTransporte.getInstancia().agregarTransportista(transportista);
                gestorPerfiles.registrarPerfil(transportista);
                break;
            case "Cliente":
                Cliente cliente = new Cliente(nombre, apellido, cedula, correo, contrasena);
                gestorPerfiles.registrarPerfil(cliente);
                break;
        }
        JOptionPane.showMessageDialog(null, "Registro exitoso");
    }

    public void agregarCamion(String placa, String modelo, String marca, boolean disponibilidad,
    Ubicacion ubicacionProvincia) {
        transporte.registrarCamion(placa, modelo, marca, disponibilidad, ubicacionProvincia);
    }

    public void eliminarCamion(int idCamion) {
        transporte.eliminarCamion(idCamion);
    }

    public void eliminarTransportista(String cedula) throws ClassNotFoundException {
        transporte.eliminarTransportista((Transportista)GestorPerfiles.getInstance().obtenerTransportistaPorCedula(cedula));
    }
    
    public Paquete getPaqueteEnRegistro() {
        return paqueteEnRegistro;
    }

    public Ubicacion getSucursal() {
        return sucursal;
    }

    public void setSucursal(Ubicacion sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public void reportarProblema(Paquete paquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    
}
