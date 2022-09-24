package com.taoism.discipline.utils;

/**
 * 分页查询请求参数基础类-建议请求参数封装类继承此类
 * @author tools.49db.cn
 * @version 1.0
 * @date 2022-09-19
 */
public class PageIn {
	/**
	 * 一页条数
	 */
	private int pageSize=15;

	/**
	 * 页码
	 */
	private int pageNum = 1;
	/**
	 * 分页查询起始位置，根据page limit 自动计算，无需入参
	 */
	private int begin = 0;
	/**
	 * 是否启用分页标志位，以便复用service方法，但是需要自己在example.setPage前判断，默认启用
	 */
	private boolean pageEnable = true;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getBegin() {
		if(0!=pageNum && 0!= pageSize)this.begin =(pageNum-1)*pageSize;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public boolean isPageEnable() {
		return pageEnable;
	}

	public void setPageEnable(boolean pageEnable) {
		this.pageEnable = pageEnable;
	}
}
