package com.t2cloud.service.impl;

import com.t2cloud.service.WorkflowHistoryService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:17
 * 流程实例历史查询
 */
@Service(value = "workflowHistoryService")
public class WorkflowHistoyServiceImpl implements WorkflowHistoryService{




    /**
     * 管理员历史查询
     */
    @Override
    public void finishAllWorkFlow() {

        //按条件   审批完、审批中、审批失败等


        //显示流程信息，流程步骤，以及流程审批人信息



    }
}
