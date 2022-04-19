package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarningMessageMapperTest {

    private WarningMessageMapper warningMessageMapper;

    @BeforeEach
    public void setUp() {
        warningMessageMapper = new WarningMessageMapperImpl();
    }
}
