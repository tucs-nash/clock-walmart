package com.walmart.clock.api.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.clock.api.business.ClockService;
import com.walmart.clock.api.core.model.ClockAngle;
import com.walmart.clock.api.repository.ClockDao;

@Service
public class ClockServiceImpl implements ClockService {

	@Autowired private ClockDao clockDao;
	
	public ClockAngle getAngle(Long hour, Long minutes) {		
		if (hour > 12) {
			hour-=12;
		} else if (hour == 0) {
			hour+=12;
		}
		
		ClockAngle clockAngle = clockDao.getAngle(hour, minutes);
		
		if (clockAngle == null) {
			Long angle = calculateAngle(hour, minutes);
			clockDao.addAngle(hour, minutes, angle);
			clockAngle = new ClockAngle(angle);
		}
		return clockAngle;
	}
	
	private Long calculateAngle(Long hour, Long minutes) {
		Long angle = Math.abs((hour*5 - minutes)*6);
		
		if (angle > 180) {
			angle-=180;
		}
		return angle;
	}
}
