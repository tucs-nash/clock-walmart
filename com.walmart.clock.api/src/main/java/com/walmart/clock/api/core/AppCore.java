package com.walmart.clock.api.core;

import java.util.HashMap;

public final class AppCore {

	private static AppCore instance = null;
	private HashMap<Long, HashMap<Long, Long>> angleCalculations;
	
	protected AppCore() {
		this.angleCalculations = new HashMap<Long, HashMap<Long,Long>>();
	}

	public static AppCore getInstance() {
		if(instance == null) {
			instance = new AppCore();
		}
		return instance;
	}

	public HashMap<Long, HashMap<Long, Long>> getAngleCalculations() {
		return angleCalculations;
	}

	public void setAngleCalculations(HashMap<Long, HashMap<Long, Long>> angleCalculations) {
		this.angleCalculations = angleCalculations;
	}
}
