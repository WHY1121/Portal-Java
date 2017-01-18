package com.t2cloud.pojo;

import java.util.Date;
import java.util.List;

public class WfTemp {
    private Long tempId;

    private String name;

    private Integer status;

    private Date postTimestamp;

    private String postUserId;

    private Date modifyTimestamp;

    private String modifyUserId;

    private Integer ismodel;

    private String remark;

    private Integer version;

    private Integer isUse;

    //扩展字段
    private List<WfTempStep> wfTempStepList;

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

    public Integer getIsmodel() {
        return ismodel;
    }

    public void setIsmodel(Integer ismodel) {
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

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }
}