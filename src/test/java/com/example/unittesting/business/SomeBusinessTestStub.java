package com.example.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.unittesting.data.SomeDataService;


class someBusiness_basic implements SomeDataService{

	@Override
	public int[] reterieveData() {
		return new int[] {1,2,3};
	}
	
}


class someBusiness_empty implements SomeDataService{

	@Override
	public int[] reterieveData() {
		return new int[] {};
	}
	
}


class someBusiness_oneValue implements SomeDataService{

	@Override
	public int[] reterieveData() {
		return new int[] {1};
	}
	
}

class SomeBusinessTestStub {
	
	
	

	@Test
	void somebusinessUsingDataService_basic() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		someBusiness.setSomeDataService(new someBusiness_basic());
		int actualResult = someBusiness.sumUsingDataSerive();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);	
		
	}
	
	
	@Test
	void somebusiness_empty() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		someBusiness.setSomeDataService(new someBusiness_empty());
		int actualResult = someBusiness.sumUsingDataSerive();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);	
		
	}
	
	@Test
	void somebusiness_oneValue() {
		
		SomeBusiness someBusiness = new SomeBusiness();
		someBusiness.setSomeDataService(new someBusiness_oneValue());
		int actualResult = someBusiness.sumUsingDataSerive();
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);	
		
	}

}
