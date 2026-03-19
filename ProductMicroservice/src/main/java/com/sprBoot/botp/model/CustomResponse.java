package com.sprBoot.botp.model;

public class CustomResponse {
    private String message;
    private Object data;

    // Constructor
    public CustomResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

    
}