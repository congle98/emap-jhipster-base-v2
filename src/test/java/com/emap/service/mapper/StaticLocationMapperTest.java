package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaticLocationMapperTest {

    private StaticLocationMapper staticLocationMapper;

    @BeforeEach
    public void setUp() {
        staticLocationMapper = new StaticLocationMapperImpl();
    }
}
