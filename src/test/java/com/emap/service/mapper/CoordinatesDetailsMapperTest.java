package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordinatesDetailsMapperTest {

    private CoordinatesDetailsMapper coordinatesDetailsMapper;

    @BeforeEach
    public void setUp() {
        coordinatesDetailsMapper = new CoordinatesDetailsMapperImpl();
    }
}
