package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StaticLocationDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StaticLocationDTO.class);
        StaticLocationDTO staticLocationDTO1 = new StaticLocationDTO();
        staticLocationDTO1.setId(1L);
        StaticLocationDTO staticLocationDTO2 = new StaticLocationDTO();
        assertThat(staticLocationDTO1).isNotEqualTo(staticLocationDTO2);
        staticLocationDTO2.setId(staticLocationDTO1.getId());
        assertThat(staticLocationDTO1).isEqualTo(staticLocationDTO2);
        staticLocationDTO2.setId(2L);
        assertThat(staticLocationDTO1).isNotEqualTo(staticLocationDTO2);
        staticLocationDTO1.setId(null);
        assertThat(staticLocationDTO1).isNotEqualTo(staticLocationDTO2);
    }
}
