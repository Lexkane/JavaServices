package com.ourteam.controllers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeController {

	private ITimeControl iTimeControl = null;

    private ScheduledExecutorService mainExecutor = null;

	private final int period;

	/**
     * Executes an action and repeats it once in <code>millis</code>. Use <code>start()</code> to begin execution.
     * @see #start()
     * @param iTimeControl interface with callback method <code>ITimeControl.onTimeHasCome()</code>
     * @param millis       time in milliseconds
	 */
	public TimeController(ITimeControl iTimeControl, int millis) {
		this.iTimeControl = iTimeControl;
		this.period = millis;

        mainExecutor = Executors.newSingleThreadScheduledExecutor();

    }

    /**
     * Begins an execution of <code>MainTimer</code>.
     *
     * @see MainTimer
     */
    public void start() {
        mainExecutor.scheduleAtFixedRate(new MainTimer(), 500, this.period, TimeUnit.MILLISECONDS);
    }

	class MainTimer implements Runnable {

		@Override
		public void run() {
            try {
				TimeController.this.iTimeControl.onTimeHasCome(TimeController.this.period);
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}
}
