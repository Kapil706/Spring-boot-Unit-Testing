package com.example.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	void somebusiness_basic() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		int actualResult = someBusiness.sum(new int[] {1,2,3,});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);	
		
	}
	
	
	@Test
	void somebusiness_empty() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		int actualResult = someBusiness.sum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);	
		
	}
	
	@Test
	void somebusiness_oneValue() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		int actualResult = someBusiness.sum(new int[] {1});
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);	
		
	}

}
