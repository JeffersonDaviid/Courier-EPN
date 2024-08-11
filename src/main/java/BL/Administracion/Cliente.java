package BL.Administracion;

public class Cliente extends Perfil {
    public Cliente(String nombre, String apellido, String cedula, String correo, String contrasena) {
        super(nombre, apellido, cedula, correo, contrasena);
    }

    @Override
    public void reportarProblema(String idPaquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    public void consultarSeguimiento(String idPaquete){
        //Logica para llamar a Seguimiento
    }
    
}
