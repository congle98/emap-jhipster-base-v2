package com.emap.service.mapper;

import com.emap.domain.ConfigSetting;
import com.emap.service.dto.ConfigSettingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConfigSetting} and its DTO {@link ConfigSettingDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConfigSettingMapper extends EntityMapper<ConfigSettingDTO, ConfigSetting> {}
