package com.emap.service;

import com.emap.service.dto.TargetDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.Target}.
 */
public interface TargetService {
    /**
     * Save a target.
     *
     * @param targetDTO the entity to save.
     * @return the persisted entity.
     */
    TargetDTO save(TargetDTO targetDTO);

    /**
     * Updates a target.
     *
     * @param targetDTO the entity to update.
     * @return the persisted entity.
     */
    TargetDTO update(TargetDTO targetDTO);

    /**
     * Partially updates a target.
     *
     * @param targetDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TargetDTO> partialUpdate(TargetDTO targetDTO);

    /**
     * Get all the targets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TargetDTO> findAll(Pageable pageable);

    /**
     * Get the "id" target.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TargetDTO> findOne(Long id);

    /**
     * Delete the "id" target.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
