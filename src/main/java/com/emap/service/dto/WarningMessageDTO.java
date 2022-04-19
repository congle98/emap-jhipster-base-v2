package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.WarningMessage} entity.
 */
public class WarningMessageDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 15)
    private String mcUserId;

    @NotNull
    private String warningDistance;

    @NotNull
    private Boolean showWarningCircle;

    @NotNull
    private Boolean showWarningMessage;

    @Size(max = 255)
    private String warningMessage;

    @NotNull
    private Boolean sendWarningMessageToMc;

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

    private WarningRuleDTO warningRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMcUserId() {
        return mcUserId;
    }

    public void setMcUserId(String mcUserId) {
        this.mcUserId = mcUserId;
    }

    public String getWarningDistance() {
        return warningDistance;
    }

    public void setWarningDistance(String warningDistance) {
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

    public WarningRuleDTO getWarningRule() {
        return warningRule;
    }

    public void setWarningRule(WarningRuleDTO warningRule) {
        this.warningRule = warningRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WarningMessageDTO)) {
            return false;
        }

        WarningMessageDTO warningMessageDTO = (WarningMessageDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, warningMessageDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WarningMessageDTO{" +
            "id=" + getId() +
            ", mcUserId='" + getMcUserId() + "'" +
            ", warningDistance='" + getWarningDistance() + "'" +
            ", showWarningCircle='" + getShowWarningCircle() + "'" +
            ", showWarningMessage='" + getShowWarningMessage() + "'" +
            ", warningMessage='" + getWarningMessage() + "'" +
            ", sendWarningMessageToMc='" + getSendWarningMessageToMc() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            ", warningRule=" + getWarningRule() +
            "}";
    }
}
