package com.emap.service;

import com.emap.service.dto.CoordinatesDetailsDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.CoordinatesDetails}.
 */
public interface CoordinatesDetailsService {
    /**
     * Save a coordinatesDetails.
     *
     * @param coordinatesDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    CoordinatesDetailsDTO save(CoordinatesDetailsDTO coordinatesDetailsDTO);

    /**
     * Updates a coordinatesDetails.
     *
     * @param coordinatesDetailsDTO the entity to update.
     * @return the persisted entity.
     */
    CoordinatesDetailsDTO update(CoordinatesDetailsDTO coordinatesDetailsDTO);

    /**
     * Partially updates a coordinatesDetails.
     *
     * @param coordinatesDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CoordinatesDetailsDTO> partialUpdate(CoordinatesDetailsDTO coordinatesDetailsDTO);

    /**
     * Get all the coordinatesDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CoordinatesDetailsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" coordinatesDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CoordinatesDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" coordinatesDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
