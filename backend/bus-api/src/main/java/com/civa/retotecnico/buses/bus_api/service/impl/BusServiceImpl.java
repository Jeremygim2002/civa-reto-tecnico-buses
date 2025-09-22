package com.civa.retotecnico.buses.bus_api.service.impl;

import com.civa.retotecnico.buses.bus_api.dto.BusDto;
import com.civa.retotecnico.buses.bus_api.dto.PageBusDto;
import com.civa.retotecnico.buses.bus_api.entity.Bus;
import com.civa.retotecnico.buses.bus_api.mapper.BusMapper;
import com.civa.retotecnico.buses.bus_api.repository.BusRepository;
import com.civa.retotecnico.buses.bus_api.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de buses
 */
@Service
@Transactional(readOnly = true)
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    private final BusMapper busMapper;

    public BusServiceImpl(BusRepository busRepository, BusMapper busMapper) {
        this.busRepository = busRepository;
        this.busMapper = busMapper;
    }

    @Override
    public PageBusDto getAllBuses(Pageable pageable) {
        Page<Bus> busPage = busRepository.findAllWithBrand(pageable);
        return busMapper.toPageDto(busPage);
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findByIdWithBrand(id)
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con ID: " + id));
        return busMapper.toDto(bus);
    }

    @Override
    public PageBusDto searchBusesByNumber(String number, Pageable pageable) {
        Page<Bus> busPage = busRepository.findByNumberContainingIgnoreCaseWithBrand(number.trim(), pageable);
        return busMapper.toPageDto(busPage);
    }

    @Override
    public PageBusDto searchBusesByPlate(String plate, Pageable pageable) {
        Page<Bus> busPage = busRepository.findByPlateContainingIgnoreCaseWithBrand(plate.trim(), pageable);
        return busMapper.toPageDto(busPage);
    }
}