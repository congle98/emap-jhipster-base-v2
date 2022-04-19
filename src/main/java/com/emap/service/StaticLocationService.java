package com.emap.service;

import com.emap.service.dto.StaticLocationDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.StaticLocation}.
 */
public interface StaticLocationService {
    /**
     * Save a staticLocation.
     *
     * @param staticLocationDTO the entity to save.
     * @return the persisted entity.
     */
    StaticLocationDTO save(StaticLocationDTO staticLocationDTO);

    /**
     * Updates a staticLocation.
     *
     * @param staticLocationDTO the entity to update.
     * @return the persisted entity.
     */
    StaticLocationDTO update(StaticLocationDTO staticLocationDTO);

    /**
     * Partially updates a staticLocation.
     *
     * @param staticLocationDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<StaticLocationDTO> partialUpdate(StaticLocationDTO staticLocationDTO);

    /**
     * Get all the staticLocations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StaticLocationDTO> findAll(Pageable pageable);

    /**
     * Get the "id" staticLocation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StaticLocationDTO> findOne(Long id);

    /**
     * Delete the "id" staticLocation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
