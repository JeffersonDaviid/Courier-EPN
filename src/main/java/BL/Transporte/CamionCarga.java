package BL.Transporte;

import java.util.List;

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

    // public void registrarCamion(CamionCarga camionCarga) {
    // int rs = -1;
    // String sql = "INSERT INTO Camiones (modelo, marca, capacidadCarga,
    // disponibilidad, ruta_id) VALUES ('"
    // + vehiculo.getModelo() + "', '" + vehiculo.getMarca() + "', '"
    // + vehiculo.getCapacidadCarga() + "', '" + vehiculo.getDisponibilidad() + "',
    // '"
    // + vehiculo.getRuta() + "')";

    // try {
    // rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

    // if (rs > 0) {
    // JOptionPane.showMessageDialog(null, "Camión registrado con éxito",
    // "Guardado",
    // JOptionPane.INFORMATION_MESSAGE);
    // } else {
    // JOptionPane.showMessageDialog(null, "Error al registrar el camión", "Error",
    // JOptionPane.ERROR_MESSAGE);
    // }

    // } catch (SQLException e) {
    // JOptionPane.showMessageDialog(null, "Error al registrar el camión: " +
    // e.getMessage(), "Error",
    // JOptionPane.ERROR_MESSAGE);
    // }
    // }

}
