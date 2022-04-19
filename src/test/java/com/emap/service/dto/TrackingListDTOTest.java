package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TrackingListDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrackingListDTO.class);
        TrackingListDTO trackingListDTO1 = new TrackingListDTO();
        trackingListDTO1.setId(1L);
        TrackingListDTO trackingListDTO2 = new TrackingListDTO();
        assertThat(trackingListDTO1).isNotEqualTo(trackingListDTO2);
        trackingListDTO2.setId(trackingListDTO1.getId());
        assertThat(trackingListDTO1).isEqualTo(trackingListDTO2);
        trackingListDTO2.setId(2L);
        assertThat(trackingListDTO1).isNotEqualTo(trackingListDTO2);
        trackingListDTO1.setId(null);
        assertThat(trackingListDTO1).isNotEqualTo(trackingListDTO2);
    }
}
