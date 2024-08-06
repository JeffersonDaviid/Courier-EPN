package com.proyecto.courierepn;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import BL.Administracion.Administrador;
import BL.Administracion.Global;
import BL.Administracion.GlobalPerfil;
import BL.Administracion.Usuario;
import BL.Almacenamiento.Inventario;
import BL.Facturacion.Factura;
import BL.Facturacion.Tarifa;
import BL.Facturacion.TarifaEnvio;
import BL.GestionPaquete.Paquete;
import BL.Seguimiento.Seguimiento;
import BL.Transporte.CamionCarga;
import BL.Transporte.CamionEntrega;
import UI.Administracion.LoginUI;
import UI.Almacenamiento.InventarioUI;

public class CourierEPN {

    static Usuario usuario = null;

    public static void main(String[] args) throws Exception {
        FlatMaterialLighterIJTheme.setup();
        new LoginUI().setVisible(true);
        //loginConsola();

    }

    public static void loginConsola() {
        int opcion = 0;
        String idPaquete = "";

        while (/*login()*/ true) {

            while (opcion != -1) {

                String mensaje = "Bienvenid@, AGENCIA " + (Global.agenciaActual).toUpperCase()
                        + "\n\n1. Registrar paquete en recepcion"
                        + "\n2. Mostrar paquetes en recepción"
                        + "\n3. Registrar paquetes en inventario"
                        + "\n4. Mostrar paquetes en inventario"
                        + "\n5. Organizar paquetes"
                        + "\n6. Cargar paquetes a camion de carga"
                        + "\n7. Descargar paquetes en bodega agencia destino"
                        + "\n8. Cargar paquetes en camion de entrega"
                        + "\n9. Entregar paquete desde camion"
                        + "\n10. Entregar paquete desde recepcion"
                        + "\n11. Seguimiento del paquete"
                        + "\n12. Mostrar Historial"
                        + "\n13. Consultar Historial por ID"
                        + "\n14. Consultar Historial por Fingreso"
                        + "\n15. Consultar Historial por FSalida"
                        + "\n16. Ingresar nuevo usuario"
                        + "\n17. Agregar nuevo camión de carga"
                        + "\n18. Agregar nuevo camión de entrega"
                        + "\n19. Mostrar camiones registrados"
                        + "\n0. Salir"
                        + "\nIngrese una opción: ";

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                switch (opcion) {
                    case 0:
                        opcion = -1;
                        break;

                    case 1:
                        String id = JOptionPane.showInputDialog("ingrese id del paquete");
                        String ciudadOrigen = JOptionPane.showInputDialog("ingrese agencia remitente del paquete");
                        String ciudadDestino = JOptionPane.showInputDialog("ingrese agencia destino del paquete");
                        String domicilio = JOptionPane.showInputDialog("ingrese domicilio del paquete");
                        float peso = Float.parseFloat(JOptionPane.showInputDialog("ingrese peso del paquete"));
                        String tamanio = JOptionPane.showInputDialog("ingrese tamaño del paquete");

                        if (domicilio.equals("") || domicilio.equals(null) || domicilio == null) {
                            domicilio = null;
                        }

                        // Paquete p = new Paquete(id, ciudadOrigen, ciudadDestino, domicilio, peso,
                        // tamanio);
                        Paquete p = new Paquete(id, peso, tamanio, ciudadOrigen, ciudadDestino, "Pepe", "correo@epn",
                                "099",
                                "Juan", "juan@gmail", "09952", domicilio, "12/05/52");

                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion().agregarPaquete(p);

                        Tarifa t = new TarifaEnvio();
                        t.calcularPrecio(p);

                        if (p.getDomicilio() != null) {
                            t = new TarifaEnvio();
                            t.calcularPrecio(p);
                        }

                        break;

                    case 2:
                        mostrarPaquetes(Global.getInstancia().buscarAgencia(Global.agenciaActual).getRecepcion()
                                .getPaquetesRecepcion(), "Recepcion");
                        break;

                    case 3:
                    /*
                        InventarioUI inventario = new InventarioUI();
                        inventario.show();
                     */
                        idPaquete = JOptionPane.showInputDialog("ingrese id del paquete");
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .agregarPaqueteDeRecepcion(idPaquete);
                        break;

                    case 4:
                        mostrarPaquetes(Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .getPaquetesInventario(), "Inventario");
                        break;

                    case 5:
                        idPaquete = JOptionPane.showInputDialog("ingrese id del paquete");
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .organizarPaquetes(idPaquete);
                        break;

                    case 6:
                        idPaquete = JOptionPane.showInputDialog("Ingrese id del paquete");
                        CamionCarga camionCarga = Global.getInstancia().buscarAgencia(Global.agenciaActual)
                                .getCamionCarga();
                        if (camionCarga != null) {
                            camionCarga.cargarPaquete(idPaquete);
                            mostrarPaquetes(camionCarga.getPaquetesCamion(), "Camión de carga");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay camiones de carga disponibles.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 7:
                        camionCarga = Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionCarga();
                        if (camionCarga != null) {
                            //camionCarga.descargarPaquete();
                            mostrarPaquetes(camionCarga.getPaquetesCamion(), "Camión de carga");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay camiones de carga disponibles.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 8:
                        idPaquete = JOptionPane.showInputDialog("Ingrese id del paquete");
                        CamionEntrega camionEntrega = Global.getInstancia().buscarAgencia(Global.agenciaActual)
                                .getCamionEntrega();
                        if (camionEntrega != null) {
                            camionEntrega.cargarPaquete(idPaquete);
                            mostrarPaquetes(camionEntrega.getPaquetesCamion(), "Camión de entrega");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay camiones de entrega disponibles.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 9:
                        idPaquete = JOptionPane.showInputDialog("Ingrese id del paquete");
                        camionEntrega = Global.getInstancia().buscarAgencia(Global.agenciaActual).getCamionEntrega();
                        if (camionEntrega != null) {
                            camionEntrega.entregarPaquete(idPaquete);
                            mostrarPaquetes(camionEntrega.getPaquetesCamion(), "Camión de entrega");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay camiones de entrega disponibles.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 10:
                        idPaquete = JOptionPane.showInputDialog("ingrese id del paquete");
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .entregarPaquete(idPaquete);

                        mostrarPaquetes(
                                Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                        .getPaquetesInventario(),
                                "Inventario");
                        break;

                    case 11:
                        idPaquete = JOptionPane.showInputDialog("ingrese id del paquete");
                        String destino = JOptionPane.showInputDialog("ingrese agencia destino del paquete");
                        Seguimiento s = new Seguimiento();
                        s.verEstadoPaquete(idPaquete, destino);
                        break;/* 
                    case 12:
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario().consultarHistorial();
                        break;
                    case 13:
                        String idParaHistorial = JOptionPane.showInputDialog("ingrese id del paquete");
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .consultarPorID(idParaHistorial);
                        break;
                    case 14:
                        String fechaIng = JOptionPane.showInputDialog("ingrese la fecha de ingreso");
                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .consultarPorFechaIngreso(fechaIng);
                        break;
                    case 15:
                        String fechaSal = JOptionPane.showInputDialog("ingrese la fecha de salida");

                        Global.getInstancia().buscarAgencia(Global.agenciaActual).getInventario()
                                .consultarPorFechaSalida(fechaSal);
                        break;*/

                    case 16: // Nueva opción para ingresar un nuevo usuario
                        if (usuario instanceof Administrador) {
                            ((Administrador) usuario).agregarNuevoUsuario();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Solo los administradores pueden agregar nuevos usuarios.");
                        }
                        break;

                    case 17:
                        if (usuario instanceof Administrador) {
                            ((Administrador) usuario).agregarCamionCarga();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Solo los administradores pueden agregar nuevos camiones de carga.");
                        }
                        break;

                    case 18:
                        if (usuario instanceof Administrador) {
                            ((Administrador) usuario).agregarCamionEntrega();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Solo los administradores pueden agregar nuevos camiones de entrega.");
                        }
                        break;

                    case 19:
                        mostrarCamiones();
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
            opcion = 0;
        }

    }

    public static void mostrarPaquetes(ArrayList<Paquete> paquetes, String lugar) {
        String mensaje = "Lista de paquetes en " + lugar;
        for (Paquete paquete : paquetes) {
            mensaje += "\npaquete " + paquete.getId() + " destino: "
                    + paquete.getAgenciaDestino() + " remitente: " + paquete.getAgenciaOrigen() + " estado: "
                    + paquete.getHistorialEstado().get(paquete.getHistorialEstado().size() - 1).getEstado();
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static boolean login(String agencia, String user, String pass, String rol) {
        // String agencia, user, pass, rol;
        // agencia = JOptionPane.showInputDialog("Ingrese su agencia");
        // user = JOptionPane.showInputDialog("Ingrese su usuario");
        // pass = JOptionPane.showInputDialog("Ingrese su contraseña");
        // rol = JOptionPane.showInputDialog("Ingrese su rol");
        usuario = Usuario.login(agencia, user, pass, rol);
        agencia = usuario.getAgencia();
        if (usuario != null) {
            Global.agenciaActual = agencia;
            return true;
        } else {
            return false;
        }
    }

    public static void mostrarCamiones() {
        String mensajeCarga = "Camiones de carga registrados:\n";
        String mensajeEntrega = "Camiones de entrega registrados:\n";

        ArrayList<CamionCarga> camionesCarga = Global.getInstancia().buscarAgencia(Global.agenciaActual)
                .getCamionesCarga();
        ArrayList<CamionEntrega> camionesEntrega = Global.getInstancia().buscarAgencia(Global.agenciaActual)
                .getCamionesEntrega();

        if (camionesCarga.isEmpty()) {
            mensajeCarga += "No hay camiones de carga registrados.\n";
        } else {
            for (CamionCarga camion : camionesCarga) {
                mensajeCarga += "Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo() + ", Marca: "
                        + camion.getMarca() + ", Capacidad: " + camion.getCapacidadCarga() + ", Disponibilidad: "
                        + camion.getDisponibilidad() + "\n";
            }
        }

        if (camionesEntrega.isEmpty()) {
            mensajeEntrega += "No hay camiones de entrega registrados.\n";
        } else {
            for (CamionEntrega camion : camionesEntrega) {
                mensajeEntrega += "Placa: " + camion.getPlaca() + ", Modelo: " + camion.getModelo() + ", Marca: "
                        + camion.getMarca() + ", Capacidad: " + camion.getCapacidadCarga() + ", Disponibilidad: "
                        + camion.getDisponibilidad() + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, mensajeCarga + "\n" + mensajeEntrega);
    }

}