package com.emap.service.mapper;

import com.emap.domain.Coordinates;
import com.emap.domain.CoordinatesDetails;
import com.emap.domain.Target;
import com.emap.service.dto.CoordinatesDTO;
import com.emap.service.dto.CoordinatesDetailsDTO;
import com.emap.service.dto.TargetDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CoordinatesDetails} and its DTO {@link CoordinatesDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface CoordinatesDetailsMapper extends EntityMapper<CoordinatesDetailsDTO, CoordinatesDetails> {
    @Mapping(target = "coordinate", source = "coordinate", qualifiedByName = "coordinatesId")
    @Mapping(target = "object", source = "object", qualifiedByName = "targetId")
    CoordinatesDetailsDTO toDto(CoordinatesDetails s);

    @Named("coordinatesId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CoordinatesDTO toDtoCoordinatesId(Coordinates coordinates);

    @Named("targetId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TargetDTO toDtoTargetId(Target target);
}
