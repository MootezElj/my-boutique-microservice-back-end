package com.targa.labs.myBoutique.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer discount;
	private BigDecimal priceBeforeDiscount;
	private Integer quantity;
	private String status;
	private Integer salesCounter;
	private Set<ReviewDto> reviews;
	private CategoryDto category;
	private String image1;
	private String image2;
	private String image3;
	private String image4;


}
