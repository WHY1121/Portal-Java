package com.t2cloud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WfTempStep {
    @JsonProperty("id")
    private Long stepId;

    private Long tempId;

    private String name;

    private Integer type;

    private Integer stepType;

    @JsonProperty("mode")
    private Integer orderNo;

    private Long superId;

    private Long nextId;

    private Boolean isLast;

    private Long deadline;

    private Boolean isaudit;

    private Boolean isauto;

    private Boolean rebut;

    private Integer rebutFlag;

    private Long extend1;

    //扩展字段
    @JsonProperty("dealuser")
    private List<WfTempUser> tempUsers;

    public List<WfTempUser> getTempUsers() {
        return tempUsers;
    }

    public void setTempUsers(List<WfTempUser> tempUsers) {
        this.tempUsers = tempUsers;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStepType() {
        return stepType;
    }

    public void setStepType(Integer stepType) {
        this.stepType = stepType;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Boolean getIsaudit() {
        return isaudit;
    }

    public void setIsaudit(Boolean isaudit) {
        this.isaudit = isaudit;
    }

    public Boolean getIsauto() {
        return isauto;
    }

    public void setIsauto(Boolean isauto) {
        this.isauto = isauto;
    }

    public Boolean getRebut() {
        return rebut;
    }

    public void setRebut(Boolean rebut) {
        this.rebut = rebut;
    }

    public Integer getRebutFlag() {
        return rebutFlag;
    }

    public void setRebutFlag(Integer rebutFlag) {
        this.rebutFlag = rebutFlag;
    }

    public Long getExtend1() {
        return extend1;
    }

    public void setExtend1(Long extend1) {
        this.extend1 = extend1;
    }
}