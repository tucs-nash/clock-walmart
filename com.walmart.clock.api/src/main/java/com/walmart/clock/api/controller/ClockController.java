package com.walmart.clock.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walmart.clock.api.business.ClockService;
import com.walmart.clock.api.core.model.ErrorBean;
import com.walmart.clock.api.core.model.interfaces.WalmartResponseBean;
import com.walmart.clock.api.core.utils.ClockConstants;


@Controller
public class ClockController {

	@Autowired ClockService clockService;

	@RequestMapping(value="/clock/{hours}/{minutes}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody WalmartResponseBean getAngle(@PathVariable Long hours, @PathVariable Long minutes) {
		return checkAndResponse(hours, minutes);
	}

	@RequestMapping(value="/clock/{hours}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody WalmartResponseBean getAngle(@PathVariable Long hours) {
		return checkAndResponse(hours, 0l);
	}
		
	private WalmartResponseBean checkAndResponse(Long hours, Long minutes) {
		if (hours > 23) {
			return new ErrorBean(ClockConstants.MESSAGE_HOURS_ERROR);
		} else if (minutes > 59) {
			return new ErrorBean(ClockConstants.MESSAGE_MINUTES_ERROR);			
		} else {
			return clockService.getAngle(hours, minutes);			
		}
	}
}
