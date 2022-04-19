package com.emap.service.impl;

import com.emap.domain.CoordinatesDetails;
import com.emap.repository.CoordinatesDetailsRepository;
import com.emap.service.CoordinatesDetailsService;
import com.emap.service.dto.CoordinatesDetailsDTO;
import com.emap.service.mapper.CoordinatesDetailsMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CoordinatesDetails}.
 */
@Service
@Transactional
public class CoordinatesDetailsServiceImpl implements CoordinatesDetailsService {

    private final Logger log = LoggerFactory.getLogger(CoordinatesDetailsServiceImpl.class);

    private final CoordinatesDetailsRepository coordinatesDetailsRepository;

    private final CoordinatesDetailsMapper coordinatesDetailsMapper;

    public CoordinatesDetailsServiceImpl(
        CoordinatesDetailsRepository coordinatesDetailsRepository,
        CoordinatesDetailsMapper coordinatesDetailsMapper
    ) {
        this.coordinatesDetailsRepository = coordinatesDetailsRepository;
        this.coordinatesDetailsMapper = coordinatesDetailsMapper;
    }

    @Override
    public CoordinatesDetailsDTO save(CoordinatesDetailsDTO coordinatesDetailsDTO) {
        log.debug("Request to save CoordinatesDetails : {}", coordinatesDetailsDTO);
        CoordinatesDetails coordinatesDetails = coordinatesDetailsMapper.toEntity(coordinatesDetailsDTO);
        coordinatesDetails = coordinatesDetailsRepository.save(coordinatesDetails);
        return coordinatesDetailsMapper.toDto(coordinatesDetails);
    }

    @Override
    public CoordinatesDetailsDTO update(CoordinatesDetailsDTO coordinatesDetailsDTO) {
        log.debug("Request to save CoordinatesDetails : {}", coordinatesDetailsDTO);
        CoordinatesDetails coordinatesDetails = coordinatesDetailsMapper.toEntity(coordinatesDetailsDTO);
        coordinatesDetails = coordinatesDetailsRepository.save(coordinatesDetails);
        return coordinatesDetailsMapper.toDto(coordinatesDetails);
    }

    @Override
    public Optional<CoordinatesDetailsDTO> partialUpdate(CoordinatesDetailsDTO coordinatesDetailsDTO) {
        log.debug("Request to partially update CoordinatesDetails : {}", coordinatesDetailsDTO);

        return coordinatesDetailsRepository
            .findById(coordinatesDetailsDTO.getId())
            .map(existingCoordinatesDetails -> {
                coordinatesDetailsMapper.partialUpdate(existingCoordinatesDetails, coordinatesDetailsDTO);

                return existingCoordinatesDetails;
            })
            .map(coordinatesDetailsRepository::save)
            .map(coordinatesDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CoordinatesDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CoordinatesDetails");
        return coordinatesDetailsRepository.findAll(pageable).map(coordinatesDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CoordinatesDetailsDTO> findOne(Long id) {
        log.debug("Request to get CoordinatesDetails : {}", id);
        return coordinatesDetailsRepository.findById(id).map(coordinatesDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CoordinatesDetails : {}", id);
        coordinatesDetailsRepository.deleteById(id);
    }
}
