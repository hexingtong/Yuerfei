package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResult {
	
	public enum ResultStatus {
		success, fail
	}

	/**
	 * Description：返回状态码
	 */
private String code;
	/** 成功：success，失败：fail */
	private ResultStatus result;
	
	/** 信息描述 */
	private String message;
	
	/** 错误号，仅在result为fail时表明错误的类型 */
	private int errno;
	
	/** 返回具体数据 */
	private Object data;
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(ResultStatus result, int errno) {
		super();
		this.result = result;
		this.errno = errno;
	}
	
	public JsonResult(ResultStatus result, String message, int errno) {
		super();
		this.result = result;
		this.message = message;
		this.errno = errno;
	}

	public JsonResult(ResultStatus result, String message, int errno, Object data,String code) {
		super();
		this.result = result;
		this.message = message;
		this.errno = errno;
		this.data = data;
		this.code=code;
	}

	public ResultStatus getResult() {
		return result;
	}

	public void setResult(ResultStatus result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String createString(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
