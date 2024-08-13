package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Entregado;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Transportandose;
import BL.Transporte.Camion;
import BL.Transporte.GestorTransporte;

public class Transportista extends Perfil {

    public Transportista(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);
        //TODO Auto-generated constructor stub
    }

    public ArrayList<Paquete> consultarAsignacionPaquetes(){
        return GestorTransporte.getInstancia().consultarAsignacionPaquetes(this);
    }

    public boolean verificarPaquete(Paquete paquete){
        ArrayList<Paquete> paquetes = consultarAsignacionPaquetes();
        for (Paquete p : paquetes) {
            if (p.getTracking().equals(paquete.getTracking())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void reportarProblema(String idPaquete, String problema) {
        Paquete paquete = obtenerPaquete(idPaquete);
        if(paquete==null||!(paquete.getEstado() instanceof Transportandose)){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
    }

    public void entregarPaquete(String idPaquete){
        Paquete paquete = inventario.buscarPaquete(idPaquete);
        if(paquete==null){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
        if(!verificarPaquete(paquete)){
            JOptionPane.showMessageDialog(null, "El paquete no se encuentra asignado a este transportista.");
            return;
        }
        paquete.setEstado(new Entregado(paquete));
        inventario.notificarCambioEstado(idPaquete);
        Camion camion = GestorTransporte.getInstancia().consultarCamionAsignado(this);
        GestorTransporte.getInstancia().eliminarPaqueteAsignado(camion, idPaquete);
    }
}
