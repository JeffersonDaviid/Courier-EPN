package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Entregado;
import BL.GestionPaquete.Paquete;
import BL.Transporte.Camion;
import BL.Transporte.GestorTransporte;

public class Transportista extends Perfil {

    public Transportista(String nombre, String apellido, String cedula, String correo, String contrasena) {
        super(nombre, apellido, cedula, correo, contrasena);
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
        if(!verificarPaquete(paquete)){
            JOptionPane.showMessageDialog(null, "El paquete no se encuentra asignado a este transportista.");
            return;
        }
        paquete.setEstado(new Entregado(paquete));
        inventario.saveInventario();
        Camion camion = GestorTransporte.getInstancia().consultarCamionAsignado(this);
        GestorTransporte.getInstancia().eliminarPaqueteAsignado(camion, idPaquete);
    }
}
