package com.t2cloud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class WfTemp {
    @JsonProperty("id")
    private Long tempId;

    private Long typeId;

    private String name;

    private Integer status;

    private Date postTimestamp;

    private String postUserId;

    private Date modifyTimestamp;

    private String modifyUserId;

    private Boolean ismodel;

    private String remark;

    private Integer version;

    @JsonProperty("enabled")
    private Boolean isUse;

    //=============================================扩展字段=====================================
    @JsonProperty("steps")
    private List<WfTempStep> wfTempStepList;

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<WfTempStep> getWfTempStepList() {
        return wfTempStepList;
    }

    public void setWfTempStepList(List<WfTempStep> wfTempStepList) {
        this.wfTempStepList = wfTempStepList;
    }

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPostTimestamp() {
        return postTimestamp;
    }

    public void setPostTimestamp(Date postTimestamp) {
        this.postTimestamp = postTimestamp;
    }

    public String getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(String postUserId) {
        this.postUserId = postUserId == null ? null : postUserId.trim();
    }

    public Date getModifyTimestamp() {
        return modifyTimestamp;
    }

    public void setModifyTimestamp(Date modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public Boolean getIsmodel() {
        return ismodel;
    }

    public void setIsmodel(Boolean ismodel) {
        this.ismodel = ismodel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
    }
}