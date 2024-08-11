package BL.Administracion;

public class Transportista extends Perfil {

    public Transportista(String nombre, String apellido, String cedula, String correo, String contrasena,
            String agencia) {
        super(nombre, apellido, cedula, correo, contrasena, agencia);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void reportarProblema(String idPaquete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportarProblema'");
    }

    public void consultarAsignacionPaquetes(){
        //Logica para llamar a PaquetesAsignados
    }

    public void registrarEntregaPaquete(){
        //Logica para llamar a EntregaPaquete
    }
    
    
}
