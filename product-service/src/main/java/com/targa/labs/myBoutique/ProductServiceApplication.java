package com.targa.labs.myBoutique;

import com.targa.labs.myBoutique.product.domain.Category;
import com.targa.labs.myBoutique.product.domain.Department;
import com.targa.labs.myBoutique.product.domain.Product;
import com.targa.labs.myBoutique.product.domain.Review;
import com.targa.labs.myBoutique.product.domain.enmeration.ProductStatus;
import com.targa.labs.myBoutique.product.repository.CategoryRepository;
import com.targa.labs.myBoutique.product.repository.DepartmentRepository;
import com.targa.labs.myBoutique.product.repository.ProductRepository;
import com.targa.labs.myBoutique.product.repository.ReviewRepository;
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

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	private static Logger LOG = LoggerFactory
			.getLogger(ProductServiceApplication.class);

	@Override
	public void run(String... args) throws Exception {

		if(false){
			//Review r1 = new Review("Title Review 1","Description review 1 4",4l);
			//Review r2 = new Review("Title Review 2","Description review 2 3",3l);
			//this.reviewRepository.saveAll(Arrays.asList(r1,r2));
			Department clothes = new Department("Clothes","Clothing department","https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469_960_720.jpg");
			Category men_clothing_cat = new Category("Men clothing","Men clothing category",clothes);
			Product men_tshirt_zara = new Product("Men's Zara T-shirt","Taille : S|M|X|XL \n" +
					"Colors: Blue,red and black \n" +
					"Brand: ZARA"
					,new BigDecimal(25),10,45,ProductStatus.AVAILABLE
					,1,men_clothing_cat,"","","","");
			Review r2 = new Review("Title Review 2","Description review 2 3",3l,men_tshirt_zara);
			this.reviewRepository.save(r2);

		}

		if (false){
		Department clothes = new Department("Clothes","Clothing department","https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469_960_720.jpg");
		Department electronics = new Department("Electronics","Electronics department","https://cdn.pixabay.com/photo/2015/06/24/15/45/ipad-820272_960_720.jpg");
		Department tv_movies= new Department("Tv and movies","Tv and movies department","https://cdn.pixabay.com/photo/2015/09/02/12/45/movie-918655_960_720.jpg");
		Department sport = new Department("Sport","Sport department","https://cdn.pixabay.com/photo/2017/04/27/08/29/sport-2264825_960_720.jpg");
		Department video_games = new Department("Video games","Video games department","https://cdn.pixabay.com/photo/2014/05/03/00/50/video-controller-336657_960_720.jpg");
		Department software = new Department("Software","Software department","https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406_960_720.jpg");
		Department art_craft = new Department("Art and craft","Art and craft department","https://cdn.pixabay.com/photo/2017/08/30/12/45/girl-2696947_960_720.jpg");

		departmentRepository.saveAll(Arrays.asList(clothes,electronics,tv_movies,sport,video_games,software,art_craft));

		//Clothes dep categories

		Category men_clothing_cat = new Category("Men clothing","Men clothing category",clothes);
		Category women_clothing_cat = new Category("Women clothing","Women clothing category",clothes);
		Category boys_clothing_cat = new Category("Boys clothing","Boys clothing category",clothes);
		Category girls_clothing_cat = new Category("Girls clothing","Girls clothing category",clothes);
		Category kids_clothing_cat = new Category("Girls clothing","Girls clothing category",clothes);



		//Electronics dep categories
		Category laptops = new Category("Laptops","Laptops category",electronics);
		Category computers = new Category("Pc","PC category",electronics);
		Category gamer_pc = new Category("Pc gamers","Pc gamers",electronics);
		Category consoles = new Category("Consoles","Consoles category",electronics);
		Category phones = new Category("Phones","Phones category",electronics);
		Category drones = new Category("Drones","Drones category",electronics);


		//Sport dep categories
		Category footbal = new Category("Footbal","Footbal category",sport);
		Category handball = new Category("Handball","Handball category",sport);
		Category camping = new Category("Camping","Camping category",sport);
		Category ping_pong = new Category("Ping Pong","Ping Pong",sport);
		Category hiking = new Category("Hiking","Hiking category",sport);

		//saving
		categoryRepository.saveAll(Arrays.asList(men_clothing_cat,women_clothing_cat,boys_clothing_cat,girls_clothing_cat,kids_clothing_cat));
		categoryRepository.saveAll(Arrays.asList(laptops,computers,gamer_pc,consoles,phones,drones));

		categoryRepository.saveAll(Arrays.asList(footbal,handball,camping,ping_pong,hiking));

		//men_clothing products
		//1
		Product men_tshirt_zara = new Product("Men's Zara T-shirt","Taille : S|M|X|XL \n" +
				"Colors: Blue,red and black \n" +
				"Brand: ZARA"
				,new BigDecimal(25),10,45,ProductStatus.AVAILABLE
				,1,men_clothing_cat,"","","","");
		//2
		Product men_tshirt_pullAndBear = new Product("Men's Pull and Bear T-shirt","Taille : X|XL \n" +
				"Colors: Blue and black"
				,new BigDecimal(20),0,60,ProductStatus.AVAILABLE
				,1,men_clothing_cat,"","","","");

		Product men_tshirt_bershka = new Product("Men's Bershka T-shirt","Taille : XS|S|X \n" +
				"Colors: black"
				,new BigDecimal(40),4,17,ProductStatus.DISCONTINUED
				,1,men_clothing_cat,"","","","");



		//women_clothing products
		//1
		Product women_tshirt_zara = new Product("Women's Zara Pant","Taille : S|M|X|XL \n" +
				"Colors: Blue,red and black \n" +
				"Brand: ZARA"
				,new BigDecimal(40),2,45,ProductStatus.AVAILABLE
				,1,women_clothing_cat,"","","","");
		//2
		Product women_tshirt_pullAndBear = new Product("Women's Pull and Bear Pant","Taille : X|XL \n" +
				"Colors: Blue and black"
				,new BigDecimal(90),50,60,ProductStatus.AVAILABLE
				,1,women_clothing_cat,"","","","");

		Product women_tshirt_bershka = new Product("Women's Bershka Pant","Taille : XS|S|X \n" +
				"Colors: black"
				,new BigDecimal(50),4,17,ProductStatus.DISCONTINUED
				,1,women_clothing_cat,"","","","");


		productRepository.saveAll(Arrays.asList(men_tshirt_bershka,men_tshirt_zara,men_tshirt_pullAndBear,women_tshirt_bershka,women_tshirt_zara,women_tshirt_pullAndBear));

			Product s9 = new Product("Samsung galaxy s9"
					,"Released 2018, March\n" +
					"163g, 8.5mm thickness"
					,new BigDecimal(499),20, 32, ProductStatus.DISCONTINUED
					,1,phones,"pic1.png","pic2.jpg",""
			,"");



			Product s11 = new Product("Samsung galaxy s11"
					,"\"Released 2020, March\\n\" +\n" +
					"140, 8.5mm thickness\\n\" +\n"
					,new BigDecimal(999),10,25, ProductStatus.DISCONTINUED
					,1,phones,"pic1.png","pic.jpg","","");



			Product iphoneX = new Product("Iphone X"
					,"At a Glance. The iPhone X was Apple's flagship 10th anniversary iPhone \n" +
					"featuring a 5.8-inch OLED display, facial recognition and 3D camera \n"
					,new BigDecimal(450),20,20, ProductStatus.AVAILABLE
					,1,phones,"pic1.jpg","pic2.jpg","","");


			Product iphone11 = new Product("Iphone 11"
					,"The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n" +
					" It is the thirteenth generation lower-priced iPhone"
					,new BigDecimal(1499),0,11, ProductStatus.AVAILABLE
					,1,phones,"pic1.jpg","pic2.png","","");


			this.productRepository.saveAll(Arrays.asList(s9,s11,iphoneX,iphone11));

			Review r2 = new Review("Title Review 2","Description review 2 3",3l,men_tshirt_zara);
			this.reviewRepository.save(r2);
			}
		}


	}

