package com.t2cloud.controller;

import com.t2cloud.pojo.WfTemp;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.vo.WorkFlowForCreat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:13
 * 流程定义控制器
 */
@RestController
@RequestMapping("/workflows")
public class WorkflowDefinationController {
    @Autowired
    private WorkflowDefinationService workflowDefinationService;

    /**
     * 流程定义
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestParam WorkFlowForCreat flowForCreat) {
        workflowDefinationService.insertWorkFlow(flowForCreat);
    }

    /**
     * 流程修改
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") Long id, @RequestParam WorkFlowForCreat flowForCreat) {
        workflowDefinationService.update(id, flowForCreat);
    }

    /**
     * 删除流程（下面没有流程实例）
     *
     * @return
     */
    @RequestMapping(value = "/deleteMulti", method = RequestMethod.POST)
    public void delete(@RequestParam(value = "tempIds[]") Long[] tempIds) {
        workflowDefinationService.delete(tempIds);
    }

    /**
     * 流程定义列表（管理员看到所有，普通成员看到的都是模版）
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<WfTemp> list() {
        List<WfTemp> list = workflowDefinationService.list();
        return list;
    }

    /**
     * 流程启用和禁用
     */
    @RequestMapping(value = "/enable/{id}", method = RequestMethod.PUT)
    public void updateStatus(@PathVariable(value = "id") Long id, boolean enable) {
        workflowDefinationService.updateStatus(id, enable);
    }

}
