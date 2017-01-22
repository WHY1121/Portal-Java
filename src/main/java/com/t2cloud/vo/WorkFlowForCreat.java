package com.t2cloud.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/22
 * Time: 15:53
 * 流程创建类
 */
public class WorkFlowForCreat implements Serializable {

    /**
     *流程名字
     */
    private String name;
    /**
     * 创建用户id
     */
    private String createId;
    /**
     * 是否可用
     */
    private boolean enable;

    /**
     * 流程分类id
     */
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    private List<Step> steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    /**
     * 流程步骤和审核人信息
     */
    public static final class Step {
        /**
         * 步骤名
         */
        private String stepName;
        /**
         * 审核人姓名
         */
        private String name;
        /**
         * 审核人id
         */
        private String dealuser;

        public String getStepName() {
            return stepName;
        }

        public void setStepName(String stepName) {
            this.stepName = stepName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDealuser() {
            return dealuser;
        }

        public void setDealuser(String dealuser) {
            this.dealuser = dealuser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Step step = (Step) o;

            if (stepName != null ? !stepName.equals(step.stepName) : step.stepName != null) return false;
            if (name != null ? !name.equals(step.name) : step.name != null) return false;
            return dealuser != null ? dealuser.equals(step.dealuser) : step.dealuser == null;

        }

        @Override
        public int hashCode() {
            int result = stepName != null ? stepName.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (dealuser != null ? dealuser.hashCode() : 0);
            return result;
        }
    }
}
