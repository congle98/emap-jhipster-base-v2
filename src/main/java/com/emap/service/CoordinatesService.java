package com.emap.service;

import com.emap.service.dto.CoordinatesDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.Coordinates}.
 */
public interface CoordinatesService {
    /**
     * Save a coordinates.
     *
     * @param coordinatesDTO the entity to save.
     * @return the persisted entity.
     */
    CoordinatesDTO save(CoordinatesDTO coordinatesDTO);

    /**
     * Updates a coordinates.
     *
     * @param coordinatesDTO the entity to update.
     * @return the persisted entity.
     */
    CoordinatesDTO update(CoordinatesDTO coordinatesDTO);

    /**
     * Partially updates a coordinates.
     *
     * @param coordinatesDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CoordinatesDTO> partialUpdate(CoordinatesDTO coordinatesDTO);

    /**
     * Get all the coordinates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CoordinatesDTO> findAll(Pageable pageable);

    /**
     * Get the "id" coordinates.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CoordinatesDTO> findOne(Long id);

    /**
     * Delete the "id" coordinates.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
