package BL.Administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;

public class Cliente extends Perfil {

    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);
    }
    
    public ArrayList<Paquete> obtenerPaquetesCliente(String cedula){
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
        if(paquete==null){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
    }

    
}
