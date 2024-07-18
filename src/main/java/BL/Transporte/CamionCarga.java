package BL.Transporte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class CamionCarga extends Vehiculo {

    public String ubicacion;
    List<Paquete> PaquetesInventario;

    public CamionCarga(String modelo, String marca, int capacidadCarga, int disponibilidad, List<Paquete> paquetes,
            int ruta, String ubicacion, List<Paquete> paquetesInventario) {
        super(modelo, marca, capacidadCarga, disponibilidad, paquetes, ruta);
        this.ubicacion = ubicacion;
        PaquetesInventario = paquetesInventario;
    }

    // Método para listar los paquetes según el estado del paquete en BD
    public List<Paquete> listarPaquetesCC(String estadoPaquete) {
        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT * FROM Paquetes WHERE estado = '" + estadoPaquete + "'";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);

            while (rs.next()) {
                int id_paquete = rs.getInt("idPaquete");
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
                String trackingNumber = rs.getString("trackingNumber");
                String estado = rs.getString("estado");
                float precioEnvio = 0;
                String domicilio = rs.getString("domicilio");

                Paquete paquete = new Paquete(id_paquete, peso, tamanio, fechaHoraLlegada, fechaHoraSalida,
                        nombreRemitente,
                        correoRemitente, telefonoRemitente, nombreDestinatario, correoDestinatario,
                        telefonoDestinatario, tipoEnvio, sucursalAceptoPaquete, sucursalParaRecoger,
                        trackingNumber, estado, precioEnvio, domicilio);

                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paquetes;
    }



    // Método para cambiar el estado del paquete en BD
    public void cambiarEstadoPaqueteCC(String estadoInicial, String estadoFinal) {
        int rs = -1;
        String sql = "UPDATE Paquetes SET estado = '" + estadoFinal + "' WHERE estado = '" + estadoInicial + "'";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Estado del paquete actualizado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No existen paquetes para cargar a camión", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del paquete: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
