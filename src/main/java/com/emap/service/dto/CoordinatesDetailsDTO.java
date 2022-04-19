package com.emap.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.emap.domain.CoordinatesDetails} entity.
 */
public class CoordinatesDetailsDTO implements Serializable {

    private Long id;

    private Integer signalConnectionStrength;

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

    private CoordinatesDTO coordinate;

    private TargetDTO object;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSignalConnectionStrength() {
        return signalConnectionStrength;
    }

    public void setSignalConnectionStrength(Integer signalConnectionStrength) {
        this.signalConnectionStrength = signalConnectionStrength;
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

    public CoordinatesDTO getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinatesDTO coordinate) {
        this.coordinate = coordinate;
    }

    public TargetDTO getObject() {
        return object;
    }

    public void setObject(TargetDTO object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CoordinatesDetailsDTO)) {
            return false;
        }

        CoordinatesDetailsDTO coordinatesDetailsDTO = (CoordinatesDetailsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, coordinatesDetailsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CoordinatesDetailsDTO{" +
            "id=" + getId() +
            ", signalConnectionStrength=" + getSignalConnectionStrength() +
            ", createDate='" + getCreateDate() + "'" +
            ", createUid='" + getCreateUid() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            ", lastUpdateUid='" + getLastUpdateUid() + "'" +
            ", coordinate=" + getCoordinate() +
            ", object=" + getObject() +
            "}";
    }
}
