package com.example.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTesting {
	
	
	@Autowired
	private TestRestTemplate restTemplateTest;
	
	@Test
	public void ContextLoads() throws JSONException {
		
		String response =  this.restTemplateTest.getForObject("/item-from-database", String.class);
		
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
		
	}
	
	

}
