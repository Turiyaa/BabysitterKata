package com.babysitterkata.entity;

import java.time.LocalTime;

public class Babysitter {
	private LocalTime startTime;
	private LocalTime bedTime;
	private LocalTime endTime;
	private double charge;

	Babysitter() {

	}

	public Babysitter(LocalTime st, LocalTime bt, LocalTime et) {
		this.startTime = st;
		this.bedTime = bt;
		this.endTime = et;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
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
