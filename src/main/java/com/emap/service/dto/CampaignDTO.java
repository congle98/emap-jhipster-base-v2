package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.Campaign} entity.
 */
public class CampaignDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String sourceType;

    @Size(max = 15)
    private String mcCampaingnId;

    @Size(max = 15)
    private String tmlCampaignId;

    @Size(max = 225)
    private String icon;

    @Size(max = 20)
    private String color;

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

    public String getMcCampaingnId() {
        return mcCampaingnId;
    }

    public void setMcCampaingnId(String mcCampaingnId) {
        this.mcCampaingnId = mcCampaingnId;
    }

    public String getTmlCampaignId() {
        return tmlCampaignId;
    }

    public void setTmlCampaignId(String tmlCampaignId) {
        this.tmlCampaignId = tmlCampaignId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        if (!(o instanceof CampaignDTO)) {
            return false;
        }

        CampaignDTO campaignDTO = (CampaignDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, campaignDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CampaignDTO{" +
            "id=" + getId() +
            ", sourceType='" + getSourceType() + "'" +
            ", mcCampaingnId='" + getMcCampaingnId() + "'" +
            ", tmlCampaignId='" + getTmlCampaignId() + "'" +
            ", icon='" + getIcon() + "'" +
            ", color='" + getColor() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            "}";
    }
}
