package BL.Administracion;

import BL.GestionPaquete.Paquete;
import BL.Transporte.GestorTransporte;

public class Transportista extends Perfil {

    public Transportista(String nombre, String apellido, String cedula, String correo, String contrasena) {
        super(nombre, apellido, cedula, correo, contrasena);
        //TODO Auto-generated constructor stub
    }

    public ArrayList<Paquete> consultarAsignacionPaquetes(){
        return GestorTransporte.getInstancia().consultarAsignacionPaquetes(this);
    }

    public void registrarEntregaPaquete(){
        //Logica para llamar a EntregaPaquete
    }

    @Override
    public void reportarProblema(Paquete paquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    public void entregarPaquete(String idPaquete){
        Paquete paquete = inventario.buscarPaquete(idPaquete);
        paquete.setEstado(new Entregado());
        inventario.guardarInventario();
        GestirTransporte.getInstancia().eliminarPaqueteAsignado(paquete, this);
    }
}
