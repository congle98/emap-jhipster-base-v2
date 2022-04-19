package com.emap.service.impl;

import com.emap.domain.Target;
import com.emap.repository.TargetRepository;
import com.emap.service.TargetService;
import com.emap.service.dto.TargetDTO;
import com.emap.service.mapper.TargetMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Target}.
 */
@Service
@Transactional
public class TargetServiceImpl implements TargetService {

    private final Logger log = LoggerFactory.getLogger(TargetServiceImpl.class);

    private final TargetRepository targetRepository;

    private final TargetMapper targetMapper;

    public TargetServiceImpl(TargetRepository targetRepository, TargetMapper targetMapper) {
        this.targetRepository = targetRepository;
        this.targetMapper = targetMapper;
    }

    @Override
    public TargetDTO save(TargetDTO targetDTO) {
        log.debug("Request to save Target : {}", targetDTO);
        Target target = targetMapper.toEntity(targetDTO);
        target = targetRepository.save(target);
        return targetMapper.toDto(target);
    }

    @Override
    public TargetDTO update(TargetDTO targetDTO) {
        log.debug("Request to save Target : {}", targetDTO);
        Target target = targetMapper.toEntity(targetDTO);
        target = targetRepository.save(target);
        return targetMapper.toDto(target);
    }

    @Override
    public Optional<TargetDTO> partialUpdate(TargetDTO targetDTO) {
        log.debug("Request to partially update Target : {}", targetDTO);

        return targetRepository
            .findById(targetDTO.getId())
            .map(existingTarget -> {
                targetMapper.partialUpdate(existingTarget, targetDTO);

                return existingTarget;
            })
            .map(targetRepository::save)
            .map(targetMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TargetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Targets");
        return targetRepository.findAll(pageable).map(targetMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TargetDTO> findOne(Long id) {
        log.debug("Request to get Target : {}", id);
        return targetRepository.findById(id).map(targetMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Target : {}", id);
        targetRepository.deleteById(id);
    }
}
