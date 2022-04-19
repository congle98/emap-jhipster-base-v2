package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TrackingListDetailsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrackingListDetailsDTO.class);
        TrackingListDetailsDTO trackingListDetailsDTO1 = new TrackingListDetailsDTO();
        trackingListDetailsDTO1.setId(1L);
        TrackingListDetailsDTO trackingListDetailsDTO2 = new TrackingListDetailsDTO();
        assertThat(trackingListDetailsDTO1).isNotEqualTo(trackingListDetailsDTO2);
        trackingListDetailsDTO2.setId(trackingListDetailsDTO1.getId());
        assertThat(trackingListDetailsDTO1).isEqualTo(trackingListDetailsDTO2);
        trackingListDetailsDTO2.setId(2L);
        assertThat(trackingListDetailsDTO1).isNotEqualTo(trackingListDetailsDTO2);
        trackingListDetailsDTO1.setId(null);
        assertThat(trackingListDetailsDTO1).isNotEqualTo(trackingListDetailsDTO2);
    }
}
