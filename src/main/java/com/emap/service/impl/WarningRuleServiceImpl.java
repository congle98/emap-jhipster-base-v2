package com.emap.service.impl;

import com.emap.domain.WarningRule;
import com.emap.repository.WarningRuleRepository;
import com.emap.service.WarningRuleService;
import com.emap.service.dto.WarningRuleDTO;
import com.emap.service.mapper.WarningRuleMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link WarningRule}.
 */
@Service
@Transactional
public class WarningRuleServiceImpl implements WarningRuleService {

    private final Logger log = LoggerFactory.getLogger(WarningRuleServiceImpl.class);

    private final WarningRuleRepository warningRuleRepository;

    private final WarningRuleMapper warningRuleMapper;

    public WarningRuleServiceImpl(WarningRuleRepository warningRuleRepository, WarningRuleMapper warningRuleMapper) {
        this.warningRuleRepository = warningRuleRepository;
        this.warningRuleMapper = warningRuleMapper;
    }

    @Override
    public WarningRuleDTO save(WarningRuleDTO warningRuleDTO) {
        log.debug("Request to save WarningRule : {}", warningRuleDTO);
        WarningRule warningRule = warningRuleMapper.toEntity(warningRuleDTO);
        warningRule = warningRuleRepository.save(warningRule);
        return warningRuleMapper.toDto(warningRule);
    }

    @Override
    public WarningRuleDTO update(WarningRuleDTO warningRuleDTO) {
        log.debug("Request to save WarningRule : {}", warningRuleDTO);
        WarningRule warningRule = warningRuleMapper.toEntity(warningRuleDTO);
        warningRule = warningRuleRepository.save(warningRule);
        return warningRuleMapper.toDto(warningRule);
    }

    @Override
    public Optional<WarningRuleDTO> partialUpdate(WarningRuleDTO warningRuleDTO) {
        log.debug("Request to partially update WarningRule : {}", warningRuleDTO);

        return warningRuleRepository
            .findById(warningRuleDTO.getId())
            .map(existingWarningRule -> {
                warningRuleMapper.partialUpdate(existingWarningRule, warningRuleDTO);

                return existingWarningRule;
            })
            .map(warningRuleRepository::save)
            .map(warningRuleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<WarningRuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WarningRules");
        return warningRuleRepository.findAll(pageable).map(warningRuleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<WarningRuleDTO> findOne(Long id) {
        log.debug("Request to get WarningRule : {}", id);
        return warningRuleRepository.findById(id).map(warningRuleMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete WarningRule : {}", id);
        warningRuleRepository.deleteById(id);
    }
}
