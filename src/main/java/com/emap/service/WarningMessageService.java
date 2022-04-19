package com.emap.service;

import com.emap.service.dto.WarningMessageDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.WarningMessage}.
 */
public interface WarningMessageService {
    /**
     * Save a warningMessage.
     *
     * @param warningMessageDTO the entity to save.
     * @return the persisted entity.
     */
    WarningMessageDTO save(WarningMessageDTO warningMessageDTO);

    /**
     * Updates a warningMessage.
     *
     * @param warningMessageDTO the entity to update.
     * @return the persisted entity.
     */
    WarningMessageDTO update(WarningMessageDTO warningMessageDTO);

    /**
     * Partially updates a warningMessage.
     *
     * @param warningMessageDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<WarningMessageDTO> partialUpdate(WarningMessageDTO warningMessageDTO);

    /**
     * Get all the warningMessages.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<WarningMessageDTO> findAll(Pageable pageable);

    /**
     * Get the "id" warningMessage.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WarningMessageDTO> findOne(Long id);

    /**
     * Delete the "id" warningMessage.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
