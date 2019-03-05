package com.springmvc.pojo;

public class JsonModel {
	
	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	
	/** 成功：success，失败：failed */
	private int code;
	
	/** 信息描述 */
	private String message;
	
	private Object obj;
	
	public JsonModel() {
		super();
	}

	public JsonModel(int code) {
		super();
		this.code = code;
	}


	public JsonModel(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	public JsonModel(int code, Object obj) {
		super();
		this.code = code;
		this.obj = obj;
	}

	public JsonModel(int code, String message, Object obj) {
		super();
		this.code = code;
		this.message = message;
		this.obj = obj;
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

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
