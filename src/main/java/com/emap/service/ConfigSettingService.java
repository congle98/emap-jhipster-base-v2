package com.emap.service;

import com.emap.service.dto.ConfigSettingDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.emap.domain.ConfigSetting}.
 */
public interface ConfigSettingService {
    /**
     * Save a configSetting.
     *
     * @param configSettingDTO the entity to save.
     * @return the persisted entity.
     */
    ConfigSettingDTO save(ConfigSettingDTO configSettingDTO);

    /**
     * Updates a configSetting.
     *
     * @param configSettingDTO the entity to update.
     * @return the persisted entity.
     */
    ConfigSettingDTO update(ConfigSettingDTO configSettingDTO);

    /**
     * Partially updates a configSetting.
     *
     * @param configSettingDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConfigSettingDTO> partialUpdate(ConfigSettingDTO configSettingDTO);

    /**
     * Get all the configSettings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ConfigSettingDTO> findAll(Pageable pageable);

    /**
     * Get the "id" configSetting.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConfigSettingDTO> findOne(Long id);

    /**
     * Delete the "id" configSetting.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
