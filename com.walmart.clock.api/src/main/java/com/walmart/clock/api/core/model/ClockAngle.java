package com.walmart.clock.api.core.model;

import com.walmart.clock.api.core.model.interfaces.WalmartResponseBean;

public class ClockAngle implements WalmartResponseBean {
	
	private Long angle;
	
	public ClockAngle(Long angle) {
		this.angle = angle;
	}

	public Long getAngle() {
		return angle;
	}

	public void setAngle(Long angle) {
		this.angle = angle;
	}
	
}
