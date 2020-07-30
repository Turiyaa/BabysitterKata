package com.babysitterkata.service;

import java.time.LocalTime;

import com.babysitterkata.constant.BabysitterConst;
import com.babysitterkata.exception.BabySitterKataException;

public class Payment {

	public double calculateCharge(String startTime, String bedTime, String endTime) {
		double charge = 2;
		return charge;
		
	}
	
	public void validateInput(String startTime, String bedTime, String endTime) throws BabySitterKataException {
		LocalTime st = LocalTime.parse(startTime);
		LocalTime bt = LocalTime.parse(bedTime);
		LocalTime et = LocalTime.parse(endTime);
		if(st.isBefore(BabysitterConst.START_TIME)) {
			throw new BabySitterKataException("Start time can't be earlier then 5:00 PM");
		}

	}
}
