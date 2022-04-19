package com.emap.service.impl;

import com.emap.domain.TrackingList;
import com.emap.repository.TrackingListRepository;
import com.emap.service.TrackingListService;
import com.emap.service.dto.TrackingListDTO;
import com.emap.service.mapper.TrackingListMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TrackingList}.
 */
@Service
@Transactional
public class TrackingListServiceImpl implements TrackingListService {

    private final Logger log = LoggerFactory.getLogger(TrackingListServiceImpl.class);

    private final TrackingListRepository trackingListRepository;

    private final TrackingListMapper trackingListMapper;

    public TrackingListServiceImpl(TrackingListRepository trackingListRepository, TrackingListMapper trackingListMapper) {
        this.trackingListRepository = trackingListRepository;
        this.trackingListMapper = trackingListMapper;
    }

    @Override
    public TrackingListDTO save(TrackingListDTO trackingListDTO) {
        log.debug("Request to save TrackingList : {}", trackingListDTO);
        TrackingList trackingList = trackingListMapper.toEntity(trackingListDTO);
        trackingList = trackingListRepository.save(trackingList);
        return trackingListMapper.toDto(trackingList);
    }

    @Override
    public TrackingListDTO update(TrackingListDTO trackingListDTO) {
        log.debug("Request to save TrackingList : {}", trackingListDTO);
        TrackingList trackingList = trackingListMapper.toEntity(trackingListDTO);
        trackingList = trackingListRepository.save(trackingList);
        return trackingListMapper.toDto(trackingList);
    }

    @Override
    public Optional<TrackingListDTO> partialUpdate(TrackingListDTO trackingListDTO) {
        log.debug("Request to partially update TrackingList : {}", trackingListDTO);

        return trackingListRepository
            .findById(trackingListDTO.getId())
            .map(existingTrackingList -> {
                trackingListMapper.partialUpdate(existingTrackingList, trackingListDTO);

                return existingTrackingList;
            })
            .map(trackingListRepository::save)
            .map(trackingListMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TrackingListDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TrackingLists");
        return trackingListRepository.findAll(pageable).map(trackingListMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TrackingListDTO> findOne(Long id) {
        log.debug("Request to get TrackingList : {}", id);
        return trackingListRepository.findById(id).map(trackingListMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TrackingList : {}", id);
        trackingListRepository.deleteById(id);
    }
}
