package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.example.demo.model.SuperMarket;

@Controller
public interface SuperMarketDao extends JpaRepository<SuperMarket, Integer> {
	
}
