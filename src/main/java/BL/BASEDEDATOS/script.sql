/**
 * Author:  TOMMY
 * Created: Jul 11, 2024
 */


-- ADMINISTRACION




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

