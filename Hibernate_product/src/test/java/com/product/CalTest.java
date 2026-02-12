package com.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalTest {
	@Test
	public void divideTest() {
		Cal c = new Cal();
		
		int result = c.divide(10, 5);
		assertEquals(2, result);
	}
	@Test
	public void dividezero() {
		Cal c = new Cal();
		
		int result = c.divide(10, 0);
		assertEquals(0, result);
	}

}
