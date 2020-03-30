package com.targa.labs.myBoutique.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private Long id;
	private String name;
	private String description;
	private DepartmentDto departmentDto;
}
