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
    agencia TEXT NOT NULL
);

DROP TABLE VEHICULOS;

-- TRANSPORTE
CREATE TABLE Camiones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    modelo TEXT,
    marca TEXT,
    capacidadCarga INTEGER,
    disponibilidad INTEGER, -- Usaremos 0 para FALSE y 1 para TRUE
    agencia TEXT NOT NULL
);

INSERT INTO Camiones (modelo, marca, capacidadCarga, disponibilidad, agencia) VALUES ('Camioneta', 'Toyota', 1000, 1, 'San Jose');
INSERT INTO Camiones (modelo, marca, capacidadCarga, disponibilidad, agencia) VALUES ('Carro', 'Toyota', 2000, 2, 'San Jose');
DROP TABLE RUTAS;


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
    domicilio TEXT DEFAULT 'NO'
);

CREATE TABLE Estado (
    idEstado INTEGER PRIMARY KEY AUTOINCREMENT,
    idPaquete INTEGER NOT NULL,
    estado TEXT NOT NULL,
    fecha TEXT NOT NULL, /* Fecha y hora */
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
);





-- FACTURACION

CREATE TABLE Facturas (
    idFactura INTEGER PRIMARY KEY AUTOINCREMENT,
    idPaquete INTEGER NOT NULL,
    cedulaCliente TEXT NOT NULL,
    fecha TEXT NOT NULL,
    subtotal REAL NOT NULL,
    iva REAL NOT NULL,
    ivaPorcentaje REAL NOT NULL,
    total REAL NOT NULL,
    descripcionTarifa TEXT NOT NULL, 
    agencia TEXT NOT NULL
    FOREIGN KEY (cedulaCliente) REFERENCES Cliente(cedulaCliente),
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
    
);





-- ALMACENAMIENTO

CREATE TABLE Registro (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    idPaquete TEXT NOT NULL,
    fecha TEXT NOT NULL,
    hora TEXT NOT NULL,
    sucursal TEXT NOT NULL,
    tipo TEXT NOT NULL
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete)
);


-- SEGUIMIENTO DE PAQUETES
CREATE TABLE Envio (
    idEnvio INTEGER PRIMARY KEY AUTOINCREMENT,
    idPaquete INTEGER NOT NULL,
    idTransporte INTEGER NOT NULL,
    FOREIGN KEY (idPaquete) REFERENCES Paquete(idPaquete),
    FOREIGN KEY (idTransporte) REFERENCES Transporte(idTransporte)
);





-- RECLAMOS

