package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SuperMarketDao;
import com.example.demo.model.SuperMarket;

@RestController
public class SuperMarketController {

	@Autowired
	SuperMarketDao superMarketDao;

	
	@GetMapping("items")
	public List<SuperMarket> getItems() {
		return superMarketDao.findAll();
	}


	@GetMapping("item/{id}")
	public SuperMarket getItem(@PathVariable("id") int id) {
		return superMarketDao.findById(id).get();
	}


	@PostMapping("items")
	public SuperMarket addItem(@RequestBody SuperMarket superMarket) {
		return superMarketDao.save(superMarket);
	}

	@PutMapping("item")
	public SuperMarket saveOrUpdateItem(@RequestBody SuperMarket superMarket) {
		return superMarketDao.save(superMarket);
	}


	@PutMapping("item/{id}")
	public SuperMarket updateItemById(@PathVariable int id, @Valid @RequestBody SuperMarket superMarketDetails) {
		SuperMarket superMarket = superMarketDao.findById(id).get();

		superMarket.setName(superMarketDetails.getName());
		superMarket.setQuantity(superMarketDetails.getQuantity());
		superMarket.setDate(superMarketDetails.getDate());
		SuperMarket updatedItem = superMarketDao.save(superMarket);

		return updatedItem;
	}

	@DeleteMapping("items")
	public void deleteAllItems(SuperMarket superMarket) {
		superMarketDao.deleteAll();
	}
	
	@DeleteMapping("items/{id}")
	public String deleteItem(@PathVariable int id) {
		superMarketDao.deleteById(id);
		return "Deleted";
	}
	 
	@PatchMapping("item/{id}")
	public SuperMarket patchUpdateItemById(@PathVariable int id, @Valid @RequestBody SuperMarket superMarketDetails) {
		SuperMarket superMarket = superMarketDao.findById(id).get();
		superMarket.setQuantity(superMarketDetails.getQuantity());
		superMarket.setDate(superMarketDetails.getDate());
		SuperMarket updatedItem = superMarketDao.save(superMarket);

		return updatedItem;
	}
}
