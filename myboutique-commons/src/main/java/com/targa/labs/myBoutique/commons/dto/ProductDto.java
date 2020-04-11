package com.targa.labs.myBoutique.commons.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
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
	private CategoryDto category;
	private String image1;
	private String image2;
	private String image3;
	private String image4;


}
