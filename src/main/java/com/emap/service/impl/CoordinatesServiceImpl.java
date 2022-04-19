package com.emap.service.impl;

import com.emap.domain.Coordinates;
import com.emap.repository.CoordinatesRepository;
import com.emap.service.CoordinatesService;
import com.emap.service.dto.CoordinatesDTO;
import com.emap.service.mapper.CoordinatesMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Coordinates}.
 */
@Service
@Transactional
public class CoordinatesServiceImpl implements CoordinatesService {

    private final Logger log = LoggerFactory.getLogger(CoordinatesServiceImpl.class);

    private final CoordinatesRepository coordinatesRepository;

    private final CoordinatesMapper coordinatesMapper;

    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository, CoordinatesMapper coordinatesMapper) {
        this.coordinatesRepository = coordinatesRepository;
        this.coordinatesMapper = coordinatesMapper;
    }

    @Override
    public CoordinatesDTO save(CoordinatesDTO coordinatesDTO) {
        log.debug("Request to save Coordinates : {}", coordinatesDTO);
        Coordinates coordinates = coordinatesMapper.toEntity(coordinatesDTO);
        coordinates = coordinatesRepository.save(coordinates);
        return coordinatesMapper.toDto(coordinates);
    }

    @Override
    public CoordinatesDTO update(CoordinatesDTO coordinatesDTO) {
        log.debug("Request to save Coordinates : {}", coordinatesDTO);
        Coordinates coordinates = coordinatesMapper.toEntity(coordinatesDTO);
        coordinates = coordinatesRepository.save(coordinates);
        return coordinatesMapper.toDto(coordinates);
    }

    @Override
    public Optional<CoordinatesDTO> partialUpdate(CoordinatesDTO coordinatesDTO) {
        log.debug("Request to partially update Coordinates : {}", coordinatesDTO);

        return coordinatesRepository
            .findById(coordinatesDTO.getId())
            .map(existingCoordinates -> {
                coordinatesMapper.partialUpdate(existingCoordinates, coordinatesDTO);

                return existingCoordinates;
            })
            .map(coordinatesRepository::save)
            .map(coordinatesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CoordinatesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Coordinates");
        return coordinatesRepository.findAll(pageable).map(coordinatesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CoordinatesDTO> findOne(Long id) {
        log.debug("Request to get Coordinates : {}", id);
        return coordinatesRepository.findById(id).map(coordinatesMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Coordinates : {}", id);
        coordinatesRepository.deleteById(id);
    }
}
