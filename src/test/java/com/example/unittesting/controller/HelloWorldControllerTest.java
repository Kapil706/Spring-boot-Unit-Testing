package com.example.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;




@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {
	
	
	@Autowired
	MockMvc mockMvc;

	@Test
	public void helloWorld_basic() throws Exception {
		
		// Call GET '/helloWorld' , application/json
		
		   RequestBuilder request =  MockMvcRequestBuilders
				                     .get("/helloWorld")
				                     .accept(MediaType.APPLICATION_JSON);
		   
		   
		   MvcResult result =  mockMvc.perform(request)
				               .andExpect(status().isOk())
				               .andExpect(content().string("Hello World"))
				               .andReturn();
		
		// verify
		   
		   assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}

}
