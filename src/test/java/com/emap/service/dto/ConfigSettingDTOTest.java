package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConfigSettingDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfigSettingDTO.class);
        ConfigSettingDTO configSettingDTO1 = new ConfigSettingDTO();
        configSettingDTO1.setId(1L);
        ConfigSettingDTO configSettingDTO2 = new ConfigSettingDTO();
        assertThat(configSettingDTO1).isNotEqualTo(configSettingDTO2);
        configSettingDTO2.setId(configSettingDTO1.getId());
        assertThat(configSettingDTO1).isEqualTo(configSettingDTO2);
        configSettingDTO2.setId(2L);
        assertThat(configSettingDTO1).isNotEqualTo(configSettingDTO2);
        configSettingDTO1.setId(null);
        assertThat(configSettingDTO1).isNotEqualTo(configSettingDTO2);
    }
}
