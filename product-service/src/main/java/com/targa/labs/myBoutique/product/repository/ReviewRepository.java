package com.targa.labs.myBoutique.product.repository;

import com.targa.labs.myBoutique.product.domain.Product;
import com.targa.labs.myBoutique.product.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	Optional<Review> findById(Long id);
	List<Review> findAllByProductId(Long productId);
}
