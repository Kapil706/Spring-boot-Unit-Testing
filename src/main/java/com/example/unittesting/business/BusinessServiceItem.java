package com.example.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;


@Component
public class BusinessServiceItem {

	@Autowired
	private ItemRepository repository;
	
	public Item retrieveData() {
		 return new Item(1, "Car", 4000000, 1);
	}
	
	
	public List<Item> retrieveAll(){
		 List<Item> items = repository.findAll();
		 
		 for(Item item: items) {
			 item.setValue(item.getPrice() * item.getQuantity());
		 }
		 
		 return items;
	}
	
	

}
