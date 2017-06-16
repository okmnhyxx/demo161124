package com.emi.domain;

import com.emi.common.enums.ContainerType;
import com.emi.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by emi on 2016/11/1.
 */
@Entity
public class Container extends BaseDomain {

    @Id
    @GeneratedValue
    private Long id;

    private String containerNo;

    private String containerSeal;

    private ContainerType containerType;

    private boolean overWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerSeal() {
        return containerSeal;
    }

    public void setContainerSeal(String containerSeal) {
        this.containerSeal = containerSeal;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }

    public boolean isOverWeight() {
        return overWeight;
    }

    public void setOverWeight(boolean overWeight) {
        this.overWeight = overWeight;
    }
}
