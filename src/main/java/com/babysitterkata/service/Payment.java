package com.babysitterkata.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.babysitterkata.constant.BabysitterConst;
import com.babysitterkata.entity.Babysitter;
import com.babysitterkata.exception.BabySitterKataException;

public class Payment {
	Babysitter babysitter;

	public double calculateCharge(String startTime, String bedTime, String endTime) throws BabySitterKataException {
		double charge = 0;

		LocalTime st = parseToMilitary(startTime);
		LocalTime bt = parseToMilitary(bedTime);
		LocalTime et = parseToMilitary(endTime);

		boolean isValid = validateInput(st, bt, et);

		if (isValid) {

			babysitter = new Babysitter();

			Duration start_time_hours = Duration.between(st, bt);
			Duration bed_time_hours = Duration.between(bt, (LocalTime.MAX));
			Duration midnight_time_hours = Duration.between(LocalTime.MIDNIGHT, et);

			babysitter.setStartHour((int) start_time_hours.toHours());
			babysitter.setBedTimeHour((int) bed_time_hours.toHours() + 1); // Adding 1 to fix lost hour
			babysitter.setMidnightHour((int) midnight_time_hours.toHours());

			charge = calculateCharge(charge);

		}

		return charge;

	}

	private double calculateCharge(double charge) {
		charge = babysitter.getStartHour() * BabysitterConst.STARTTIME_PAY
				+ babysitter.getBedTimeHour() * BabysitterConst.BEDTIME_PAY
				+ babysitter.getMidnightHour() * BabysitterConst.MIDNIGHT_PAY;
		return charge;
	}

	public boolean validateInput(LocalTime st, LocalTime bt, LocalTime et) throws BabySitterKataException {

		if (st.isBefore(BabysitterConst.START_TIME)) {
			throw new BabySitterKataException("Start time can't be earlier then 5:00 PM");
		}
		if (st.isAfter(bt)) {
			throw new BabySitterKataException("Start time can't be after bedtime");
		}
		if (et.isAfter(BabysitterConst.END_TIME)) {
			throw new BabySitterKataException("End time can't be after 4:00AM");
		}
		return true;
	}

	public LocalTime parseToMilitary(String time) {
		String localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"))
				.format(DateTimeFormatter.ofPattern("HH:mm"));
		return LocalTime.parse(localTime);
	}

}
