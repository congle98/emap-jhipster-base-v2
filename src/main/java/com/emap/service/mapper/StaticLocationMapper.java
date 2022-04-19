package com.emap.service.mapper;

import com.emap.domain.StaticLocation;
import com.emap.service.dto.StaticLocationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StaticLocation} and its DTO {@link StaticLocationDTO}.
 */
@Mapper(componentModel = "spring")
public interface StaticLocationMapper extends EntityMapper<StaticLocationDTO, StaticLocation> {}
