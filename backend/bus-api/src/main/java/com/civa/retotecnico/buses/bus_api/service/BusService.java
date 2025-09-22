package com.civa.retotecnico.buses.bus_api.service;

import com.civa.retotecnico.buses.bus_api.dto.BusDto;
import com.civa.retotecnico.buses.bus_api.dto.PageBusDto;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for Bus operations
 */
public interface BusService {

    /**
     * Get all buses with pagination and sorting
     *
     * @param pageable Pagination and sorting parameters
     * @return Paginated list of buses
     */
    PageBusDto getAllBuses(Pageable pageable);

    /**
     * Get bus by ID
     *
     * @param id Bus ID
     * @return Bus DTO
     * @throws com.civa.retotecnico.buses.bus_api.exception.ResourceNotFoundException if bus not found
     */
    BusDto getBusById(Long id);

    /**
     * Search buses by number
     *
     * @param number Search term for bus number
     * @param pageable Pagination and sorting parameters
     * @return Paginated list of matching buses
     */
    PageBusDto searchBusesByNumber(String number, Pageable pageable);

    /**
     * Search buses by plate
     *
     * @param plate Search term for bus plate
     * @param pageable Pagination and sorting parameters
     * @return Paginated list of matching buses
     */
    PageBusDto searchBusesByPlate(String plate, Pageable pageable);
}