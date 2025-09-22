-- Datos de prueba para Sistema de Gestión de Buses
-- Versión compatible con base de datos H2

-- Insertar marcas de ejemplo
INSERT INTO brand (name) VALUES ('Volvo');
INSERT INTO brand (name) VALUES ('Scania');
INSERT INTO brand (name) VALUES ('Fiat');
INSERT INTO brand (name) VALUES ('Mercedes-Benz');
INSERT INTO brand (name) VALUES ('Man');

-- Insertar buses de ejemplo
-- Buses Volvo (brand_id = 1)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-001', 'ABC-123', 'Aire acondicionado, WiFi, puertos USB, 45 asientos', true, 1);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-002', 'DEF-456', 'Asientos de cuero premium, sistema de entretenimiento, accesible para sillas de ruedas', true, 1);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-003', 'GHI-789', 'Configuración básica, 50 asientos', false, 1);

-- Buses Scania (brand_id = 2)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-004', 'JKL-012', 'Dos pisos, 80 asientos, ventanas panorámicas', true, 2);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-005', 'MNO-345', 'Bus eléctrico, operación silenciosa, capacidad de carga rápida', true, 2);

-- Buses Fiat (brand_id = 3)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-006', 'PQR-678', 'Bus urbano, piso bajo, 35 asientos', true, 3);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-007', 'STU-901', 'Minibús, 20 asientos, diseño compacto', false, 3);

-- Buses Mercedes-Benz (brand_id = 4)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-008', 'VWX-234', 'Coach de lujo, asientos reclinables, baño a bordo, 42 asientos', true, 4);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-009', 'YZA-567', 'Bus turístico, ventanas grandes, compartimento de equipaje', true, 4);

-- Buses Man (brand_id = 5)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-010', 'BCD-890', 'Bus escolar, características de seguridad, 48 asientos', true, 5);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-011', 'EFG-123', 'Bus articulado, 120 asientos, bidireccional', false, 5);

-- Buses adicionales para pruebas de paginación
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-012', 'HIJ-456', 'Configuración estándar', true, 1);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-013', 'KLM-789', 'Motor híbrido, ecológico', true, 2);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-014', 'NOP-012', 'Bus express, paradas limitadas', true, 4);

INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-015', 'QRS-345', 'Bus de servicio nocturno, iluminación mejorada', false, 3);