package com.civa.retotecnico.buses.bus_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Bus entity representing individual buses
 */
@Entity
@Table(name = "bus", indexes = {
    @Index(name = "idx_bus_number", columnList = "number", unique = true),
    @Index(name = "idx_bus_plate", columnList = "plate", unique = true),
    @Index(name = "idx_bus_brand_id", columnList = "brand_id"),
    @Index(name = "idx_bus_created_at", columnList = "created_at")
})
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Bus number is required")
    @Size(min = 1, max = 50, message = "Bus number must be between 1 and 50 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\-]+$", message = "Bus number can only contain alphanumeric characters and hyphens")
    @Column(name = "number", nullable = false, unique = true, length = 50)
    private String number;

    @NotBlank(message = "Bus plate is required")
    @Size(min = 1, max = 20, message = "Bus plate must be between 1 and 20 characters")
    @Column(name = "plate", nullable = false, unique = true, length = 20)
    private String plate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "features", columnDefinition = "TEXT")
    private String features;

    @NotNull(message = "Active status is required")
    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @NotNull(message = "Brand is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(name = "fk_bus_brand"))
    private Brand brand;

    // Default constructor
    public Bus() {}

    // Constructor with required fields
    public Bus(String number, String plate, Brand brand) {
        this.number = number;
        this.plate = plate;
        this.brand = brand;
        this.active = true;
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (active == null) {
            active = true;
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(id, bus.id) && 
               Objects.equals(number, bus.number) && 
               Objects.equals(plate, bus.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, plate);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", plate='" + plate + '\'' +
                ", createdAt=" + createdAt +
                ", features='" + features + '\'' +
                ", active=" + active +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }
}