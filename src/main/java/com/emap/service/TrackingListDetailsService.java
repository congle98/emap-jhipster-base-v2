package com.emap.service;

import com.emap.service.dto.TrackingListDetailsDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.TrackingListDetails}.
 */
public interface TrackingListDetailsService {
    /**
     * Save a trackingListDetails.
     *
     * @param trackingListDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    TrackingListDetailsDTO save(TrackingListDetailsDTO trackingListDetailsDTO);

    /**
     * Updates a trackingListDetails.
     *
     * @param trackingListDetailsDTO the entity to update.
     * @return the persisted entity.
     */
    TrackingListDetailsDTO update(TrackingListDetailsDTO trackingListDetailsDTO);

    /**
     * Partially updates a trackingListDetails.
     *
     * @param trackingListDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TrackingListDetailsDTO> partialUpdate(TrackingListDetailsDTO trackingListDetailsDTO);

    /**
     * Get all the trackingListDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TrackingListDetailsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" trackingListDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TrackingListDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" trackingListDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
