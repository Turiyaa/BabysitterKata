package com.babysitterkata.entity;

import java.time.LocalTime;

public class Babysitter {
	private static LocalTime startTime;
	private LocalTime bedTime;
	private LocalTime endTime;
	private double charge;

	public static LocalTime getStartTime() {
		return startTime;
	}

	public static void setStartTime(LocalTime startTime) {
		Babysitter.startTime = startTime;
	}

	public LocalTime getBedTime() {
		return bedTime;
	}

	public void setBedTime(LocalTime bedTime) {
		this.bedTime = bedTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

}
