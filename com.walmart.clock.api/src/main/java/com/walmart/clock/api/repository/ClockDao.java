package com.walmart.clock.api.repository;

import com.walmart.clock.api.core.model.ClockAngle;

public interface ClockDao {

	public ClockAngle getAngle(Long hour, Long minutes);
	public void addAngle(Long hour, Long minutes, Long angle);
}
