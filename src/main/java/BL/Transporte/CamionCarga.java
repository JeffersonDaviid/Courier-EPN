package BL.Transporte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BL.Almacenamiento.Registro;
import BL.Almacenamiento.TipoRegistro;
import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;
public class CamionCarga extends Vehiculo {
    public String ubicacion;
    List<Paquete> PaquetesInventario;

    

    public CamionCarga(String modelo, String marca, int capacidadCarga, int disponibilidad, List<Paquete> paquetes,
            Ruta ruta, String ubicacion, List<Paquete> paquetesInventario) {
        super(modelo, marca, capacidadCarga, disponibilidad, paquetes, ruta);
        this.ubicacion = ubicacion;
        PaquetesInventario = paquetesInventario;
    }

    public ArrayList<Paquete> getIdPaquetesAlmacenados() {
        ArrayList<Paquete> paquetesInventario= new ArrayList<>();
        String sql = "SELECT idPaquete FROM Paquete WHERE estado = 'En bodega' AND domicilio = 'NO'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);
    
            while (rs.next()) {
                int idPaquete = rs.getInt("idPaquete");
                float peso = rs.getFloat("peso");
                String tamanio = rs.getString("tamanio");
                String fechaHoraLlegada = rs.getString("fechaHoraLlegada");
                String fechaHoraSalida = rs.getString("fechaHoraSalida");
                String nombreRemitente = rs.getString("nombreRemitente");
                String correoRemitente = rs.getString("correoRemitente");
                String telefonoRemitente = rs.getString("telefonoRemitente");
                String nombreDestinatario = rs.getString("nombreDestinatario");
                String correoDestinatario = rs.getString("correoDestinatario");
                String telefonoDestinatario = rs.getString("telefonoDestinatario");
                String tipoEnvio = rs.getString("tipoEnvio");
                String sucursalAceptoPaquete = rs.getString("sucursalAceptoPaquete");
                String sucursalParaRecoger = rs.getString("sucursalParaRecoger");
                float precio = rs.getFloat("precio");
                String trackingNumber = rs.getString("trackingNumber");
                String estado = rs.getString("estado");
                
                paquetesInventario.add(new Paquete(idPaquete, peso, tamanio, fechaHoraLlegada, 
                fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario,
                correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger, trackingNumber, estado, precio, "NO"));
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        
        return paquetesInventario;
    }

    //Metodo que registra un paquete que se ha recibido la agencia
    public void registrarPaquete(String idPaquete){
        Paquete paquete = obtenerPaquete(idPaquete);
        int capacidadPaquete = clasificarCapacidad(paquete.getTamanio());
        //Si no hay espacio para ingresar el paquete, se notifica y termina elmetodo
        if(!hayEspacioSuficiente(capacidadPaquete)){
            notificarCapacidadCompleta();
            return;
        }
        //Si existe espacio suficiente, se ingresa a la bodega y se crea el registro
        paquetes.put(Integer.parseInt(idPaquete), paquete);
        historial.registrarRegistro(new Registro(getFecha(),getHora(),getAgencia(),idPaquete,TipoRegistro.INGRESO));
        JOptionPane.showMessageDialog(null, "registrado con éxito", "Registro",JOptionPane.INFORMATION_MESSAGE);
        actualizarBodega(capacidadPaquete);
        //Cambiar estado del paquete a "En bodega"
        actualizarEstadoPaquete(idPaquete,"En Bodega");
        }


    public  ArrayList<Paquete> getIdPaquetesCargados() {
        ArrayList<Paquete> paquetesCamionCarga = new ArrayList<>();
        String sql = "SELECT idPaquete FROM Paquete WHERE estado = 'Transportandose' AND domicilio = 'NO'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);

            while (rs.next()) {
                int idPaquete = rs.getInt("idPaquete");
                float peso = rs.getFloat("peso");
                String tamanio = rs.getString("tamanio");
                String fechaHoraLlegada = rs.getString("fechaHoraLlegada");
                String fechaHoraSalida = rs.getString("fechaHoraSalida");
                String nombreRemitente = rs.getString("nombreRemitente");
                String correoRemitente = rs.getString("correoRemitente");
                String telefonoRemitente = rs.getString("telefonoRemitente");
                String nombreDestinatario = rs.getString("nombreDestinatario");
                String correoDestinatario = rs.getString("correoDestinatario");
                String telefonoDestinatario = rs.getString("telefonoDestinatario");
                String tipoEnvio = rs.getString("tipoEnvio");
                String sucursalAceptoPaquete = rs.getString("sucursalAceptoPaquete");
                String sucursalParaRecoger = rs.getString("sucursalParaRecoger");
                float precio = rs.getFloat("precio");
                String trackingNumber = rs.getString("trackingNumber");
                String estado = rs.getString("estado");
                paquetesCamionCarga.add(new Paquete(idPaquete, peso, tamanio, fechaHoraLlegada,
                        fechaHoraSalida, nombreRemitente, correoRemitente, telefonoRemitente, nombreDestinatario,
                        correoDestinatario, telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger,
                        trackingNumber, estado, precio, "NO"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paquetesCamionCarga;
    }

}
