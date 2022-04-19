package com.emap.service.impl;

import com.emap.domain.TrackingListDetails;
import com.emap.repository.TrackingListDetailsRepository;
import com.emap.service.TrackingListDetailsService;
import com.emap.service.dto.TrackingListDetailsDTO;
import com.emap.service.mapper.TrackingListDetailsMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TrackingListDetails}.
 */
@Service
@Transactional
public class TrackingListDetailsServiceImpl implements TrackingListDetailsService {

    private final Logger log = LoggerFactory.getLogger(TrackingListDetailsServiceImpl.class);

    private final TrackingListDetailsRepository trackingListDetailsRepository;

    private final TrackingListDetailsMapper trackingListDetailsMapper;

    public TrackingListDetailsServiceImpl(
        TrackingListDetailsRepository trackingListDetailsRepository,
        TrackingListDetailsMapper trackingListDetailsMapper
    ) {
        this.trackingListDetailsRepository = trackingListDetailsRepository;
        this.trackingListDetailsMapper = trackingListDetailsMapper;
    }

    @Override
    public TrackingListDetailsDTO save(TrackingListDetailsDTO trackingListDetailsDTO) {
        log.debug("Request to save TrackingListDetails : {}", trackingListDetailsDTO);
        TrackingListDetails trackingListDetails = trackingListDetailsMapper.toEntity(trackingListDetailsDTO);
        trackingListDetails = trackingListDetailsRepository.save(trackingListDetails);
        return trackingListDetailsMapper.toDto(trackingListDetails);
    }

    @Override
    public TrackingListDetailsDTO update(TrackingListDetailsDTO trackingListDetailsDTO) {
        log.debug("Request to save TrackingListDetails : {}", trackingListDetailsDTO);
        TrackingListDetails trackingListDetails = trackingListDetailsMapper.toEntity(trackingListDetailsDTO);
        trackingListDetails = trackingListDetailsRepository.save(trackingListDetails);
        return trackingListDetailsMapper.toDto(trackingListDetails);
    }

    @Override
    public Optional<TrackingListDetailsDTO> partialUpdate(TrackingListDetailsDTO trackingListDetailsDTO) {
        log.debug("Request to partially update TrackingListDetails : {}", trackingListDetailsDTO);

        return trackingListDetailsRepository
            .findById(trackingListDetailsDTO.getId())
            .map(existingTrackingListDetails -> {
                trackingListDetailsMapper.partialUpdate(existingTrackingListDetails, trackingListDetailsDTO);

                return existingTrackingListDetails;
            })
            .map(trackingListDetailsRepository::save)
            .map(trackingListDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TrackingListDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TrackingListDetails");
        return trackingListDetailsRepository.findAll(pageable).map(trackingListDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TrackingListDetailsDTO> findOne(Long id) {
        log.debug("Request to get TrackingListDetails : {}", id);
        return trackingListDetailsRepository.findById(id).map(trackingListDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TrackingListDetails : {}", id);
        trackingListDetailsRepository.deleteById(id);
    }
}
