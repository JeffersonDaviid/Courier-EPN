package BL.Transporte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import BL.BASEDEDATOS.DataHelper;
import BL.GestionPaquete.Paquete;

public class Vehiculo {
    private String modelo;
    private String marca;
    private int capacidadCarga;
    private int disponibilidad;
    private List<Paquete> paquetesCamionCarga;
    private Ruta ruta;

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
        String sql = "INSERT INTO Vehiculo (modelo, marca, capacidadCarga, disponibilidad, ruta) VALUES ('"
            + vehiculo.getModelo() + "', '" + vehiculo.getMarca() + "', '"
            + vehiculo.getCapacidadCarga() + "', '" + vehiculo.getDisponibilidad() + "', '" + vehiculo.getRuta().getSector() + "' , '" + vehiculo.getRuta().getDireccion() + "')";

        try {
            rs = DataHelper.getInstancia().executeQueryInsertUpdateDelete(sql);

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Camión registrado con éxito", "Guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el camión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el camión: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verificarDisponibilidad() {
        if (disponibilidad == 0) {
            JOptionPane.showMessageDialog(null, "El vehículo no está disponible");
        }
    }

    // Método para obtener información del paquete
    public List<Paquete> obtenerInformacionPaquetes() {
        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT * FROM Paquete WHERE estado = 'En bodega'";
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
                float precioEnvio = rs.getFloat("precioEnvio");
                String domicilio = rs.getString("domicilio");

                Paquete paquete = new Paquete(id_paquete, peso, tamanio, fechaHoraLlegada, fechaHoraSalida, nombreRemitente,
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
    
    public boolean verificarTablaPaquete() {
        boolean tablaExiste = false;
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='Paquete';";
        try {
            DataHelper dataHelper = DataHelper.getInstancia();
            ResultSet rs = dataHelper.executeQueryRead(sql);
            if (rs.next()) {
                tablaExiste = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tablaExiste;
    }

public static void main(String[] args) {
    // Crear una ruta de ejemplo
    Ruta ruta = new Ruta("Sector Ejemplo", "Dirección Ejemplo");

    // Crear un vehículo de ejemplo con una lista vacía de paquetes
    Vehiculo vehiculo = new Vehiculo("Modelo Ejemplo", "Marca Ejemplo", 1000, 1, null, ruta);

    // Verificar si la tabla Paquete existe
    if (!vehiculo.verificarTablaPaquete()) {
        System.out.println("La tabla 'Paquete' no existe en la base de datos.");
        return;
    }

    // Obtener la lista de paquetes
    List<Paquete> paquetes = vehiculo.obtenerInformacionPaquetes();

    // Imprimir la información de los paquetes
    for (Paquete paquete : paquetes) {
        System.out.println("ID Paquete: " + paquete.getId_paquete());
        System.out.println("Peso: " + paquete.getPeso());
        System.out.println("Tamaño: " + paquete.getTamanio());
        System.out.println("Fecha Hora Llegada: " + paquete.getFechaHoraLlegada());
        System.out.println("Fecha Hora Salida: " + paquete.getFechaHoraSalida());
        System.out.println("Nombre Remitente: " + paquete.getNombreRemitente());
        System.out.println("Correo Remitente: " + paquete.getCorreoRemitente());
        System.out.println("Teléfono Remitente: " + paquete.getTelefonoRemitente());
        System.out.println("Nombre Destinatario: " + paquete.getNombreDestinatario());
        System.out.println("Correo Destinatario: " + paquete.getCorreoDestinatario());
        System.out.println("Teléfono Destinatario: " + paquete.getTelefonoDestinatario());
        System.out.println("Tipo Envío: " + paquete.getTipoEnvio());
        System.out.println("Sucursal Aceptó Paquete: " + paquete.getSucursalAceptoPaquete());
        System.out.println("Sucursal Para Recoger: " + paquete.getSucursalParaRecoger());
        System.out.println("Tracking Number: " + paquete.getTrackingNumber());
        System.out.println("Estado: " + paquete.getEstado());
        System.out.println("Domicilio: " + paquete.getDomicilio());
        System.out.println("=====================================");
    }
}

}
