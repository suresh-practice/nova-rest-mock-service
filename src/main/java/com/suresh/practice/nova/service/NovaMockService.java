package com.suresh.practice.nova.service;

import java.util.List;

import com.suresh.practice.nova.dto.ProductPriceDto;
import com.suresh.practice.nova.exception.NovaMockServiceException;

public interface NovaMockService {

	List<ProductPriceDto> getPriceForProduct(Long productId) throws NovaMockServiceException;
}