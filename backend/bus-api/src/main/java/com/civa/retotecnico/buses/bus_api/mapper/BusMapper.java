package com.civa.retotecnico.buses.bus_api.mapper;

import com.civa.retotecnico.buses.bus_api.dto.BusDto;
import com.civa.retotecnico.buses.bus_api.dto.PageBusDto;
import com.civa.retotecnico.buses.bus_api.entity.Bus;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for converting between Bus entity and DTOs
 * No external mapping libraries used as per requirements
 */
@Component
public class BusMapper {

    /**
     * Convert Bus entity to BusDto
     *
     * @param bus Bus entity
     * @return BusDto
     */
    public BusDto toDto(Bus bus) {
        if (bus == null) {
            return null;
        }

        BusDto dto = new BusDto();
        dto.setId(bus.getId());
        dto.setNumber(bus.getNumber());
        dto.setPlate(bus.getPlate());
        dto.setCreatedAt(bus.getCreatedAt());
        dto.setFeatures(bus.getFeatures());
        dto.setActive(bus.getActive());
        
        // Include brand information
        if (bus.getBrand() != null) {
            dto.setBrandId(bus.getBrand().getId());
            dto.setBrandName(bus.getBrand().getName());
        }

        return dto;
    }

    /**
     * Convert list of Bus entities to list of BusDto
     *
     * @param buses List of Bus entities
     * @return List of BusDto
     */
    public List<BusDto> toDtoList(List<Bus> buses) {
        if (buses == null) {
            return null;
        }

        return buses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Convert Spring Data Page<Bus> to PageBusDto
     *
     * @param busPage Spring Data Page containing Bus entities
     * @return PageBusDto
     */
    public PageBusDto toPageDto(Page<Bus> busPage) {
        if (busPage == null) {
            return null;
        }

        PageBusDto pageDto = new PageBusDto();
        pageDto.setContent(toDtoList(busPage.getContent()));
        pageDto.setNumber(busPage.getNumber());
        pageDto.setSize(busPage.getSize());
        pageDto.setTotalElements(busPage.getTotalElements());
        pageDto.setTotalPages(busPage.getTotalPages());
        pageDto.setFirst(busPage.isFirst());
        pageDto.setLast(busPage.isLast());
        pageDto.setEmpty(busPage.isEmpty());

        return pageDto;
    }

    /**
     * Convert BusDto to Bus entity (for future use if creation endpoints are added)
     *
     * @param busDto BusDto
     * @return Bus entity
     */
    public Bus toEntity(BusDto busDto) {
        if (busDto == null) {
            return null;
        }

        Bus bus = new Bus();
        bus.setId(busDto.getId());
        bus.setNumber(busDto.getNumber());
        bus.setPlate(busDto.getPlate());
        bus.setCreatedAt(busDto.getCreatedAt());
        bus.setFeatures(busDto.getFeatures());
        bus.setActive(busDto.getActive());
        
        // Note: Brand must be set separately as we only have brandId in DTO
        // This would require a Brand repository lookup in a service layer

        return bus;
    }
}