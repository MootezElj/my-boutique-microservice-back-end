package com.targa.labs.myBoutique;

import com.targa.labs.myBoutique.product.domain.Category;
import com.targa.labs.myBoutique.product.domain.Product;
import com.targa.labs.myBoutique.product.domain.Review;
import com.targa.labs.myBoutique.product.domain.enmeration.ProductStatus;
import com.targa.labs.myBoutique.product.repository.CategoryRepository;
import com.targa.labs.myBoutique.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@EnableCircuitBreaker
@EnableSwagger2
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	private static Logger LOG = LoggerFactory
			.getLogger(ProductServiceApplication.class);

	@Override
	public void run(String... args) throws Exception {
		if (this.productRepository.findAll().isEmpty()){
			LOG.info("TESNCAGCA");
			Category electro = new Category("Electornics","Electronics for sale");
			this.categoryRepository.save(electro);
			Product s9 = new Product("Samsung galaxy s9"
					,"Released 2018, March\n" +
					"163g, 8.5mm thickness"
					,new BigDecimal(2000),32, ProductStatus.AVAILABLE
					,1,new HashSet<Review>(),"galaxy_s9");
			s9.setCategory(electro);


			Product s11 = new Product("Samsung galaxy s11"
					,"\"Released 2020, March\\n\" +\n" +
					"140, 8.5mm thickness\\n\" +\n"
					,new BigDecimal(2000),25, ProductStatus.AVAILABLE
					,1,new HashSet<Review>(),"galaxy_s11");
			s11.setCategory(electro);


			Product iphoneX = new Product("Iphone X"
					,"At a Glance. The iPhone X was Apple's flagship 10th anniversary iPhone \n" +
					"featuring a 5.8-inch OLED display, facial recognition and 3D camera \n"
					,new BigDecimal(2000),20, ProductStatus.AVAILABLE
					,1,new HashSet<Review>(),"iphoneX");
			iphoneX.setCategory(electro);


			Product iphone11 = new Product("Iphone 11"
					,"The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n" +
					" It is the thirteenth generation lower-priced iPhone"
					,new BigDecimal(2000),11, ProductStatus.AVAILABLE
					,1,new HashSet<Review>(),"iphone11");
			iphone11.setCategory(electro);

			this.productRepository.saveAll(Arrays.asList(s9,s11,iphoneX,iphone11));


		}


	}
}
