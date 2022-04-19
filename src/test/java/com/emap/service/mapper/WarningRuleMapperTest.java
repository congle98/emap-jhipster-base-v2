package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarningRuleMapperTest {

    private WarningRuleMapper warningRuleMapper;

    @BeforeEach
    public void setUp() {
        warningRuleMapper = new WarningRuleMapperImpl();
    }
}
