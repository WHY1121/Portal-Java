package com.t2cloud.pojo;

public class WfTempUser {
    private Long id;

    private Long stepId;

    private String handlerId;

    private String handlerName;

    private Long handleRole;

    private String other;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Long getstepId() {
        return stepId;
    }

    public void setstepId(Long stepId) {
        this.stepId = stepId;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId == null ? null : handlerId.trim();
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName == null ? null : handlerName.trim();
    }

    public Long getHandleRole() {
        return handleRole;
    }

    public void setHandleRole(Long handleRole) {
        this.handleRole = handleRole;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}