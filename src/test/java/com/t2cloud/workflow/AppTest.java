package com.t2cloud.workflow;

import com.t2cloud.workflow.mapper.PortalDepartmentMapper;
import com.t2cloud.workflow.pojo.PortalDepartment;
import com.t2cloud.workflow.pojo.WfTemp;
import com.t2cloud.workflow.pojo.WfTempStep;
import com.t2cloud.workflow.pojo.WfTempUser;
import com.t2cloud.workflow.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class AppTest extends AbstractJUnit4SpringContextTests {


    @Resource
    private WorkflowDefinationService workflowDefinationService;
    @Resource
    private WorkflowInstanceService workflowInstanceService;
    @Resource
    private WorkflowHistoryService workflowHistoryService;
    @Resource
    private PortalRoleService portalRoleService;
    @Resource
    private DepartmentService departmentService;


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
        workflowDefinationService.insertWorkFlowStep(2L,wfTempStep,null);
    }
    @Test
    public void testTask(){

        List<PortalDepartment> list=departmentService.list();
        for(PortalDepartment portalDepartment:list){
            System.out.println(portalDepartment.getName());
        }
    }
    @Test
    public void testTranstion(){
    }


}
