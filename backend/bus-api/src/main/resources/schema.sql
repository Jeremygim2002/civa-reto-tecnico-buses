-- Schema creation for Bus Management System
-- H2 Database compatible version

-- Create brand table
CREATE TABLE IF NOT EXISTS brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Create bus table
CREATE TABLE IF NOT EXISTS bus (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(50) NOT NULL UNIQUE,
    plate VARCHAR(20) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    features TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    brand_id BIGINT NOT NULL,
    CONSTRAINT fk_bus_brand FOREIGN KEY (brand_id) REFERENCES brand(id) ON DELETE RESTRICT
);

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_brand_name ON brand(name);
CREATE INDEX IF NOT EXISTS idx_bus_number ON bus(number);
CREATE INDEX IF NOT EXISTS idx_bus_plate ON bus(plate);
CREATE INDEX IF NOT EXISTS idx_bus_brand_id ON bus(brand_id);
CREATE INDEX IF NOT EXISTS idx_bus_created_at ON bus(created_at);
CREATE INDEX IF NOT EXISTS idx_bus_active ON bus(active);