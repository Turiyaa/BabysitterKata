package com.babysitterkata.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import com.babysitterkata.exception.BabySitterKataException;

public class PaymentTest {

	Payment payment;
	private static final double DELTA = 0;
	
	@Test
	public void testCalculateCharge() throws BabySitterKataException {
		payment = new Payment();
		assertEquals(132, payment.calculateCharge("05:00 PM","08:00 PM", "04:00 AM"), DELTA);
	}
	
	@Test
	public void testCalculateCharge2() throws BabySitterKataException {
		payment = new Payment();
		assertEquals(112, payment.calculateCharge("06:00 PM","10:00 PM", "03:00 AM"), DELTA);
	}
	
	@Test(expected = BabySitterKataException.class)
	public void testCalculateChargeStartTime() throws BabySitterKataException {
		payment = new Payment();
		assertEquals(112, payment.calculateCharge("03:00 PM","10:00 PM", "03:00 AM"), DELTA);
	}

	@Test(expected = BabySitterKataException.class)
	public void testCalculateChargeEndTime() throws BabySitterKataException {
		payment = new Payment();
		assertEquals(112, payment.calculateCharge("05:00 PM","10:00 PM", "05:00 AM"), DELTA);
	}
	
	@Test
	public void testParseToMilitary() {
		payment = new Payment();
		LocalTime expected = LocalTime.parse("17:00");
		assertEquals(expected, payment.parseToMilitary("05:00 PM"));
	}
	
	@Test
	public void testValidation() throws BabySitterKataException {
		payment = new Payment();
		LocalTime st = LocalTime.parse("17:00");
		LocalTime bt = LocalTime.parse("18:00");
		LocalTime et = LocalTime.parse("04:00");
		
		assertEquals(true, payment.validateInput(st, bt, et));
	}
}
