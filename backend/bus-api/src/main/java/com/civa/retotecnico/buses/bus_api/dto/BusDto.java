package com.civa.retotecnico.buses.bus_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for Bus entity containing all fields needed by the frontend
 */
public class BusDto {

    private Long id;

    private String number;
    private String plate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    private String features;

    private Boolean active;

    private Long brandId;

    private String brandName;

    public BusDto() {
    }

    public BusDto(Long id, String number, String plate, LocalDateTime createdAt,
            String features, Boolean active, Long brandId, String brandName) {
        this.id = id;
        this.number = number;
        this.plate = plate;
        this.createdAt = createdAt;
        this.features = features;
        this.active = active;
        this.brandId = brandId;
        this.brandName = brandName;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BusDto busDto = (BusDto) o;
        return Objects.equals(id, busDto.id) &&
                Objects.equals(number, busDto.number) &&
                Objects.equals(plate, busDto.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, plate);
    }

    @Override
    public String toString() {
        return "BusDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", plate='" + plate + '\'' +
                ", createdAt=" + createdAt +
                ", features='" + features + '\'' +
                ", active=" + active +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}