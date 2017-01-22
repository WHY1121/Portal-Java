package com.t2cloud.util;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 17:46
 * 流程变量静态常量
 */
public class WorkFlowConstance {


    /* ===============全局变量开始=============== */
    public final static Integer NO = 0;// 否
    public final static Integer YES = 1;// 是

    // 提醒方式
    public final static Integer WEB = 1;// 站内web
    public final static Integer MESSAGE = 3;// 短信
    public final static Integer WEB_AND_MESSAGE = 4;// 站内和短信
    public final static Integer EMAIL = 5;// 邮件
    public final static Integer WEB_AND_EMAIL = 6;// 站内和邮件
    public final static Integer MESSAGE_AND_EMAIL = 8;// 短信和邮件
    public final static Integer WEB_MESSAGE_EMAIL = 9;// web、短信和邮件

    // 审批流程状态
    public final static Integer NEW = 1;// 新建
    public final static Integer NOT_APPROVE = 2;// 待审批
    public final static Integer IN_APPROVE = 3;// 审批中
    public final static Integer NOT_PASS_APPROVE = 4;// 审批未通过
    public final static Integer PASS_APPROVE = 5;// 审批通过
    public final static Integer REJECT = 6;// 驳回
    public final static Integer CANCEL = 7;// 作废


    // 审批流程步骤状态
    public final static Integer PASS = 1;// 通过
    public final static Integer NOT_PASS = 0;// 不通过


    //流程模版状态
    public final static Integer NEWCREATE = 0;// 新建
    public final static Integer DEPLOY = 1;// 发布
    public final static Integer EXPIRE = 2;// 失效


    public final static Integer WORKFLOW_STATUS_CHANGED = 1;// 审批流程状态已经改变
    public final static Integer PROCESS_CHANGED = 2;// 审批流程状态已经改变
    public final static Integer NEW_CHANGED = 3;// 审批流程状态已经改变
    public final static String WORKFLOW_INFO = "WORKFLOW_INFO";// 改变的审批流程
    public final static String WORKFLOW_PROCESS = "WORKFLOW_PROCESS";// 改变的审批节点
    /* ===============全局变量结束=============== */
}
