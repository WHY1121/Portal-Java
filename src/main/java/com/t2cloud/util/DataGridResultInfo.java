package com.t2cloud.util;

import java.util.Collection;

/**
 * 数据查询列表统一结果类
 * @author Thinkpad
 *
 */
public class DataGridResultInfo {

	//结果集
	private Collection results;
	//分页标识
	private Page page;
    //出错信息提示
	private String message;

	public Collection getResults() {
		return results;
	}

	public void setResults(Collection results) {
		this.results = results;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
