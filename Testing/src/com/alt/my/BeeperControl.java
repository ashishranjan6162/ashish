package com.alt.my;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class BeeperControl {
	private final ScheduledExecutorService scheduler =
			Executors.newScheduledThreadPool(1);

	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() { System.out.println("beep"); }
		};
		final ScheduledFuture<?> beeperHandle =
				scheduler.scheduleAtFixedRate(beeper, 1, 1, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() { beeperHandle.cancel(true); }
		}, 0 * 0, SECONDS);
	}
	public static void main(String[] args) {
		new BeeperControl().beepForAnHour();
	}

}
