package com.taoism.discipline.utils;

/**
 * 分页查询返回类型
 * @author tools.49db.cn
 * @version 1.0
 * @date 2022-09-19
 * code 默认 0=失败 1=成功
 */
public class PageRs<T> {
	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回消息
	 */
	private String message;

	/**
	 * 返回内容
	 */
	private T data;

	/**
	 * 页码
	 */
	private int pageNum;

	/**
	 * 单页条数
	 */
	private int pageSize;

	/**
	 * 总条数
	 */
	private Long total;

	public PageRs(){

	}
	public PageRs(boolean success){
		this.code = success?1:0;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public void setPageIn(PageIn pageIn) {
		setPageNum(pageIn.getPageNum());
		setPageSize(pageIn.getPageSize());
	}
}
