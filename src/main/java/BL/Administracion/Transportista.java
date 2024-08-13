package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Conflicto;
import BL.GestionPaquete.Entregado;
import BL.GestionPaquete.Paquete;
import BL.GestionPaquete.Transportandose;
import BL.Soporte.DanadoProblema;
import BL.Soporte.EquivocadoProblema;
import BL.Soporte.ExtraviadoProblema;
import BL.Soporte.Gestor_Problema;
import BL.Soporte.Problema;
import BL.Soporte.RetrasoProblema;
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
        Problema problemaReportado = null;
        if(paquete==null||!(paquete.getEstado() instanceof Transportandose)){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
        if(!verificarPaquete(paquete)){
            JOptionPane.showMessageDialog(null, "El paquete no se encuentra asignado a su camión.");
            return;
        }
        paquete.setEstado(new Conflicto(paquete));
        inventario.notificarCambioEstado(idPaquete);
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
        Gestor_Problema gestor_Problema = new Gestor_Problema(paquete, problemaReportado);
    }

    public void registrarEntregaPaquete(String idPaquete){
        Paquete paquete = inventario.buscarPaquete(idPaquete);
        if(paquete==null){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
        if(!verificarPaquete(paquete)){
            JOptionPane.showMessageDialog(null, "El paquete no se encuentra asignado a su camión.");
            return;
        }
        paquete.setEstado(new Entregado(paquete));
        inventario.notificarCambioEstado(idPaquete);
        Camion camion = GestorTransporte.getInstancia().consultarCamionAsignado(this);
        GestorTransporte.getInstancia().eliminarPaqueteAsignado(camion, idPaquete);
    }
}
