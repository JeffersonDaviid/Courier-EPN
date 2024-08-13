package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Conflicto;
import BL.GestionPaquete.Paquete;
import BL.Soporte.DanadoProblema;
import BL.Soporte.EquivocadoProblema;
import BL.Soporte.ExtraviadoProblema;
import BL.Soporte.GestorProblema;
import BL.Soporte.Problema;
import BL.Soporte.RetrasoProblema;

public class Cliente extends Perfil {

    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);
    }
    
    public ArrayList<Paquete> obtenerPaquetes(String cedula){
        ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
        paquetes = inventario.getPaquetesDeCliente(cedula);
        for(Paquete paquete: paquetes){
            if(paquete.getCliente().getCedula().equals(this.getCedula())){
                paquetes.add(paquete);
            }
        }
        return paquetes;
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
        GestorProblema gestorProblema = new GestorProblema(paquete, problemaReportado);
        gestorProblema.solucionarReclamo();
    }

    
}
