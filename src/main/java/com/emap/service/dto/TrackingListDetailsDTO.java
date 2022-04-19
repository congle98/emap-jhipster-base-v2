package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.TrackingListDetails} entity.
 */
public class TrackingListDetailsDTO implements Serializable {

    private Long id;

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

    private TrackingListDTO trackingList;

    private TargetDTO mcTarget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TrackingListDTO getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(TrackingListDTO trackingList) {
        this.trackingList = trackingList;
    }

    public TargetDTO getMcTarget() {
        return mcTarget;
    }

    public void setMcTarget(TargetDTO mcTarget) {
        this.mcTarget = mcTarget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TrackingListDetailsDTO)) {
            return false;
        }

        TrackingListDetailsDTO trackingListDetailsDTO = (TrackingListDetailsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, trackingListDetailsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TrackingListDetailsDTO{" +
            "id=" + getId() +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            ", trackingList=" + getTrackingList() +
            ", mcTarget=" + getMcTarget() +
            "}";
    }
}
