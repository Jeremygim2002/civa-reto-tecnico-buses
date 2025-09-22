package com.civa.retotecnico.buses.bus_api.repository;

import com.civa.retotecnico.buses.bus_api.entity.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Bus entity with custom queries for optimization
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    /**
     * Find all buses with brand information using JOIN FETCH to avoid N+1 problem
     * Supports pagination and sorting
     *
     * @param pageable Pagination and sorting parameters
     * @return Page of buses with loaded brand information
     */
    @Query("SELECT b FROM Bus b JOIN FETCH b.brand")
    Page<Bus> findAllWithBrand(Pageable pageable);

    /**
     * Find bus by ID with brand information loaded
     *
     * @param id Bus ID
     * @return Optional Bus with brand loaded
     */
    @Query("SELECT b FROM Bus b JOIN FETCH b.brand WHERE b.id = :id")
    Optional<Bus> findByIdWithBrand(@Param("id") Long id);

    /**
     * Find buses by number containing text (case insensitive search)
     *
     * @param number   Search text
     * @param pageable Pagination parameters
     * @return Page of matching buses
     */
    @Query("SELECT b FROM Bus b JOIN FETCH b.brand WHERE LOWER(b.number) LIKE LOWER(CONCAT('%', :number, '%'))")
    Page<Bus> findByNumberContainingIgnoreCaseWithBrand(@Param("number") String number, Pageable pageable);

    /**
     * Find buses by plate containing text (case insensitive search)
     *
     * @param plate    Search text
     * @param pageable Pagination parameters
     * @return Page of matching buses
     */
    @Query("SELECT b FROM Bus b JOIN FETCH b.brand WHERE LOWER(b.plate) LIKE LOWER(CONCAT('%', :plate, '%'))")
    Page<Bus> findByPlateContainingIgnoreCaseWithBrand(@Param("plate") String plate, Pageable pageable);
}