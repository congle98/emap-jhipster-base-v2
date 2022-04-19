package com.emap.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackingListDetailsMapperTest {

    private TrackingListDetailsMapper trackingListDetailsMapper;

    @BeforeEach
    public void setUp() {
        trackingListDetailsMapper = new TrackingListDetailsMapperImpl();
    }
}
