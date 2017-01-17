package com.t2cloud.workflow.pojo;

public class WfTempStep {
    private Long stepId;

    private Long tempId;

    private String name;

    private Integer type;

    private Integer stepType;

    private Integer orderNo;

    private Long superId;

    private Long nextId;

    private Integer isLast;

    private Long deadline;

    private Integer isaudit;

    private Integer isauto;

    private Integer rebut;

    private Integer rebutFlag;

    private Long extend1;

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

    public Integer getIsLast() {
        return isLast;
    }

    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Integer getIsaudit() {
        return isaudit;
    }

    public void setIsaudit(Integer isaudit) {
        this.isaudit = isaudit;
    }

    public Integer getIsauto() {
        return isauto;
    }

    public void setIsauto(Integer isauto) {
        this.isauto = isauto;
    }

    public Integer getRebut() {
        return rebut;
    }

    public void setRebut(Integer rebut) {
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