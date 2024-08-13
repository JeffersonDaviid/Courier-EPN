package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BL.Almacenamiento.Inventario;
import BL.Facturacion.GestorFacturas;
import BL.GestionPaquete.Conflicto;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Seguimiento;
import BL.GestionPaquete.Transportandose;
import BL.Soporte.*;
import BL.Transporte.Camion;
import BL.Transporte.GestorTransporte;

public class Recepcionista extends Perfil{
    private Paquete paqueteEnRegistro;
    private String sucursal;

    public Recepcionista(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono,
            String agencia) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);
        sucursal = agencia;
    }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario(String agencia, String contrasena, String rol, String cedula, String nombre, String apellido, String correo, String telefono) throws ClassNotFoundException {
        if(agencia == null || contrasena == null || nombre == null || rol == null || agencia.equals("") || contrasena.equals("") || nombre.equals("") || rol.equals("") || cedula.equals("") || apellido.equals("") || correo.equals("") || telefono.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario. Verificar entradas.");
            return;
        }
        switch (rol) {
            case "Transportista":
                Transportista transportista = new Transportista(nombre, apellido, cedula, correo, contrasena, telefono);
                GestorTransporte.getInstancia().agregarTransportista(transportista);
                GestorPerfiles.getInstance().registrarPerfil(transportista);
                break;
            case "Cliente":
                Cliente cliente = new Cliente(nombre, apellido, cedula, correo, contrasena, telefono);
                GestorPerfiles.getInstance().registrarPerfil(cliente);
                break;
        }
        JOptionPane.showMessageDialog(null, "Registro exitoso");
    }

    public Paquete getPaqueteEnRegistro() {
        return paqueteEnRegistro;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void registrarPaquete(String tracking, float peso, String tamanio, Cliente cliente, String sucursalOrigen, String sucursalDestino, String direccion, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String fechaSalida, Seguimiento seguimiento){
        paqueteEnRegistro = new Paquete(tracking, peso, tamanio, cliente, sucursalOrigen, sucursalDestino, direccion, nombreDestinatario, correoDestinatario, telefonoDestinatario, fechaSalida, seguimiento);
    }

    public void eliminarPaqueteRegistrado() {
        paqueteEnRegistro = null;
    }

    public void registrarPaqueteEnInventario(){
        Inventario.getInstancia().agregarPaquete(paqueteEnRegistro);
        Inventario.getInstancia().saveInventario();
    }

    public float previsualizarPrecioPaquete(){
        float precio = GestorFacturas.getInstancia().geFactura().getPrecio().calcularPrecio(paqueteEnRegistro);
        return precio;
    }

    public void generarFactura(){
        GestorFacturas.getInstancia().generarFactura(paqueteEnRegistro);
    }

    public void asignarTransportistaACamion(String cedula, String placa){
        Transportista transportista = GestorTransporte.getInstancia().obtenerTransportistaPorCedula(cedula);
        Camion camion = GestorTransporte.getInstancia().obtenerCamionPorPlaca(placa);
        GestorTransporte.getInstancia().asignarTransportistaACamion(transportista, camion);
    }
    
    public boolean asignarPaqueteACamion(String placa, String destino){
        Camion camion = GestorTransporte.getInstancia().obtenerCamionPorPlaca(placa);
        return GestorTransporte.getInstancia().asignarPaqueteACamion(camion, destino);
    }

    public ArrayList<Paquete> obtenerPaquetes() {
        return Inventario.getInstancia().getPaquetesInventario();
    }

    public void agregarCamion(String placa, String modelo, String marca, boolean disponibilidad,
    String ubicacionProvincia) {
        GestorTransporte.getInstancia().registrarCamion(placa, modelo, marca, disponibilidad, ubicacionProvincia);
    }

    public void eliminarCamion(Camion camion) {
        GestorTransporte.getInstancia().eliminarCamion(camion);
    }

    public void eliminarTransportista(String cedula) throws ClassNotFoundException {
        GestorTransporte.getInstancia().eliminarTransportista((Transportista)GestorPerfiles.getInstance().obtenerTransportistaPorCedula(cedula));
    }

    public void eliminarCamionDeTranportista(String placa){
        Camion camion = GestorTransporte.getInstancia().obtenerCamionPorPlaca(placa);
        GestorTransporte.getInstancia().eliminarCamionDeTransportista(camion);
    }

    public Camion consultarCamionAsignadoTransportista(String cedula){
        Transportista transportista = GestorTransporte.getInstancia().obtenerTransportistaPorCedula(cedula);
        return GestorTransporte.getInstancia().consultarCamionAsignado(transportista);
    }

    public ArrayList<Paquete> consultarAsignacionPaquetesTransportista(String cedula){
        Transportista transportista = GestorTransporte.getInstancia().obtenerTransportistaPorCedula(cedula);
        return GestorTransporte.getInstancia().consultarAsignacionPaquetes(transportista);
    }

    public DefaultTableModel mostrarPaquetes(int index){
        return Inventario.getInstancia().mostrarPaquetes(index);
    }

    public DefaultTableModel mostrarHistorial(int index, String filtro){
        return Inventario.getInstancia().getHistorial().mostrarHistorial(index, filtro);
    }
    
    public Seguimiento consultarSeguimientoPaquete(String idPaquete){
        Paquete paquete = obtenerPaquete(idPaquete);
        if(paquete==null){
            return null;
        }
        return paquete.getSeguimiento();
    }

    @Override
    public void reportarProblema(String idPaquete, String problema) {
        Paquete paquete = obtenerPaquete(idPaquete);
        Problema problemaReportado = null;
        if(paquete==null||(paquete.getEstado() instanceof Transportandose)){
            JOptionPane.showMessageDialog(null, "Este reporte esta fuera de su jurisdiccion");
            return;
        }
        paquete.setEstado(new Conflicto(paquete));
        Inventario.getInstancia().notificarCambioEstado(idPaquete);
        Inventario.getInstancia().saveInventario();
        switch (problema.toLowerCase()){
            case "dañado":
                problemaReportado = new DanadoProblema();
                break;
            case "equivocado":
                problemaReportado = new EquivocadoProblema();
                break;
            case "extraviado":
                problemaReportado = new ExtraviadoProblema();
                break;
            case "retraso":
                problemaReportado = new RetrasoProblema();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Problema no reconocido");
                return;
        }
        GestorProblema gestorProblema = new GestorProblema(paquete, problemaReportado);
        gestorProblema.solucionarReclamo();
    }

    
}
