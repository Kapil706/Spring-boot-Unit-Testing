package com.example.unittesting.business;

import java.util.Arrays;

import com.example.unittesting.data.SomeDataService;

public class SomeBusiness {
	
	
	private SomeDataService someDataService;
	
	
	
	
	// setter based injection
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}


	public int sum(int[] data) {
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
		
		/*int sum=0;
		for(int value:data) {
			sum += value;
		}
		return sum;  */
	}
	
	
	public int sumUsingDataSerive() {
		
		return Arrays.stream(someDataService.reterieveData()).reduce(Integer::sum).orElse(0);
		
		/*int sum=0;
		int[] data = someDataService.reterieveData();
		for(int value:data) {
			sum += value;
		}
		return sum; */
	}
	
	

}
