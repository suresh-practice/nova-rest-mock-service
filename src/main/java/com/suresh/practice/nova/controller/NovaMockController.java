package com.suresh.practice.nova.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.practice.nova.dto.ProductCatalogDto;
import com.suresh.practice.nova.dto.ProductPriceDto;
import com.suresh.practice.nova.exception.NovaMockServiceException;
import com.suresh.practice.nova.service.NovaMockService;

@RequestMapping("/")
@RestController
public class NovaMockController {

	@Autowired
	private NovaMockService novaMockService;
	
	@GetMapping(value="/price/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> priceForProduct(@PathVariable Long productId) throws NovaMockServiceException {
		Map<String, Object> responseObject = new HashMap<>(1);
		
		long startTime = System.nanoTime();
		
		List<ProductPriceDto> priceResults = novaMockService.getPriceForProduct(productId);	
		
		long timeElapsed = System.nanoTime() - startTime;
		responseObject.put("results", priceResults);
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
	
	@GetMapping(value="/catalog/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> catalogForProduct(@PathVariable Long productId) throws NovaMockServiceException {
		Map<String, Object> responseObject = new HashMap<>(1);
		
		long startTime = System.nanoTime();
		
		List<ProductCatalogDto> catalogResults = novaMockService.getCatalogForProduct(productId);	
		
		long timeElapsed = System.nanoTime() - startTime;
		responseObject.put("results", catalogResults);
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
}
