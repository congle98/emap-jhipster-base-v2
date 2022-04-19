package com.emap.service.impl;

import com.emap.domain.StaticLocation;
import com.emap.repository.StaticLocationRepository;
import com.emap.service.StaticLocationService;
import com.emap.service.dto.StaticLocationDTO;
import com.emap.service.mapper.StaticLocationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link StaticLocation}.
 */
@Service
@Transactional
public class StaticLocationServiceImpl implements StaticLocationService {

    private final Logger log = LoggerFactory.getLogger(StaticLocationServiceImpl.class);

    private final StaticLocationRepository staticLocationRepository;

    private final StaticLocationMapper staticLocationMapper;

    public StaticLocationServiceImpl(StaticLocationRepository staticLocationRepository, StaticLocationMapper staticLocationMapper) {
        this.staticLocationRepository = staticLocationRepository;
        this.staticLocationMapper = staticLocationMapper;
    }

    @Override
    public StaticLocationDTO save(StaticLocationDTO staticLocationDTO) {
        log.debug("Request to save StaticLocation : {}", staticLocationDTO);
        StaticLocation staticLocation = staticLocationMapper.toEntity(staticLocationDTO);
        staticLocation = staticLocationRepository.save(staticLocation);
        return staticLocationMapper.toDto(staticLocation);
    }

    @Override
    public StaticLocationDTO update(StaticLocationDTO staticLocationDTO) {
        log.debug("Request to save StaticLocation : {}", staticLocationDTO);
        StaticLocation staticLocation = staticLocationMapper.toEntity(staticLocationDTO);
        staticLocation = staticLocationRepository.save(staticLocation);
        return staticLocationMapper.toDto(staticLocation);
    }

    @Override
    public Optional<StaticLocationDTO> partialUpdate(StaticLocationDTO staticLocationDTO) {
        log.debug("Request to partially update StaticLocation : {}", staticLocationDTO);

        return staticLocationRepository
            .findById(staticLocationDTO.getId())
            .map(existingStaticLocation -> {
                staticLocationMapper.partialUpdate(existingStaticLocation, staticLocationDTO);

                return existingStaticLocation;
            })
            .map(staticLocationRepository::save)
            .map(staticLocationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StaticLocationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StaticLocations");
        return staticLocationRepository.findAll(pageable).map(staticLocationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StaticLocationDTO> findOne(Long id) {
        log.debug("Request to get StaticLocation : {}", id);
        return staticLocationRepository.findById(id).map(staticLocationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete StaticLocation : {}", id);
        staticLocationRepository.deleteById(id);
    }
}
