-- Script SQL para crear la base de datos de Buses en Supabase (PostgreSQL)

-- Crear tabla de marcas
CREATE TABLE IF NOT EXISTS brand (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Crear índice en nombre de marca
CREATE INDEX IF NOT EXISTS idx_brand_name ON brand(name);

-- Crear tabla de buses
CREATE TABLE IF NOT EXISTS bus (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(50) NOT NULL UNIQUE,
    plate VARCHAR(20) NOT NULL UNIQUE,
    features TEXT,
    active BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    brand_id BIGINT NOT NULL,
    CONSTRAINT fk_bus_brand FOREIGN KEY (brand_id) REFERENCES brand(id)
);

-- Crear índices para optimizar búsquedas
CREATE INDEX IF NOT EXISTS idx_bus_number ON bus(number);
CREATE INDEX IF NOT EXISTS idx_bus_plate ON bus(plate);
CREATE INDEX IF NOT EXISTS idx_bus_active ON bus(active);
CREATE INDEX IF NOT EXISTS idx_bus_created_at ON bus(created_at);
CREATE INDEX IF NOT EXISTS idx_bus_brand_id ON bus(brand_id);

-- Insertar marcas de ejemplo
INSERT INTO brand (name) VALUES 
    ('Volvo'),
    ('Scania'),
    ('Fiat'),
    ('Mercedes-Benz'),
    ('Man')
ON CONFLICT (name) DO NOTHING;

-- Insertar buses de ejemplo
-- Buses Volvo (brand_id = 1)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-001', 'ABC-123', 'Aire acondicionado, WiFi, puertos USB, 45 asientos', true, 1),
    ('BUS-002', 'DEF-456', 'Asientos de cuero premium, sistema de entretenimiento, accesible para sillas de ruedas', true, 1),
    ('BUS-003', 'GHI-789', 'Configuración básica, 50 asientos', false, 1)
ON CONFLICT (number) DO NOTHING;

-- Buses Scania (brand_id = 2)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-004', 'JKL-012', 'Dos pisos, 80 asientos, ventanas panorámicas', true, 2),
    ('BUS-005', 'MNO-345', 'Bus eléctrico, operación silenciosa, capacidad de carga rápida', true, 2)
ON CONFLICT (number) DO NOTHING;

-- Buses Fiat (brand_id = 3)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-006', 'PQR-678', 'Bus urbano, piso bajo, 35 asientos', true, 3),
    ('BUS-007', 'STU-901', 'Minibús, 20 asientos, diseño compacto', false, 3)
ON CONFLICT (number) DO NOTHING;

-- Buses Mercedes-Benz (brand_id = 4)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-008', 'VWX-234', 'Coach de lujo, asientos reclinables, baño a bordo, 42 asientos', true, 4),
    ('BUS-009', 'YZA-567', 'Bus turístico, ventanas grandes, compartimento de equipaje', true, 4)
ON CONFLICT (number) DO NOTHING;

-- Buses Man (brand_id = 5)
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-010', 'BCD-890', 'Bus escolar, características de seguridad, 48 asientos', true, 5),
    ('BUS-011', 'EFG-123', 'Bus articulado, 120 asientos, bidireccional', false, 5)
ON CONFLICT (number) DO NOTHING;

-- Buses adicionales para pruebas de paginación
INSERT INTO bus (number, plate, features, active, brand_id) VALUES 
    ('BUS-012', 'HIJ-456', 'Configuración estándar', true, 1),
    ('BUS-013', 'KLM-789', 'Motor híbrido, ecológico', true, 2),
    ('BUS-014', 'NOP-012', 'Bus express, paradas limitadas', true, 4),
    ('BUS-015', 'QRS-345', 'Bus de servicio nocturno, iluminación mejorada', false, 3)
ON CONFLICT (number) DO NOTHING;

-- Verificar datos insertados
SELECT 'Marcas creadas:' as info, count(*) as total FROM brand;
SELECT 'Buses creados:' as info, count(*) as total FROM bus;

-- Vista para verificar relaciones
SELECT 
    b.id,
    b.number,
    b.plate,
    b.active,
    br.name as brand_name,
    b.created_at
FROM bus b
JOIN brand br ON b.brand_id = br.id
ORDER BY b.created_at DESC;