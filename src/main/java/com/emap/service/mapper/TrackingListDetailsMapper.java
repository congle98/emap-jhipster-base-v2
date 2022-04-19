package com.emap.service.mapper;

import com.emap.domain.Target;
import com.emap.domain.TrackingList;
import com.emap.domain.TrackingListDetails;
import com.emap.service.dto.TargetDTO;
import com.emap.service.dto.TrackingListDTO;
import com.emap.service.dto.TrackingListDetailsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TrackingListDetails} and its DTO {@link TrackingListDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface TrackingListDetailsMapper extends EntityMapper<TrackingListDetailsDTO, TrackingListDetails> {
    @Mapping(target = "trackingList", source = "trackingList", qualifiedByName = "trackingListId")
    @Mapping(target = "mcTarget", source = "mcTarget", qualifiedByName = "targetId")
    TrackingListDetailsDTO toDto(TrackingListDetails s);

    @Named("trackingListId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TrackingListDTO toDtoTrackingListId(TrackingList trackingList);

    @Named("targetId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TargetDTO toDtoTargetId(Target target);
}
