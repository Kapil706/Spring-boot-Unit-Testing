package com.example.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.data.SomeDataService;



@ExtendWith(MockitoExtension.class)
class SomeBusinessTestMockito {
	
	/* SomeBusiness someBusiness = new SomeBusiness(); */
	
	/*SomeDataService mockDataService = mock(SomeDataService.class); */
	
	/*
	@BeforeEach
	void Before() {
		someBusiness.setSomeDataService(mockDataService);
	}  */
	
	@InjectMocks
	SomeBusiness someBusiness;
	
	@Mock
	SomeDataService mockDataService;
	
	

	@Test
	void somebusinessUsingDataService_basic() {
	
		when(mockDataService.reterieveData()).thenReturn( new int[] {1,2,3});
		assertEquals(6,someBusiness.sumUsingDataSerive() );	
		
	}
	
	
	@Test
	void somebusinessUsingDataService_empty() {
		
		when(mockDataService.reterieveData()).thenReturn( new int[] {});
		assertEquals(0,someBusiness.sumUsingDataSerive() );		
	}
	
	@Test
	void somebusinessUsingDataService_oneValue() {
		
		when(mockDataService.reterieveData()).thenReturn( new int[] {1});
		assertEquals(1,someBusiness.sumUsingDataSerive() );	
		
	}

}
