package com.emap.service.mapper;

import com.emap.domain.WarningRule;
import com.emap.service.dto.WarningRuleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link WarningRule} and its DTO {@link WarningRuleDTO}.
 */
@Mapper(componentModel = "spring")
public interface WarningRuleMapper extends EntityMapper<WarningRuleDTO, WarningRule> {}
