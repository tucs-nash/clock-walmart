package com.walmart.clock.api.core.model;

import com.walmart.clock.api.core.model.interfaces.WalmartResponseBean;

public class ErrorBean implements WalmartResponseBean {
	
	private String error;
	
	public ErrorBean(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
}
