package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class WarningMessageDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WarningMessageDTO.class);
        WarningMessageDTO warningMessageDTO1 = new WarningMessageDTO();
        warningMessageDTO1.setId(1L);
        WarningMessageDTO warningMessageDTO2 = new WarningMessageDTO();
        assertThat(warningMessageDTO1).isNotEqualTo(warningMessageDTO2);
        warningMessageDTO2.setId(warningMessageDTO1.getId());
        assertThat(warningMessageDTO1).isEqualTo(warningMessageDTO2);
        warningMessageDTO2.setId(2L);
        assertThat(warningMessageDTO1).isNotEqualTo(warningMessageDTO2);
        warningMessageDTO1.setId(null);
        assertThat(warningMessageDTO1).isNotEqualTo(warningMessageDTO2);
    }
}
