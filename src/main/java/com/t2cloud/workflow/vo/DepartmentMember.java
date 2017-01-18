package com.t2cloud.workflow.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/18
 * Time: 9:22
 * 部门包装对象
 */
public class DepartmentMember implements Serializable {


    private Long id;

    private String name;

    private String post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
