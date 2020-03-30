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
						null,
						productDto.getImage1(),
						productDto.getImage2(),
						productDto.getImage3(),
						productDto.getImage4()
						)
				));
	}
	
	public void delete(Long id) {
		log.debug("Request to delete Product : {}", id);
		this.productRepository.deleteById(id);
		}

	public static ProductDto mapToDto(Product product) {
		Set<Review> reviews = new HashSet<Review>();
		if (product.getReviews()!=null)
			reviews = product.getReviews();
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
					reviews.stream().map(ReviewService::mapToDto)
					.collect(Collectors.toSet()),
					CategoryService.mapToDto(product.getCategory()),
					product.getImage1(),
					product.getImage2(),
					product.getImage3(),
					product.getImage4()

					);
		}
		return null;
	}

}
