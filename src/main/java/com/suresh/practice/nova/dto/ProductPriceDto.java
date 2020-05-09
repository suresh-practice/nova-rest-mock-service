package com.suresh.practice.nova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceDto {

	private Long productId;
	
	private Double productPrice;
}
