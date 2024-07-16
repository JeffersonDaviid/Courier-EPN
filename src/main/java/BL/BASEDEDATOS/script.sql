/**
 * Author:  TOMMY
 * Created: Jul 11, 2024
 */


-- ADMINISTRACION

CREATE TABLE Usuarios (
    idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    cedula TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    correo TEXT NOT NULL UNIQUE,
    contrasena TEXT NOT NULL,
    rol TEXT NOT NULL
);


-- TRANSPORTE





-- GESTION DE PAQUETES







-- FACTURACION

CREATE TABLE Facturas (
    idFactura INTEGER PRIMARY KEY AUTOINCREMENT,
    idCliente INTEGER,
    idPaquete INTEGER,
    fecha TEXT NOT NULL,
    subtotal REAL NOT NULL,
    iva REAL NOT NULL,
    total REAL NOT NULL,
    descripcionTarifa TEXT NOT NULL, 
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
);





-- ALMACENAMIENTO






-- SEGUIMIENTO DE PAQUETES






-- RECLAMOS

