package BL.Transporte;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public abstract class Camion implements Cloneable {

    //atributos
    private String placa;
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int disponibilidad;
    private ArrayList<Paquete> paquetesCamion = new ArrayList<>();
    private String agencia;

    //constructor
    public Camion() {
    }

    //constructor
    public Camion(String placa, String modelo, String marca, int capacidadCarga, int disponibilidad, String agencia) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.disponibilidad = disponibilidad;
        this.paquetesCamion = new ArrayList<>();
        this.agencia = agencia;
    }
    
    //metodos

    // Método para obtener la placa del camión
    public String getPlaca() {
        return placa;
    }

    // Método para obtener la agencia del camión
    public String getAgencia() {
        return agencia;
    }

    // Método para obtener el modelo del camión
    public String getModelo() {
        return modelo;
    }

    // Método para obtener la marca del camión
    public String getMarca() {
        return marca;
    }

    // Método para obtener la capacidad de carga del camión
    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    // Método para obtener la disponibilidad del camión
    public int getDisponibilidad() {
        return disponibilidad;
    }

    // Método para obtener los paquetes del camión
    public ArrayList<Paquete> getPaquetesCamion() {
        return paquetesCamion;
    }

    // Método para poner la marca del camión
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método para poner la capacidad de carga del camión
    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    // Método para poner la disponibilidad del camión
    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Método para poner la agencia del camión
    public void setPaquetesCamion(ArrayList<Paquete> paquetesCamion) {
        this.paquetesCamion = paquetesCamion;
    }

    // Método para poner la agencia del camión
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método para poner la agencia del camión
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // Método para tranformar a string 
    @Override
    public String toString() {
        return String.format(
                "Camión [Placa: %s, Modelo: %s, Marca: %s, Capacidad de Carga: %d, Disponibilidad: %d, Agencia: %s]",
                placa, modelo, marca, capacidadCarga, disponibilidad, agencia);
    }

   // Método para cambiar el estado del paquete en BD utilizando el ID del paquete
   public void cambiarEstadoPaquetePorId(String idPaquete, String estado) {
    int rs = -1;
    String sql = "INSERT INTO PaqueteEstados (idPaquete, estado, fecha) VALUES ('"
        + idPaquete + "', '" + estado + "', '" + getFecha() + "')"; // 'getFecha()' debe retornar la fecha actual

    try {
        rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

        if (rs > 0) {
            JOptionPane.showMessageDialog(null, "Estado del paquete insertado con éxito", "Guardado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el estado del paquete", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar el estado del paquete: " + e.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}



}