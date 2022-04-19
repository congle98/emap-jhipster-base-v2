package com.emap.service;

import com.emap.service.dto.TrackingListDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.TrackingList}.
 */
public interface TrackingListService {
    /**
     * Save a trackingList.
     *
     * @param trackingListDTO the entity to save.
     * @return the persisted entity.
     */
    TrackingListDTO save(TrackingListDTO trackingListDTO);

    /**
     * Updates a trackingList.
     *
     * @param trackingListDTO the entity to update.
     * @return the persisted entity.
     */
    TrackingListDTO update(TrackingListDTO trackingListDTO);

    /**
     * Partially updates a trackingList.
     *
     * @param trackingListDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TrackingListDTO> partialUpdate(TrackingListDTO trackingListDTO);

    /**
     * Get all the trackingLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TrackingListDTO> findAll(Pageable pageable);

    /**
     * Get the "id" trackingList.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TrackingListDTO> findOne(Long id);

    /**
     * Delete the "id" trackingList.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
