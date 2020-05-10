package com.suresh.practice.nova.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.suresh.practice.nova.dto.ProductCatalogDto;
import com.suresh.practice.nova.dto.ProductPriceDto;
import com.suresh.practice.nova.enums.ProductCatalogConstants;
import com.suresh.practice.nova.enums.ProductNames;
import com.suresh.practice.nova.exception.NovaMockServiceException;
import com.suresh.practice.nova.service.NovaMockService;

@Service
public class NovaMockServiceImpl implements NovaMockService {

	@Override
	public List<ProductPriceDto> getPriceForProduct(Long productId) throws NovaMockServiceException {
		
		preGetPriceForProduct(productId);
		
		return doGetPriceForProduct(productId);
	}

	private List<ProductPriceDto> doGetPriceForProduct(Long productId) {
		
		double random = ThreadLocalRandom.current().nextDouble(100, 500);
		DecimalFormat df = new DecimalFormat("####0.00");
		
		List<ProductPriceDto> productList = new ArrayList<>(1);
		ProductPriceDto pdtPrice = new ProductPriceDto();
		pdtPrice.setProductId(productId);
		pdtPrice.setProductPrice(Double.valueOf(df.format(random)));
		productList.add(pdtPrice);
		return productList;
	}

	private void preGetPriceForProduct(Long productId) throws NovaMockServiceException {
		
		checkValidProductId(productId);
	}

	private void checkValidProductId(Long productId) throws NovaMockServiceException {
		if (productId <= 0) {
			throw new NovaMockServiceException("Invalid product id!");
		}
	}

	@Override
	public List<ProductCatalogDto> getCatalogForProduct(Long productId) throws NovaMockServiceException {
		preGetCatalogForProduct(productId);
		
		return doGetCatalogForProduct(productId);
	}

	private List<ProductCatalogDto> doGetCatalogForProduct(Long productId) {
		
		List<ProductCatalogDto> catalogList = new ArrayList<>(1);
		
		ProductCatalogDto catalogDto = generateProductCatalog(productId);
		
		catalogList.add(catalogDto);
		
		return catalogList;
	}

	private ProductCatalogDto generateProductCatalog(Long productId) {
		ProductCatalogDto catalogDto = new ProductCatalogDto();
		
		catalogDto.setProductId(productId);
		catalogDto.setProductDescription(generateRandomString());
		catalogDto.setProductCategory(ProductCatalogConstants._CATEGORY_);
		
		int pdtLength = ProductNames.values().length;
		int pdtIndex = ThreadLocalRandom.current().nextInt(0, pdtLength-1);
		catalogDto.setProductName(Arrays.asList(ProductNames.values()).get(pdtIndex).name());
		
		return catalogDto;
	}

	private void preGetCatalogForProduct(Long productId) throws NovaMockServiceException {
		checkValidProductId(productId);
	}

	private String generateRandomString() {
		
		int arrayLength = ProductCatalogConstants._CATALOG_DESC_.length;
		
		int rand = ThreadLocalRandom.current().nextInt(0, arrayLength-1);
	    
		return ProductCatalogConstants._CATALOG_DESC_[rand];
	    
	}
}
