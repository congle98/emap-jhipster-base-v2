package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackingListMapperTest {

    private TrackingListMapper trackingListMapper;

    @BeforeEach
    public void setUp() {
        trackingListMapper = new TrackingListMapperImpl();
    }
}
