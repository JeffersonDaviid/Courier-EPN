package BL.Administracion;

import BL.GestionPaquete.Paquete;

public class Cliente extends Perfil {
    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena) {
        super(nombre, apellido, cedula, correo, contrasena);
    }

    public void consultarSeguimiento(String idPaquete){
        //Logica para llamar a Seguimiento
    }

    @Override
    public void reportarProblema(Paquete paquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    
}
