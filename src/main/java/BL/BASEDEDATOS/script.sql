/**
 * Author:  TOMMY
 * Created: Jul 11, 2024
 */


-- ADMINISTRACION

CREATE TABLE Usuarios (
    cedula TEXT NOT NULL PRIMARY KEY,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    correo TEXT NOT NULL UNIQUE,
    contrasena TEXT NOT NULL,
    rol TEXT NOT NULL
);


-- TRANSPORTE





-- GESTION DE PAQUETES

CREATE TABLE Paquete (
    idPaquete INTEGER PRIMARY KEY AUTOINCREMENT,
    peso REAL,
    tamanio TEXT,
    fechaHoraLlegada TEXT,
    fechaHoraSalida TEXT,
    nombreRemitente TEXT,
    correoRemitente TEXT,
    telefonoRemitente TEXT,
    nombreDestinatario TEXT,
    correoDestinatario TEXT,
    telefonoDestinatario TEXT,
    tipoEnvio TEXT,
    sucursalAceptoPaquete TEXT,
    sucursalParaRecoger TEXT,
    trackingNumber TEXT,
    estado TEXT DEFAULT 'recibido',
    domicilio TEXT DEFAULT 'NO'
);






-- FACTURACION

CREATE TABLE Facturas (
    idFactura INTEGER PRIMARY KEY AUTOINCREMENT,
    idPaquete TEXT NOT NULL,
    correoCliente TEXT NOT NULL,
    fecha TEXT NOT NULL,
    subtotal REAL NOT NULL,
    iva REAL NOT NULL,
    ivaPorcentaje REAL NOT NULL,
    total REAL NOT NULL,
    descripcionTarifa TEXT NOT NULL, 
    FOREIGN KEY (correoCliente) REFERENCES Cliente(correoCliente),
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
);





-- ALMACENAMIENTO

CREATE TABLE Registro (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL,
    hora TEXT NOT NULL,
    sucursal TEXT NOT NULL,
    idPaquete TEXT NOT NULL,
    tipo TEXT NOT NULL
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
);


-- SEGUIMIENTO DE PAQUETES






-- RECLAMOS

