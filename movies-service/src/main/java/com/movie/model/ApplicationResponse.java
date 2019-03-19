package com.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ApplicationResponse {
	
	private String status;
	private int result;
	private int num;
	@JsonIgnore
	private String message;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ApplicationResponse [status=" + status + ", result=" + result + ", num=" + num + "]";
	}

}
