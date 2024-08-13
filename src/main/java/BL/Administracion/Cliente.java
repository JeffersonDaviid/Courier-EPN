package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Inventario;
import BL.GestionPaquete.Conflicto;
import BL.GestionPaquete.Paquete;
import BL.Soporte.DanadoProblema;
import BL.Soporte.EquivocadoProblema;
import BL.Soporte.ExtraviadoProblema;
import BL.Soporte.GestorProblema;
import BL.Soporte.Problema;
import BL.Soporte.RetrasoProblema;

public class Cliente extends Perfil {
    ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);
    }
    
    public ArrayList<Paquete> obtenerPaquetes(){
        paquetes = new ArrayList<Paquete>();
        paquetes = Inventario.getInstancia().getPaquetesDeCliente(this.cedula);
        if(paquetes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encontraron paquetes asociados a este cliente.");
        }
        return paquetes;
    }

    public Paquete obtenerPaquete(String idPaquete) {
        for (Paquete paquete : paquetes) {
            if(paquete.getTracking().equals(idPaquete)){
                return paquete;
            }
        }
        return null;
    }

    @Override
    public void reportarProblema(String idPaquete, String problema) {
        Paquete paquete = obtenerPaquete(idPaquete);
        Problema problemaReportado = null;
        if(paquete==null){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
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
