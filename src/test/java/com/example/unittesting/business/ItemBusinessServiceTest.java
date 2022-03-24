package com.example.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.data.SomeDataService;
import com.example.unittesting.model.Item;



@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	/* SomeBusiness someBusiness = new SomeBusiness(); */
	
	/*SomeDataService mockDataService = mock(SomeDataService.class); */
	
	/*
	@BeforeEach
	void Before() {
		someBusiness.setSomeDataService(mockDataService);
	}  */
	
	@InjectMocks
	private BusinessServiceItem business;
	
	@Mock
	private ItemRepository repository;
	
	

	@Test
	void ItemBusinessRetrieve_basic() {
	
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10), new Item(3,"Item3",20,20)));
		
		List<Item> items = business.retrieveAll();
		
	    assertEquals(100, items.get(0).getValue());
	    assertEquals(400, items.get(1).getValue());
		
	}
	
	
	

}
