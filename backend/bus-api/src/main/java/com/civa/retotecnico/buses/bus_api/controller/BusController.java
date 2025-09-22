package com.civa.retotecnico.buses.bus_api.controller;

import com.civa.retotecnico.buses.bus_api.dto.BusDto;
import com.civa.retotecnico.buses.bus_api.dto.PageBusDto;
import com.civa.retotecnico.buses.bus_api.service.BusService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Bus operations
 */
@RestController
@RequestMapping("/bus")
@Validated
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<PageBusDto> getAllBuses(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(50) int size,
            @RequestParam(defaultValue = "createdAt,desc") String sort) {
        
        Pageable pageable = createPageable(page, size, sort);
        PageBusDto result = busService.getAllBuses(pageable);
        
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable @Min(1) Long id) {
        
        BusDto result = busService.getBusById(id);
        
        return ResponseEntity.ok(result);
    }

    private Pageable createPageable(int page, int size, String sort) {
        if (sort == null || sort.trim().isEmpty()) {
            return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        }
        
        String[] sortParts = sort.split(",");
        String field = sortParts[0].trim();
        Sort.Direction direction = Sort.Direction.DESC;
        
        if (sortParts.length > 1) {
            String directionStr = sortParts[1].trim().toLowerCase();
            if ("asc".equals(directionStr) || "ascending".equals(directionStr)) {
                direction = Sort.Direction.ASC;
            }
        }
        
        return PageRequest.of(page, size, Sort.by(direction, field));
    }
}