package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CoordinatesDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CoordinatesDTO.class);
        CoordinatesDTO coordinatesDTO1 = new CoordinatesDTO();
        coordinatesDTO1.setId(1L);
        CoordinatesDTO coordinatesDTO2 = new CoordinatesDTO();
        assertThat(coordinatesDTO1).isNotEqualTo(coordinatesDTO2);
        coordinatesDTO2.setId(coordinatesDTO1.getId());
        assertThat(coordinatesDTO1).isEqualTo(coordinatesDTO2);
        coordinatesDTO2.setId(2L);
        assertThat(coordinatesDTO1).isNotEqualTo(coordinatesDTO2);
        coordinatesDTO1.setId(null);
        assertThat(coordinatesDTO1).isNotEqualTo(coordinatesDTO2);
    }
}
