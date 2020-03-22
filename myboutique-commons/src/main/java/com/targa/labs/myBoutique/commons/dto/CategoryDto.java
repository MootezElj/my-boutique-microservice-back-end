package com.targa.labs.myBoutique.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CategoryDto {
	private Long id;
	private String name;
	private String description;
	private Set<ProductDto> products;
	
}
