package BL.Administracion;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;

public class Cliente extends Perfil {

    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena, String telefono) {
        super(nombre, apellido, cedula, correo, contrasena, telefono);

    }

    @Override
    public void reportarProblema(Paquete paquete, String problema) {
        if(paquete==null){
            JOptionPane.showMessageDialog(null, "El paquete no existe.");
            return;
        }
    }

    
}
