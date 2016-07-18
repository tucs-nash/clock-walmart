package com.walmart.clock.api;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.walmart.clock.api.business.ClockService;
import com.walmart.clock.api.business.impl.ClockServiceImpl;
import com.walmart.clock.api.controller.ClockController;
import com.walmart.clock.api.core.model.ClockAngle;
import com.walmart.clock.api.core.model.ErrorBean;
import com.walmart.clock.api.core.utils.ClockConstants;
import com.walmart.clock.api.repository.ClockDao;

import junit.framework.TestCase;
import junitx.util.PrivateAccessor;

@RunWith(PowerMockRunner.class)
public class ClockTest {

	private ClockController clockController;
	private ClockService clockService;
	private ClockDao clockDao;
	
	@Before
	public void setUp() throws NoSuchFieldException {
		this.clockController = new ClockController();
		this.clockService = new ClockServiceImpl();
		this.clockDao = PowerMock.createMock(ClockDao.class);
		
		PrivateAccessor.setField(clockController, "clockService", clockService);
		PrivateAccessor.setField(clockService, "clockDao", clockDao);
	}
	
	@Test
	public void testHourMinutes() {
		Long hour = 9l;
		Long minutes = 30l;
		
		EasyMock.expect(clockDao.getAngle(hour, minutes)).andReturn(new ClockAngle(90l));
		
		PowerMock.replayAll();
		ClockAngle clockAngle = (ClockAngle) clockController.getAngle(hour, minutes);
		PowerMock.verifyAll();
		
		TestCase.assertEquals(new Long(90), clockAngle.getAngle());
	}
	
	@Test
	public void testHour() {
		Long hour = 9l;
		Long minutes = 0l;
		
		EasyMock.expect(clockDao.getAngle(hour, minutes)).andReturn(new ClockAngle(90l));
		
		PowerMock.replayAll();
		ClockAngle clockAngle = (ClockAngle) clockController.getAngle(hour);
		PowerMock.verifyAll();
		
		TestCase.assertEquals(new Long(90), clockAngle.getAngle());
	}
	
	@Test
	public void testErrors() {
		ErrorBean error = (ErrorBean) clockController.getAngle(25l);
		TestCase.assertEquals(ClockConstants.MESSAGE_HOURS_ERROR, error.getError());
		
		error = (ErrorBean) clockController.getAngle(23l, 60l);
		TestCase.assertEquals(ClockConstants.MESSAGE_MINUTES_ERROR, error.getError());
	}
}
