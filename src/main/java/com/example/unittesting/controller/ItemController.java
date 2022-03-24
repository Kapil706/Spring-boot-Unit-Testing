package com.example.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unittesting.business.BusinessServiceItem;
import com.example.unittesting.model.Item;

@RestController
public class ItemController {
	
	
	@Autowired
	private BusinessServiceItem  businessService;
	
	
	@GetMapping("/dummyItem")
	public Item dummyItem() {
		
		return new Item(1, "Cycle", 4000, 2);
		
	}
	
	
	@GetMapping("/dummy-item-from-business-service")
	public Item dummyItemFromBusinessService() {
		return businessService.retrieveData();
	}
	
	
	@GetMapping("/item-from-database")
	public List<Item> itemfromDb(){
		return businessService.retrieveAll();
	}

}
