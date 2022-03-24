package com.example.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.unittesting.business.BusinessServiceItem;
import com.example.unittesting.model.Item;




@WebMvcTest(ItemController.class)
class ItemControllerTest {
	
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BusinessServiceItem businessService;
	

	@Test
	public void dummyItem_basic() throws Exception {
		
		// Call GET '/dummyItem' , application/json
		
		   RequestBuilder request =  MockMvcRequestBuilders
				                     .get("/dummyItem")
				                     .accept(MediaType.APPLICATION_JSON);
		   
		   
		   MvcResult result =  mockMvc.perform(request)
				               .andExpect(status().isOk())
				               .andExpect(content().json("{\"id\": 1,\"name\":\"Cycle\",\"price\":\"4000\"}"))
				               .andReturn();
		
		// verify
		   
	
		
	}
	
	
	@Test
	public void ItemFromBusinessService_basic() throws Exception {
		
		
		 when(businessService.retrieveData()).thenReturn(new Item(1,"Car",40000,1));
		
		
		
		// Call GET '/dummyItem' , application/json
		
		
		
		   RequestBuilder request =  MockMvcRequestBuilders
				                     .get("/dummy-item-from-business-service")
				                     .accept(MediaType.APPLICATION_JSON);
		   
		   
		   MvcResult result =  mockMvc.perform(request)
				               .andExpect(status().isOk())
				               .andExpect(content().json("{id:1,name:Car,price:40000}"))
				               .andReturn();
		
		// verify
		   
	
		 //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	
	
	@Test
	public void ItemFromDatabaseService_basic() throws Exception {
		
		
		
		when(businessService.retrieveAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10), new Item(3,"Item3",20,20)));
		
		
		RequestBuilder request = MockMvcRequestBuilders
				                 .get("/item-from-database")
				                 .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result =  mockMvc.perform(request)
				            .andExpect(status().isOk())
				            .andExpect(content().json("[{id:3,name:Item3,price:20},{id:2,name:Item2,price:10}]"))
				            .andReturn();
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
