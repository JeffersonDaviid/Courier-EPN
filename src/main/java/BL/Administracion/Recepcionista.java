package BL.Administracion;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Paquete;

public class Recepcionista extends Perfil {
    private Paquete paqueteEnRegistro;
    private String sucursal;

    public Recepcionista(String nombre, String apellido, String cedula, String correo, String contrasena,
            String agencia) {
        super(nombre, apellido, cedula, correo, contrasena);
        this.sucursal = agencia;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void reportarProblema(String idPaquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    public void registrarPaquete(String id,float peso, String tamanio, String agenciaOrigen, String agenciaDestino, String nombreRemitente, String correoRemitente, String telefonoRemitente, String nombreDestinatario, String correoDestinatario, String telefonoDestinatario, String Domicilio, String fechaLlegada, String fechaSalida){
        paqueteEnRegistro = new Paquete(id, peso, tamanio, agenciaOrigen, agenciaDestino, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario, telefonoDestinatario, Domicilio, fechaLlegada, fechaSalida);
        //Inventario.obtenerInstancia().agregarPaquete(paquete);
    }

    public void eliminarPaqueteRegistrado() {
        paqueteEnRegistro = null;
    }

    public void registrarPaqueteEnInventario(){
        //Inventario.obtenerInstancia().agregarPaquete(paqueteEnRegistro);
    }

    public void consultarSeguimientoPaquete(String idPaquete){
        //Logica para llamar a Seguimiento
    }

    public void previsualizarPrecioPaquete(){
        //Logica para llamar a Precio
    }

    public void generarFactura(){
        //Logica para llamar a Factura
    }

    public void asignarTransportistaACamion(){
        //Logica para llamar a AsignarTransportista
    }
    
    public void asignarPaqueteACamcion(){
        //Logica para llamar a AsignarPaquete
    }

    // Método para agregar un nuevo usuario a la lista
    public void agregarNuevoUsuario(String agencia, String contrasena, String rol, String cedula, String nombre, String apellido, String correo) {
        if(agencia == null || contrasena == null || nombre == null || rol == null || agencia.equals("") || contrasena.equals("") || nombre.equals("") || rol.equals("")) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario. Verificar entradas.");
            return;
        }
        GestorPerfiles gestorPerfiles = GestorPerfiles.getInstance();
        switch (rol) {
            case "Recepcionista":
                Recepcionista recepcionista = new Recepcionista(nombre, apellido, cedula, correo, contrasena, agencia);
                gestorPerfiles.registrarPerfil(recepcionista);
                break;
            case "Transportista":
                Transportista transportista = new Transportista(nombre, apellido, cedula, correo, contrasena);
                gestorPerfiles.registrarPerfil(transportista);
                break;
            case "Cliente":
                Cliente cliente = new Cliente(nombre, apellido, cedula, correo, contrasena);
                gestorPerfiles.registrarPerfil(cliente);
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

    // Método para agregar un nuevo camión
    // public void agregarCamionCarga(String placa, String modelo, String marca, String capacidadCargaStr, String disponibilidadStr) {
    //     // String placa = JOptionPane.showInputDialog("Ingrese la placa:").trim();
    //     // String modelo = JOptionPane.showInputDialog("Ingrese el modelo:").trim();
    //     // String marca = JOptionPane.showInputDialog("Ingrese la marca:").trim();
    //     int capacidadCarga = 0;
    //     int disponibilidad = 0;

    //     if(placa == null || modelo == null || marca == null || capacidadCargaStr == null || disponibilidadStr == null || placa.equals("") || modelo.equals("") || marca.equals("") || capacidadCargaStr.equals("") || disponibilidadStr.equals("")) {
    //         JOptionPane.showMessageDialog(null, "No se pudo agregar el camión. Verificar entradas.");
    //         return;
    //     }

    //     try {
    //         capacidadCarga = Integer.parseInt(capacidadCargaStr);
    //         disponibilidad = Integer.parseInt(disponibilidadStr);
    //     } catch (NumberFormatException e) {
    //         JOptionPane.showMessageDialog(null, "Capacidad de carga y disponibilidad deben ser números.");
    //         return;
    //     }
    //     CamionCarga nuevoCamion = new CamionCarga(placa, modelo, marca, capacidadCarga, disponibilidad,
    //             Global.agenciaActual);
    //     Global.getInstancia().buscarAgencia(Global.agenciaActual).agregarCamionCarga(nuevoCamion);
    //     JOptionPane.showMessageDialog(null, "Camión de carga agregado exitosamente.");
    // }

    
}
