package com.targa.labs.myBoutique.product.web;


import com.targa.labs.myBoutique.commons.dto.CategoryDto;
import com.targa.labs.myBoutique.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myBoutique.commons.utils.Web.API;


@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/categories")
public class CategoryResource {

	private final CategoryService categoryService;

	@GetMapping
	public List<CategoryDto> getAll(){
		return this.categoryService.findAll();
	}

	@GetMapping("/{id}")
	public CategoryDto findById(@PathVariable Long id) {
		return this.categoryService.findById(id);		
	}

	@GetMapping("/category/{name}")
	public CategoryDto getCategoryByName(@PathVariable String name){
		return this.categoryService.findByName(name);
	}


	@GetMapping("/department/{depName}")
	public List<CategoryDto> findCategoriesOfDepartment(@PathVariable String depName) {
		return this.categoryService.findCategoriesOfDepartment(depName);
	}


	@PostMapping
	public CategoryDto create(CategoryDto categoryDto) {
		return this.categoryService.create(categoryDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.categoryService.delete(id);
	}

}
