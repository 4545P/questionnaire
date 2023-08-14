package com.example.questionnaire.constants;

public enum RtnCode {
	
	SUCCESSFUL("200", "successful ! !"),
	NOT_UNAUTHORIZED("401", "unauthorized ! !"),
	NOT_FOUND("404", "not found ! !"),
	NO_PERMISSION("403", "no permission");

     private String code;
	
	private String message;
	
	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
