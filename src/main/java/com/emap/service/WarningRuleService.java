package com.emap.service;

import com.emap.service.dto.WarningRuleDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.WarningRule}.
 */
public interface WarningRuleService {
    /**
     * Save a warningRule.
     *
     * @param warningRuleDTO the entity to save.
     * @return the persisted entity.
     */
    WarningRuleDTO save(WarningRuleDTO warningRuleDTO);

    /**
     * Updates a warningRule.
     *
     * @param warningRuleDTO the entity to update.
     * @return the persisted entity.
     */
    WarningRuleDTO update(WarningRuleDTO warningRuleDTO);

    /**
     * Partially updates a warningRule.
     *
     * @param warningRuleDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<WarningRuleDTO> partialUpdate(WarningRuleDTO warningRuleDTO);

    /**
     * Get all the warningRules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<WarningRuleDTO> findAll(Pageable pageable);

    /**
     * Get the "id" warningRule.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WarningRuleDTO> findOne(Long id);

    /**
     * Delete the "id" warningRule.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
