
CREATE DATABASE viajes_db;
USE viajes_db;

CREATE TABLE Cliente (
                         id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         dni CHAR(8) NOT NULL UNIQUE
);

CREATE TABLE Boleto (
                        id_boleto INT AUTO_INCREMENT PRIMARY KEY,
                        destino VARCHAR(100) NOT NULL,
                        precio DECIMAL(10,2) NOT NULL,
                        id_cliente INT,
                        CONSTRAINT fk_cliente_boleto FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

INSERT INTO Cliente (nombre, dni) VALUES ('Elton Carranza', '12345678'), ('Juan Perez', '87654321'), ('Melanie Garcia', '11223344');
INSERT INTO Boleto (destino, precio, id_cliente) VALUES ('Lima', 50.00, 1), ('Cusco', 150.00, 2), ('Trujillo', 40.00, 3);


