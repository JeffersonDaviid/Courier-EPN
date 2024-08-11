package BL.Administracion;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.Facturacion.Factura;
import BL.GestionPaquete.Paquete;

public class Recepcionista extends Perfil {
    private Paquete paqueteEnRegistro;
    private String sucursal;

    public Recepcionista(String nombre, String apellido, String cedula, String correo, String contrasena,
            String agencia) {
        super(nombre, apellido, cedula, correo, contrasena, agencia);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void reportarProblema(String idPaquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    public void registrarPaquete(Paquete paquete){
        paqueteEnRegistro = paquete;
        //Inventario.obtenerInstancia().agregarPaquete(paquete);
    }

    public void eliminarPaqueteRegistrado() {
        paqueteEnRegistro = null;
    }

    public void registrarPaqueteEnInventario(){
        if(paqueteEnRegistro == null){
            JOptionPane.showMessageDialog(null, "No se pudo registrar el paquete. Verificar entradas.");
            return;
        }
        //Inventario.obtenerInstancia().agregarPaquete(paqueteEnRegistro);
    }

    public void consultarSeguimientoPaquete(String idPaquete){
        //Logica para llamar a Seguimiento
    }

    public void previsualizarPrecioPaquete(){
        Factura.getIntancia().getPrecio().calcularPrecio(paqueteEnRegistro);
    }

    public void generarFactura(){
        Factura.getIntancia().generarFactura(paqueteEnRegistro);
    }

    public void asignarTransportistaACamion(){
        //Logica para llamar a AsignarTransportista
    }
    
    public void asignarPaqueteACamcion(){
        //Logica para llamar a AsignarPaquete
    }

    // Método para agregar un nuevo usuario a la lista
    public void registrarPerfil(String agencia, String contrasena, String rol, String cedula, String nombre, String apellido, String correo) {
        if(agencia == null || contrasena == null || nombre == null || rol == null || agencia.equals("") || contrasena.equals("") || nombre.equals("") || rol.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario. Verificar entradas.");
            return;
        }
        switch (rol) {
            case "Recepcionista":
                Recepcionista recepcionista = new Recepcionista(nombre, apellido, cedula, correo, contrasena, agencia);
                GestorPerfiles.registrarPerfil(recepcionista);
                break;
            case "Transportista":
                Transportista transportista = new Transportista(nombre, apellido, cedula, correo, contrasena, agencia);
                GestorPerfiles.registrarPerfil(transportista);
                break;
            case "Cliente":
                Cliente cliente = new Cliente(nombre, apellido, cedula, correo, contrasena, agencia);
                GestorPerfiles.registrarPerfil(cliente);
                break;
        }
        JOptionPane.showMessageDialog(null, "Registro exitoso");
    }

    // // Método para agregar un nuevo camión
    // public void agregarCamion(String placa, String modelo, String marca, String capacidadCargaStr, String disponibilidadStr) {
        
    // }
}
