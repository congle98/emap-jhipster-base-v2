package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.Coordinates} entity.
 */
public class CoordinatesDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String sourceType;

    @Size(max = 15)
    private String mcCampaingnId;

    @Size(max = 15)
    private String tmlCampaignId;

    @Size(max = 15)
    private String lat;

    @Size(max = 15)
    private String lng;

    private Double radius;

    private Integer openAngle;

    private Integer directionalAngle;

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getOpenAngle() {
        return openAngle;
    }

    public void setOpenAngle(Integer openAngle) {
        this.openAngle = openAngle;
    }

    public Integer getDirectionalAngle() {
        return directionalAngle;
    }

    public void setDirectionalAngle(Integer directionalAngle) {
        this.directionalAngle = directionalAngle;
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
        if (!(o instanceof CoordinatesDTO)) {
            return false;
        }

        CoordinatesDTO coordinatesDTO = (CoordinatesDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, coordinatesDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CoordinatesDTO{" +
            "id=" + getId() +
            ", sourceType='" + getSourceType() + "'" +
            ", mcCampaingnId='" + getMcCampaingnId() + "'" +
            ", tmlCampaignId='" + getTmlCampaignId() + "'" +
            ", lat='" + getLat() + "'" +
            ", lng='" + getLng() + "'" +
            ", radius=" + getRadius() +
            ", openAngle=" + getOpenAngle() +
            ", directionalAngle=" + getDirectionalAngle() +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            "}";
    }
}
