package com.emap.service.impl;

import com.emap.domain.WarningMessage;
import com.emap.repository.WarningMessageRepository;
import com.emap.service.WarningMessageService;
import com.emap.service.dto.WarningMessageDTO;
import com.emap.service.mapper.WarningMessageMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link WarningMessage}.
 */
@Service
@Transactional
public class WarningMessageServiceImpl implements WarningMessageService {

    private final Logger log = LoggerFactory.getLogger(WarningMessageServiceImpl.class);

    private final WarningMessageRepository warningMessageRepository;

    private final WarningMessageMapper warningMessageMapper;

    public WarningMessageServiceImpl(WarningMessageRepository warningMessageRepository, WarningMessageMapper warningMessageMapper) {
        this.warningMessageRepository = warningMessageRepository;
        this.warningMessageMapper = warningMessageMapper;
    }

    @Override
    public WarningMessageDTO save(WarningMessageDTO warningMessageDTO) {
        log.debug("Request to save WarningMessage : {}", warningMessageDTO);
        WarningMessage warningMessage = warningMessageMapper.toEntity(warningMessageDTO);
        warningMessage = warningMessageRepository.save(warningMessage);
        return warningMessageMapper.toDto(warningMessage);
    }

    @Override
    public WarningMessageDTO update(WarningMessageDTO warningMessageDTO) {
        log.debug("Request to save WarningMessage : {}", warningMessageDTO);
        WarningMessage warningMessage = warningMessageMapper.toEntity(warningMessageDTO);
        warningMessage = warningMessageRepository.save(warningMessage);
        return warningMessageMapper.toDto(warningMessage);
    }

    @Override
    public Optional<WarningMessageDTO> partialUpdate(WarningMessageDTO warningMessageDTO) {
        log.debug("Request to partially update WarningMessage : {}", warningMessageDTO);

        return warningMessageRepository
            .findById(warningMessageDTO.getId())
            .map(existingWarningMessage -> {
                warningMessageMapper.partialUpdate(existingWarningMessage, warningMessageDTO);

                return existingWarningMessage;
            })
            .map(warningMessageRepository::save)
            .map(warningMessageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<WarningMessageDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WarningMessages");
        return warningMessageRepository.findAll(pageable).map(warningMessageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<WarningMessageDTO> findOne(Long id) {
        log.debug("Request to get WarningMessage : {}", id);
        return warningMessageRepository.findById(id).map(warningMessageMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete WarningMessage : {}", id);
        warningMessageRepository.deleteById(id);
    }
}
