package com.emap.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.emap.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class WarningRuleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WarningRuleDTO.class);
        WarningRuleDTO warningRuleDTO1 = new WarningRuleDTO();
        warningRuleDTO1.setId(1L);
        WarningRuleDTO warningRuleDTO2 = new WarningRuleDTO();
        assertThat(warningRuleDTO1).isNotEqualTo(warningRuleDTO2);
        warningRuleDTO2.setId(warningRuleDTO1.getId());
        assertThat(warningRuleDTO1).isEqualTo(warningRuleDTO2);
        warningRuleDTO2.setId(2L);
        assertThat(warningRuleDTO1).isNotEqualTo(warningRuleDTO2);
        warningRuleDTO1.setId(null);
        assertThat(warningRuleDTO1).isNotEqualTo(warningRuleDTO2);
    }
}
