package com.babysitterkata.service;

import org.junit.Test;

import com.babysitterkata.exception.BabySitterKataException;

public class PaymentTest {

	Payment payment;
	
	@Test(expected = BabySitterKataException.class)
	public void testValidation() throws BabySitterKataException {
		payment = new Payment();
		
		payment.calculateCharge("17:00", "18:00", "04:00");
	}

}
