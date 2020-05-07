package com.targa.labs.myBoutique.commons.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
	private Long id;
	private String title;
	private String description;
	private Long rating;
	private ProductDto product;
}
