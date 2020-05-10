package com.suresh.practice.nova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogDto {

	private Long productId;
	
	private String productName;
	
	private String productDescription;
	
	private String productCategory;
}
