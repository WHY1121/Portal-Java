package com.t2cloud.workflow.controller;

import com.t2cloud.workflow.pojo.WfTemp;
import com.t2cloud.workflow.service.WorkflowDefinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:13
 * 流程定义控制器
 */
@RestController
public class WorkflowDefinationController {
    @Autowired
    private WorkflowDefinationService workflowDefinationService;

    /**
     * 流程定义
     *
     * @return
     */
    @RequestMapping("/saveWorkFlow")
    public void saveWorkFlow(WfTemp wfTemp) {
        workflowDefinationService.insertWorkFlow(wfTemp);
    }

    /**
     * 流程修改（不是model）
     *
     * @return
     */
    @RequestMapping("/update")
    public String update() {


        return "hello world";
    }

    /**
     * 删除流程（下面没有流程实例）
     *
     * @return
     */
    @RequestMapping("/delete")
    public String delete() {


        return "hello world";
    }

    /**
     * 流程定义列表（管理员看到所有，普通成员看到的都是模版）
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {


        return "hello world";
    }
}
