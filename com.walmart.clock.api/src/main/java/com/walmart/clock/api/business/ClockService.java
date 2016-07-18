package com.walmart.clock.api.business;

import com.walmart.clock.api.core.model.ClockAngle;

public interface ClockService {

	public ClockAngle getAngle(Long hour, Long minutes);

}
