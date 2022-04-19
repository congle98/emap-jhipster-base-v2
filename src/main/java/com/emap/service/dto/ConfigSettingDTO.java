package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.ConfigSetting} entity.
 */
public class ConfigSettingDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String sourceType;

    @Size(max = 15)
    private String mcUserId;

    @Size(max = 15)
    private String tmlUserId;

    @NotNull
    @Size(max = 20)
    private String vmSysDefaultModeConf;

    @NotNull
    private Integer vmSysSyncCycleConf;

    @NotNull
    private String vmSysSyncCycleUnitConf;

    @NotNull
    @Size(max = 20)
    private String vmSysTargetDisplayNameConf;

    @NotNull
    private String vmLiveDefaultModeConf;

    @NotNull
    private String vmLiveDefaultTimerangeConf;

    @NotNull
    private Integer vmLivePositionCycleConf;

    @NotNull
    private String vmLivePositionCycleUnitConf;

    @NotNull
    private Integer vmLiveTrackingAmplitudeConf;

    @NotNull
    private String vmLiveTrackingAmplitudeUnitConf;

    @NotNull
    private Integer sarSysSyncCycleConf;

    @NotNull
    private String sarSysSyncCycleUnitConf;

    @NotNull
    @Size(max = 255)
    private String sarSysObjectDisplayName01Conf;

    @NotNull
    @Size(max = 255)
    private String sarSysObjectDisplayName02Conf;

    @NotNull
    private Instant createDate;

    @NotNull
    @Size(max = 15)
    private String createUid;

    @NotNull
    private Instant lastUpdate;

    @NotNull
    @Size(max = 15)
    private String lastUpdateUid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getMcUserId() {
        return mcUserId;
    }

    public void setMcUserId(String mcUserId) {
        this.mcUserId = mcUserId;
    }

    public String getTmlUserId() {
        return tmlUserId;
    }

    public void setTmlUserId(String tmlUserId) {
        this.tmlUserId = tmlUserId;
    }

    public String getVmSysDefaultModeConf() {
        return vmSysDefaultModeConf;
    }

    public void setVmSysDefaultModeConf(String vmSysDefaultModeConf) {
        this.vmSysDefaultModeConf = vmSysDefaultModeConf;
    }

    public Integer getVmSysSyncCycleConf() {
        return vmSysSyncCycleConf;
    }

    public void setVmSysSyncCycleConf(Integer vmSysSyncCycleConf) {
        this.vmSysSyncCycleConf = vmSysSyncCycleConf;
    }

    public String getVmSysSyncCycleUnitConf() {
        return vmSysSyncCycleUnitConf;
    }

    public void setVmSysSyncCycleUnitConf(String vmSysSyncCycleUnitConf) {
        this.vmSysSyncCycleUnitConf = vmSysSyncCycleUnitConf;
    }

    public String getVmSysTargetDisplayNameConf() {
        return vmSysTargetDisplayNameConf;
    }

    public void setVmSysTargetDisplayNameConf(String vmSysTargetDisplayNameConf) {
        this.vmSysTargetDisplayNameConf = vmSysTargetDisplayNameConf;
    }

    public String getVmLiveDefaultModeConf() {
        return vmLiveDefaultModeConf;
    }

    public void setVmLiveDefaultModeConf(String vmLiveDefaultModeConf) {
        this.vmLiveDefaultModeConf = vmLiveDefaultModeConf;
    }

    public String getVmLiveDefaultTimerangeConf() {
        return vmLiveDefaultTimerangeConf;
    }

    public void setVmLiveDefaultTimerangeConf(String vmLiveDefaultTimerangeConf) {
        this.vmLiveDefaultTimerangeConf = vmLiveDefaultTimerangeConf;
    }

    public Integer getVmLivePositionCycleConf() {
        return vmLivePositionCycleConf;
    }

    public void setVmLivePositionCycleConf(Integer vmLivePositionCycleConf) {
        this.vmLivePositionCycleConf = vmLivePositionCycleConf;
    }

    public String getVmLivePositionCycleUnitConf() {
        return vmLivePositionCycleUnitConf;
    }

    public void setVmLivePositionCycleUnitConf(String vmLivePositionCycleUnitConf) {
        this.vmLivePositionCycleUnitConf = vmLivePositionCycleUnitConf;
    }

    public Integer getVmLiveTrackingAmplitudeConf() {
        return vmLiveTrackingAmplitudeConf;
    }

    public void setVmLiveTrackingAmplitudeConf(Integer vmLiveTrackingAmplitudeConf) {
        this.vmLiveTrackingAmplitudeConf = vmLiveTrackingAmplitudeConf;
    }

    public String getVmLiveTrackingAmplitudeUnitConf() {
        return vmLiveTrackingAmplitudeUnitConf;
    }

    public void setVmLiveTrackingAmplitudeUnitConf(String vmLiveTrackingAmplitudeUnitConf) {
        this.vmLiveTrackingAmplitudeUnitConf = vmLiveTrackingAmplitudeUnitConf;
    }

    public Integer getSarSysSyncCycleConf() {
        return sarSysSyncCycleConf;
    }

    public void setSarSysSyncCycleConf(Integer sarSysSyncCycleConf) {
        this.sarSysSyncCycleConf = sarSysSyncCycleConf;
    }

    public String getSarSysSyncCycleUnitConf() {
        return sarSysSyncCycleUnitConf;
    }

    public void setSarSysSyncCycleUnitConf(String sarSysSyncCycleUnitConf) {
        this.sarSysSyncCycleUnitConf = sarSysSyncCycleUnitConf;
    }

    public String getSarSysObjectDisplayName01Conf() {
        return sarSysObjectDisplayName01Conf;
    }

    public void setSarSysObjectDisplayName01Conf(String sarSysObjectDisplayName01Conf) {
        this.sarSysObjectDisplayName01Conf = sarSysObjectDisplayName01Conf;
    }

    public String getSarSysObjectDisplayName02Conf() {
        return sarSysObjectDisplayName02Conf;
    }

    public void setSarSysObjectDisplayName02Conf(String sarSysObjectDisplayName02Conf) {
        this.sarSysObjectDisplayName02Conf = sarSysObjectDisplayName02Conf;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateUid() {
        return lastUpdateUid;
    }

    public void setLastUpdateUid(String lastUpdateUid) {
        this.lastUpdateUid = lastUpdateUid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConfigSettingDTO)) {
            return false;
        }

        ConfigSettingDTO configSettingDTO = (ConfigSettingDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, configSettingDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConfigSettingDTO{" +
            "id=" + getId() +
            ", sourceType='" + getSourceType() + "'" +
            ", mcUserId='" + getMcUserId() + "'" +
            ", tmlUserId='" + getTmlUserId() + "'" +
            ", vmSysDefaultModeConf='" + getVmSysDefaultModeConf() + "'" +
            ", vmSysSyncCycleConf=" + getVmSysSyncCycleConf() +
            ", vmSysSyncCycleUnitConf='" + getVmSysSyncCycleUnitConf() + "'" +
            ", vmSysTargetDisplayNameConf='" + getVmSysTargetDisplayNameConf() + "'" +
            ", vmLiveDefaultModeConf='" + getVmLiveDefaultModeConf() + "'" +
            ", vmLiveDefaultTimerangeConf='" + getVmLiveDefaultTimerangeConf() + "'" +
            ", vmLivePositionCycleConf=" + getVmLivePositionCycleConf() +
            ", vmLivePositionCycleUnitConf='" + getVmLivePositionCycleUnitConf() + "'" +
            ", vmLiveTrackingAmplitudeConf=" + getVmLiveTrackingAmplitudeConf() +
            ", vmLiveTrackingAmplitudeUnitConf='" + getVmLiveTrackingAmplitudeUnitConf() + "'" +
            ", sarSysSyncCycleConf=" + getSarSysSyncCycleConf() +
            ", sarSysSyncCycleUnitConf='" + getSarSysSyncCycleUnitConf() + "'" +
            ", sarSysObjectDisplayName01Conf='" + getSarSysObjectDisplayName01Conf() + "'" +
            ", sarSysObjectDisplayName02Conf='" + getSarSysObjectDisplayName02Conf() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            "}";
    }
}
