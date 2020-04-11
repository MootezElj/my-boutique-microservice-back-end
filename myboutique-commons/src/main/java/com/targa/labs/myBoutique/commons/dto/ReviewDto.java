package com.targa.labs.myBoutique.commons.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {
	private Long id;
	private String title;
	private String description;
	private Long rating;
	private ProductDto product;
}
