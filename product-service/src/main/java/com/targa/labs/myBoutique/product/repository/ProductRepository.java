package com.targa.labs.myBoutique.product.repository;


import com.targa.labs.myBoutique.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Optional<Product> findById(Long id);
	List<Product> findAllByCategoryName(String category_name);
}
