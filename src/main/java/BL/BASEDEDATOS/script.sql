/**
 * Author:  TOMMY
 * Created: Jul 11, 2024
 */



CREATE TABLE
    MascotaTipo (
        idMascotaTipo INTEGER PRIMARY KEY AUTOINCREMENT,
        Nombre VARCHAR(10) NOT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT('A')
    );
