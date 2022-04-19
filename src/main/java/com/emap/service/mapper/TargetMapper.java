package com.emap.service.mapper;

import com.emap.domain.Target;
import com.emap.service.dto.TargetDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Target} and its DTO {@link TargetDTO}.
 */
@Mapper(componentModel = "spring")
public interface TargetMapper extends EntityMapper<TargetDTO, Target> {}
