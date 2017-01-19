package com.t2cloud;

import com.google.common.collect.Maps;
import com.t2cloud.mapper.PortalUserMapper;
import com.t2cloud.mapper.WfInstanceStepMapper;
import com.t2cloud.pojo.*;
import com.t2cloud.service.*;
import com.t2cloud.vo.WfTaskBo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class AppTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private WorkflowDefinationService workflowDefinationService;
    @Autowired
    private WorkflowInstanceService workflowInstanceService;
    @Autowired
    private WorkflowHistoryService workflowHistoryService;
    @Autowired
    private PortalRoleService portalRoleService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PortalUserMapper portalUserMapper;
    @Resource
    private WfInstanceStepMapper wfInstanceStepMapper;


    @Test
    public void testWfDefination() {

    }

    @Test
    public void testTemp(){
        //添加一个请假流程
        WfTemp wfTemp=new WfTemp();
        wfTemp.setName("请假流程");
        wfTemp.setStatus(0);
        wfTemp.setPostUserId("1121");
        wfTemp.setIsmodel(0);
        wfTemp.setVersion(1);
        wfTemp.setRemark("测试流程");
        workflowDefinationService.insertWorkFlow(wfTemp);

    }
    @Test
    public void testTempStep(){
        WfTempStep wfTempStep=new WfTempStep();
        wfTempStep.setName("结束");
        wfTempStep.setOrderNo(4);
//        wfTempStep.setType(0);
//        wfTempStep.setStepType(0);
        wfTempStep.setIsLast(1);
//        wfTempStep.setDeadline(1000L);
        wfTempStep.setIsaudit(0);
        wfTempStep.setIsauto(0);
        wfTempStep.setRebut(0);
//        WfTempUser wfTempUser=new WfTempUser();
//        wfTempUser.setHandlerId("1122");
//        wfTempUser.setHandlerName("why888");
//        wfTempUser.setHandleRole(2L);
//        workflowDefinationService.insertWorkFlowStep(2L,wfTempStep,null);
    }
    @Test
    public void testTask(){

//        WfInstanceStep wfInstanceStep=new WfInstanceStep();
//        wfInstanceStep.setInstanceId(111L);
//        wfInstanceStepMapper.selectBySelective(wfInstanceStep);
        List<WfTaskBo> wfTaskBos = workflowInstanceService.waitWorkFlowProcess(1121L);
        System.out.println(wfTaskBos);

    }
    @Test
    public void testTranstion(){
        WfInstance wfInstance=new WfInstance();
        wfInstance.setTempId(2L);
        wfInstance.setName("请假流程");
        wfInstance.setCreateId("1121");
        wfInstance.setCreateName("why");
        wfInstance.setUrgent(1);
       workflowInstanceService.workflowProcess(wfInstance);

    }


}
