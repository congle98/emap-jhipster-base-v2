package com.emap.service.mapper;

import com.emap.domain.WarningMessage;
import com.emap.domain.WarningRule;
import com.emap.service.dto.WarningMessageDTO;
import com.emap.service.dto.WarningRuleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link WarningMessage} and its DTO {@link WarningMessageDTO}.
 */
@Mapper(componentModel = "spring")
public interface WarningMessageMapper extends EntityMapper<WarningMessageDTO, WarningMessage> {
    @Mapping(target = "warningRule", source = "warningRule", qualifiedByName = "warningRuleId")
    WarningMessageDTO toDto(WarningMessage s);

    @Named("warningRuleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    WarningRuleDTO toDtoWarningRuleId(WarningRule warningRule);
}
