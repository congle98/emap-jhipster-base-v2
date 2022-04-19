package com.emap.service.impl;

import com.emap.domain.ConfigSetting;
import com.emap.repository.ConfigSettingRepository;
import com.emap.service.ConfigSettingService;
import com.emap.service.dto.ConfigSettingDTO;
import com.emap.service.mapper.ConfigSettingMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ConfigSetting}.
 */
@Service
@Transactional
public class ConfigSettingServiceImpl implements ConfigSettingService {

    private final Logger log = LoggerFactory.getLogger(ConfigSettingServiceImpl.class);

    private final ConfigSettingRepository configSettingRepository;

    private final ConfigSettingMapper configSettingMapper;

    public ConfigSettingServiceImpl(ConfigSettingRepository configSettingRepository, ConfigSettingMapper configSettingMapper) {
        this.configSettingRepository = configSettingRepository;
        this.configSettingMapper = configSettingMapper;
    }

    @Override
    public ConfigSettingDTO save(ConfigSettingDTO configSettingDTO) {
        log.debug("Request to save ConfigSetting : {}", configSettingDTO);
        ConfigSetting configSetting = configSettingMapper.toEntity(configSettingDTO);
        configSetting = configSettingRepository.save(configSetting);
        return configSettingMapper.toDto(configSetting);
    }

    @Override
    public ConfigSettingDTO update(ConfigSettingDTO configSettingDTO) {
        log.debug("Request to save ConfigSetting : {}", configSettingDTO);
        ConfigSetting configSetting = configSettingMapper.toEntity(configSettingDTO);
        configSetting = configSettingRepository.save(configSetting);
        return configSettingMapper.toDto(configSetting);
    }

    @Override
    public Optional<ConfigSettingDTO> partialUpdate(ConfigSettingDTO configSettingDTO) {
        log.debug("Request to partially update ConfigSetting : {}", configSettingDTO);

        return configSettingRepository
            .findById(configSettingDTO.getId())
            .map(existingConfigSetting -> {
                configSettingMapper.partialUpdate(existingConfigSetting, configSettingDTO);

                return existingConfigSetting;
            })
            .map(configSettingRepository::save)
            .map(configSettingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConfigSettingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ConfigSettings");
        return configSettingRepository.findAll(pageable).map(configSettingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConfigSettingDTO> findOne(Long id) {
        log.debug("Request to get ConfigSetting : {}", id);
        return configSettingRepository.findById(id).map(configSettingMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ConfigSetting : {}", id);
        configSettingRepository.deleteById(id);
    }
}
