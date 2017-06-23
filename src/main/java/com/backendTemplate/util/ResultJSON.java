package com.backendTemplate.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultJSON {
	private Boolean success = false;
	private String msg;

	public ResultJSON() {
		super();
	}

	public ResultJSON(Boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public ResultJSON(String msg) {
		super();
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResultJSON [success=" + success + ", msg=" + msg + "]";
	}
	

}
