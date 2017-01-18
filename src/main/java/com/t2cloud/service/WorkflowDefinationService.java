package com.t2cloud.service;

import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.vo.WorkFlowDefination;
import com.t2cloud.pojo.WfTempStep;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:14
 */
public interface WorkflowDefinationService {

    /**
     *   定义模版
     */
    void insertWorkFlow(WfTemp wfTemp);

    /**
     * 定义步骤
     */
    void insertWorkFlowStep(Long workFlowId, WfTempStep wfTempStep,WfTempUser wfTempUser);

    void list();

    void update(WorkFlowDefination flowDefination) throws Exception;

    void delete(String tempId);

    /**
     * 查询模版详情
     * @param tempId
     * @return
     */
    WfTemp show(Long tempId);


}
