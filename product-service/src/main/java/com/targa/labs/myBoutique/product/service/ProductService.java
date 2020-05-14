package com.targa.labs.myBoutique.product.service;

import com.targa.labs.myBoutique.commons.dto.ProductDto;
import com.targa.labs.myBoutique.commons.dto.ReviewDto;
import com.targa.labs.myBoutique.product.domain.Category;
import com.targa.labs.myBoutique.product.domain.Product;
import com.targa.labs.myBoutique.product.domain.Review;
import com.targa.labs.myBoutique.product.domain.enmeration.ProductStatus;
import com.targa.labs.myBoutique.product.repository.CategoryRepository;
import com.targa.labs.myBoutique.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public List<ProductDto> findByCategory(String catName){
		log.debug("Request to find Products having category : "+catName);
		return this.productRepository.findAllByCategoryName(catName).stream()
				.map(ProductService::mapToDto)
				.collect(Collectors.toList());
	}

	public List<ProductDto> findAll(){
		log.debug("Request to find all Products:{} ");
		return this.productRepository.findAll()
				.stream().map(ProductService::mapToDto)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		log.debug("Request to find Product By Id:{} ",id);
		return this.productRepository.findById(id)
				.map(ProductService::mapToDto).orElse(null);
	}

	public ProductDto create(ProductDto productDto) {
		return mapToDto(this.productRepository.save(
				new Product(
						productDto.getName(),
						productDto.getDescription(),
						productDto.getPrice(),
						productDto.getDiscount(),
						productDto.getQuantity(),
						ProductStatus.valueOf(productDto.getStatus()),
						productDto.getSalesCounter(),
						this.categoryRepository.findById(productDto.getCategory().getId())
						.orElse(null),
						productDto.getImage1(),
						productDto.getImage2(),
						productDto.getImage3(),
						productDto.getImage4()
						)
				));
	}

	public List<ProductDto> getTrendingProductsForDepartment(String department){
		List<Product> products = new ArrayList<>();
		List<Category> categories =this.categoryRepository.findAllByDepartment_DepName(department);
		for (int i=0;i<categories.size();i++){
			products.add(this.productRepository.findAllByCategoryName(categories.get(i).getName()).get(0));
			products.add(this.productRepository.findAllByCategoryName(categories.get(i).getName()).get(1));
			// I wanted to just add 2 more products to the list (for the front view to be adequate)
			if (categories.get(i).getName().equals("Drones"))
				products.add(this.productRepository.findAllByCategoryName(categories.get(i).getName()).get(2));
			if (categories.get(i).getName().equals("Laptops"))
				products.add(this.productRepository.findAllByCategoryName(categories.get(i).getName()).get(2));
		}
		return products.stream().map(ProductService::mapToDto)
				.collect(Collectors.toList());
	}

	public void delete(Long id) {
		log.debug("Request to delete Product : {}", id);
		this.productRepository.deleteById(id);
		}

	public static ProductDto mapToDto(Product product) {
		if (product != null) {
			return new ProductDto(
					product.getId(),
					product.getName(),
					product.getDescription(),
					product.getPrice(),
					product.getDiscount(),
					product.getPriceBeforeDiscount(),
					product.getQuantity(),
					product.getStatus().toString(),
					product.getSalesCounter(),
					CategoryService.mapToDto(product.getCategory()),
					product.getImage1(),
					product.getImage2(),
					product.getImage3(),
					product.getImage4());
		}
		return null;
	}

}
