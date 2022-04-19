package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.WarningRule} entity.
 */
public class WarningRuleDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 15)
    private String mcUserId;

    @NotNull
    private Integer delayCheck;

    @NotNull
    @Size(max = 15)
    private String delayCheckUnit;

    @NotNull
    @Size(max = 20)
    private String conditionType;

    @Size(max = 15)
    private String includeMcCampaignId;

    @Size(max = 15)
    private String includeMcTargetId;

    @NotNull
    private Integer warningDistance;

    @NotNull
    private Boolean showWarningCircle;

    @NotNull
    private Boolean showWarningMessage;

    @Size(max = 255)
    private String warningMessage;

    @NotNull
    private Boolean sendWarningMessageToMc;

    @NotNull
    private Boolean status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMcUserId() {
        return mcUserId;
    }

    public void setMcUserId(String mcUserId) {
        this.mcUserId = mcUserId;
    }

    public Integer getDelayCheck() {
        return delayCheck;
    }

    public void setDelayCheck(Integer delayCheck) {
        this.delayCheck = delayCheck;
    }

    public String getDelayCheckUnit() {
        return delayCheckUnit;
    }

    public void setDelayCheckUnit(String delayCheckUnit) {
        this.delayCheckUnit = delayCheckUnit;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getIncludeMcCampaignId() {
        return includeMcCampaignId;
    }

    public void setIncludeMcCampaignId(String includeMcCampaignId) {
        this.includeMcCampaignId = includeMcCampaignId;
    }

    public String getIncludeMcTargetId() {
        return includeMcTargetId;
    }

    public void setIncludeMcTargetId(String includeMcTargetId) {
        this.includeMcTargetId = includeMcTargetId;
    }

    public Integer getWarningDistance() {
        return warningDistance;
    }

    public void setWarningDistance(Integer warningDistance) {
        this.warningDistance = warningDistance;
    }

    public Boolean getShowWarningCircle() {
        return showWarningCircle;
    }

    public void setShowWarningCircle(Boolean showWarningCircle) {
        this.showWarningCircle = showWarningCircle;
    }

    public Boolean getShowWarningMessage() {
        return showWarningMessage;
    }

    public void setShowWarningMessage(Boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public Boolean getSendWarningMessageToMc() {
        return sendWarningMessageToMc;
    }

    public void setSendWarningMessageToMc(Boolean sendWarningMessageToMc) {
        this.sendWarningMessageToMc = sendWarningMessageToMc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        if (!(o instanceof WarningRuleDTO)) {
            return false;
        }

        WarningRuleDTO warningRuleDTO = (WarningRuleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, warningRuleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WarningRuleDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", mcUserId='" + getMcUserId() + "'" +
            ", delayCheck=" + getDelayCheck() +
            ", delayCheckUnit='" + getDelayCheckUnit() + "'" +
            ", conditionType='" + getConditionType() + "'" +
            ", includeMcCampaignId='" + getIncludeMcCampaignId() + "'" +
            ", includeMcTargetId='" + getIncludeMcTargetId() + "'" +
            ", warningDistance=" + getWarningDistance() +
            ", showWarningCircle='" + getShowWarningCircle() + "'" +
            ", showWarningMessage='" + getShowWarningMessage() + "'" +
            ", warningMessage='" + getWarningMessage() + "'" +
            ", sendWarningMessageToMc='" + getSendWarningMessageToMc() + "'" +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            "}";
    }
}
