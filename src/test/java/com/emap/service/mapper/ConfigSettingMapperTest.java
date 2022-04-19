package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigSettingMapperTest {

    private ConfigSettingMapper configSettingMapper;

    @BeforeEach
    public void setUp() {
        configSettingMapper = new ConfigSettingMapperImpl();
    }
}
