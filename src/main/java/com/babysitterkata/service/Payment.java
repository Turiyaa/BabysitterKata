package com.babysitterkata.service;

import java.time.Duration;
import java.time.LocalTime;

import com.babysitterkata.constant.BabysitterConst;
import com.babysitterkata.entity.Babysitter;
import com.babysitterkata.exception.BabySitterKataException;

public class Payment {
	Babysitter babysitter;

	public double calculateCharge(String startTime, String bedTime, String endTime) throws BabySitterKataException {

		LocalTime st = LocalTime.parse(startTime);
		LocalTime bt = LocalTime.parse(bedTime);
		LocalTime et = LocalTime.parse(endTime);
		
		boolean isValid = validateInput(st, bt, et);
		
		if(isValid) {
			babysitter = new Babysitter(st, bt, et);
			
			Duration start_time_hours = Duration.between(st, bt);
			Duration bed_time_hours = Duration.between(bt, LocalTime.MIDNIGHT);
			Duration midnight_time_hours = Duration.between(LocalTime.MIDNIGHT, et);
			
		}
		
		
		double charge = 2;
		return charge;
		
	}
	
	public boolean validateInput(LocalTime st, LocalTime bt, LocalTime et) throws BabySitterKataException {

		if(st.isBefore(BabysitterConst.START_TIME)) {
			throw new BabySitterKataException("Start time can't be earlier then 5:00 PM");
		}
		if(st.isAfter(bt)) {
			throw new BabySitterKataException("Start time can't be after bedtime");
		}
		if(et.isAfter(BabysitterConst.END_TIME)) {
			throw new BabySitterKataException("End time can't be after 4:00AM");
		}
		return true;
	}
	
}
