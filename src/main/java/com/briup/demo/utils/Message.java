package com.briup.demo.utils;
/**
 * 自定义相应返回类型
 * @author lzp
 *
 */
public class Message<T> {
	/**
	 * 状态码
	 */
	private Integer status;
	/**
	 * 信息
	 */
	private String message;
	/**
	 * 返回的数据类
	 */
	private T data;
	/**
	 * 时间
	 */
	private Long tame;
	
	public Message() {
		super();
	}
	public Message(Integer status, String message, T data, Long tame) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.tame = tame;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Long getTame() {
		return tame;
	}
	public void setTame(Long tame) {
		this.tame = tame;
	}
}
