package BL.Administracion;

import javax.swing.JOptionPane;

public class Usuario {

    private String nombre;
    private String contrasena;
    private String agencia;

    public Usuario(String nombre, String contrasena, String agencia) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.agencia = agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public static boolean login(String agencia, String user, String pass, String rol){
         if (agencia.equals("") || agencia.equals(null) || agencia == null || user.equals("") || user.equals(null)
                || user == null || pass.equals("") || pass.equals(null) || pass == null || rol.equals("")
                || rol.equals(null) || rol == null) {
            return false;
        }
        Usuario usuario = null;
        usuario = GlobalPerfil.getInstancia().loginPerfil(user, pass, rol);
        
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return false;
        }

        return true;
    }

}
