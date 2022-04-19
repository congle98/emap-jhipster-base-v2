package com.emap.service.mapper;

import com.emap.domain.Coordinates;
import com.emap.service.dto.CoordinatesDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Coordinates} and its DTO {@link CoordinatesDTO}.
 */
@Mapper(componentModel = "spring")
public interface CoordinatesMapper extends EntityMapper<CoordinatesDTO, Coordinates> {}
