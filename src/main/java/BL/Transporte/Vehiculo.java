package BL.Transporte;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class Vehiculo {
    String modelo;
    String marca;
    int capacidadCarga;
    int disponibilidad;
    List<Paquete> paquetesCamionCarga;
    Ruta ruta;

    public Vehiculo(String modelo, String marca, int capacidadCarga, int disponibilidad, List<Paquete> paquetes, Ruta ruta) {
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.paquetesCamionCarga = paquetes;
        this.ruta = ruta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Paquete> getPaquetes() {
        return paquetesCamionCarga;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        paquetesCamionCarga = paquetes;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void registrarCamion(Vehiculo vehiculo) {
        int rs = -1;
        String sql = "INSERT INTO Vehiculo (modelo, marca, capacidadCarga, disponibilidad, ruta) VALUES ("
            + vehiculo.getModelo() + "', '" + vehiculo.getMarca() + "', '"
            + vehiculo.getCapacidadCarga() + "', '" + vehiculo.getDisponibilidad() + "', '" + vehiculo.getRuta() + "')";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Camion registrado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el camión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el camion: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    protected void verificarDisponibilidad() {
        if (!disponibilidad) {
            JOptionPane.showMessageDialog(null, "El vehiculo no esta disponible");
        }   
    }
    
}
