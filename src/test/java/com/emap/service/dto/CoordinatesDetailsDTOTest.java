package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CoordinatesDetailsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CoordinatesDetailsDTO.class);
        CoordinatesDetailsDTO coordinatesDetailsDTO1 = new CoordinatesDetailsDTO();
        coordinatesDetailsDTO1.setId(1L);
        CoordinatesDetailsDTO coordinatesDetailsDTO2 = new CoordinatesDetailsDTO();
        assertThat(coordinatesDetailsDTO1).isNotEqualTo(coordinatesDetailsDTO2);
        coordinatesDetailsDTO2.setId(coordinatesDetailsDTO1.getId());
        assertThat(coordinatesDetailsDTO1).isEqualTo(coordinatesDetailsDTO2);
        coordinatesDetailsDTO2.setId(2L);
        assertThat(coordinatesDetailsDTO1).isNotEqualTo(coordinatesDetailsDTO2);
        coordinatesDetailsDTO1.setId(null);
        assertThat(coordinatesDetailsDTO1).isNotEqualTo(coordinatesDetailsDTO2);
    }
}
