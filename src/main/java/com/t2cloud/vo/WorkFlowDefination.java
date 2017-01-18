package com.t2cloud.vo;

import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempStep;
import com.t2cloud.pojo.WfTempUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 10:53
 */
public class WorkFlowDefination {

    private WfTemp wfTemp;

    private List<WfTempStep> wfTempStep;

    private List<WfTempUser> wfTempUser;

    public WfTemp getWfTemp() {
        return wfTemp;
    }

    public void setWfTemp(WfTemp wfTemp) {
        this.wfTemp = wfTemp;
    }

    public List<WfTempStep> getWfTempStep() {
        return wfTempStep;
    }

    public void setWfTempStep(List<WfTempStep> wfTempStep) {
        this.wfTempStep = wfTempStep;
    }

    public List<WfTempUser> getWfTempUser() {
        return wfTempUser;
    }

    public void setWfTempUser(List<WfTempUser> wfTempUser) {
        this.wfTempUser = wfTempUser;
    }
}
