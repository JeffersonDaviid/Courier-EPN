/**
 * Author:  TOMMY
 * Created: Jul 11, 2024
 */


-- ADMINISTRACION




-- TRANSPORTE





-- GESTION DE PAQUETES







-- FACTURACION

CREATE TABLE Factura (
    id_factura INTEGER PRIMARY KEY AUTOINCREMENT,
    id_cliente INTEGER,
    fecha TEXT NOT NULL, -- Usamos TEXT para almacenar la fecha
    id_paquete INTEGER,
    costo_sin_iva REAL NOT NULL,
    iva REAL NOT NULL,
    costo_con_iva REAL NOT NULL,
    servicio_a_domicilio INTEGER NOT NULL, -- Usamos INTEGER para representar BOOLEAN (0 = false, 1 = true)
    tarifa_adicional_domicilio REAL,
    total REAL NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_paquete) REFERENCES Paquete(id_paquete)
);





-- ALMACENAMIENTO






-- SEGUIMIENTO DE PAQUETES






-- RECLAMOS

