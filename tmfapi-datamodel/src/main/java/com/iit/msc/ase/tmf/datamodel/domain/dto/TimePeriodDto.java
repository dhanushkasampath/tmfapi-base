package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class TimePeriodDto {

    @JsonIgnore
    private long primaryId;
    @JsonIgnore
    private String parentEntity;
    @JsonIgnore
    private String parentId;
    @JsonIgnore
    private String immediateParent;
    @JsonIgnore
    private String immediateParentId;

    private String startDateTime;
    private String endDateTime;

    @Override
    public String toString() {
        return "TimePeriod{" +
                "primaryId=" + primaryId +
                ", parentEntity='" + parentEntity + '\'' +
                ", parentId='" + parentId + '\'' +
                ", immediateParent='" + immediateParent + '\'' +
                ", immediateParentId='" + immediateParentId + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                '}';
    }

}
