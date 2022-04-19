package com.emap.service.mapper;

import com.emap.domain.TrackingList;
import com.emap.service.dto.TrackingListDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TrackingList} and its DTO {@link TrackingListDTO}.
 */
@Mapper(componentModel = "spring")
public interface TrackingListMapper extends EntityMapper<TrackingListDTO, TrackingList> {}
