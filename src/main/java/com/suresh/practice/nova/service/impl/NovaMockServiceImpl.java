package com.suresh.practice.nova.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.suresh.practice.nova.dto.ProductPriceDto;
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
		
		if (productId <= 0) {
			throw new NovaMockServiceException("Invalid product id!");
		}
	}

}
