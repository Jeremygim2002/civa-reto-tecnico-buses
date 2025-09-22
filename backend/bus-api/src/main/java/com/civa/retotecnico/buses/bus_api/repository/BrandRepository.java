package com.civa.retotecnico.buses.bus_api.repository;

import com.civa.retotecnico.buses.bus_api.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Brand entity
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}