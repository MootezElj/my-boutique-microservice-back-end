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

		if (true){

			//**** Laptops
			Category laptopCat = this.categoryRepository.findFirstByName("Laptops").get();

			if (laptopCat!=null){
				Product asus = new Product("Asus ZenBook Flip 15 UX561UA","ordinateur portable de 15 pouces convertible à 360 ° avec processeur Intel® Core™ i7 et écran tactile NanoEdge Full HD",
						new BigDecimal(999),10,20,ProductStatus.AVAILABLE,1,laptopCat,"","","","");

				Product asus2 = new Product("ASUS ZenBook 15 UX534FA","Le PC portable de 15'' le plus compact avec ScreenPad™ 2.0*",
						new BigDecimal(750),0,25,ProductStatus.AVAILABLE,1,laptopCat,"","","","");

				Product razor = new Product("Razer Blade Pro 17Inch","Razer Blade Pro (17\" Ecran IPS Full-HD) Portable PC Gaming (Intel i7-7700HQ, 16 Go RAM, 256 Go",
						new BigDecimal(2000),10,5,ProductStatus.AVAILABLE,1,laptopCat,"","","","");


				Product thinkPad = new Product("LENOVO ThinkPad E580","Pc Portable LENOVO ThinkPad E580 i5 8é Gén 8Go 1To (20KS0007FE)",
						new BigDecimal(1600),5,5,ProductStatus.DISCONTINUED,1,laptopCat,"","","","");


				Product alienWare = new Product("Alienware 17 R5 VR Ready 17.3\" LCD Gaming Notebook","Alienware 17 R5 VR Ready 17.3\" LCD Gaming Notebook - Intel Core i7 (8th Gen) i7-8750H Hexa-core (6 Core)",
						new BigDecimal(999),10,20,ProductStatus.AVAILABLE,1,laptopCat,"","","","");


				Product rog = new Product("Asus ROG Zephyrus G14\n","LE MEILLEURDES DEUX MONDES",
						new BigDecimal(1700),30,20,ProductStatus.AVAILABLE,1,laptopCat,"","","","");

				this.productRepository.saveAll(Arrays.asList(asus,asus2,razor,thinkPad,alienWare,rog));

			}
			//**** End Laptops


			//**** Drones
			Category droneCat = this.categoryRepository.findFirstByName("Drones").get();

			if(droneCat!=null){
				Product hubsan = new Product("Hubsan X4 h502s","Hubsan X4 h502s Desire Drone Quadcopter avec GPS – Retour à la Maison",
						new BigDecimal(109),10,20,ProductStatus.AVAILABLE,1,droneCat,"","","","");


				Product potensic  = new Product("Potensic Drone GPS T18","Potensic Drone GPS T18 Hélicoptère FPV Caméra 120° Grand Angle Réglable HD 1080P ",
						new BigDecimal(119),0,26,ProductStatus.AVAILABLE,1,droneCat,"","","","");


				Product mavicAir2 = new Product("DJI mavic air 2","Mavic Air 2 takes power and portability to the next level, offering advanced features in a compact form factor.",
						new BigDecimal(700),10,20,ProductStatus.AVAILABLE,1,droneCat,"","","","");


				Product phantom = new Product("DJI Phantom 4 PRO V2","1” 20 MP CMOS Sensor | 30-min Flight Time Obstacle Sensing in Five Directions",
						new BigDecimal(899),10,20,ProductStatus.AVAILABLE,1,droneCat,"","","","");
			}
			//***** End Drones


			//**** Footbal
			Category footbalCat = this.categoryRepository.findFirstByName("Football").get();

			if(footbalCat!=null) {

				Product ball1 = new Product("NIGHTMATCH Light Up Football", " INCL. BALL PUMP and SPARE BATTERIES - Inside LED lights up when kicked - Glow in the Dark Soccer Ball - Size 5 - Official Size & Weight black/orange",
						new BigDecimal(9), 0, 20, ProductStatus.AVAILABLE, 1, footbalCat, "", "", "", "");


				Product ball2 = new Product("UEFA Champions League Football Size 5 Blue White", "UEFA Champions League Football Size 5 Blue White",
						new BigDecimal(15), 10, 0, ProductStatus.DISCONTINUED, 1, footbalCat, "", "", "", "");

				Product ball3 = new Product("Barceloa Signature Football", "Barceloa Signature Football",
						new BigDecimal(14), 5, 20, ProductStatus.AVAILABLE, 1, footbalCat, "", "", "", "");


				Product miuline = new Product("miuline Football Goal Nets Heavy Duty Weatherproof", "miuline Football Goal Nets Heavy Duty Weatherproof Durable Sports Replacement Soccer Nets Suitable for Kids Outdoor Garden",
						new BigDecimal(14), 10, 20, ProductStatus.AVAILABLE, 1, footbalCat, "", "", "", "");
			}
				//**** END Footbal



			//**** Camping
			Category campingCat = this.categoryRepository.findFirstByName("Camping").get();

			if(campingCat!=null) {

				Product waterContainer = new Product("25 Litre Plastic Water Container", "25 Litre Plastic Water Container - Drum - JERRICAN - 25L Containers - Anti-glug System",
						new BigDecimal(11), 0, 20, ProductStatus.DISCONTINUED, 1, campingCat, "", "", "", "");

				Product bottledJoyWatter = new Product("BOTTLED JOY Water Bottle with Straw 1 Litre Tritan", "BOTTLED JOY Water Bottle with Straw 1 Litre Tritan BPA Free Leak proof Durable Gym Sports 1000ML Flip Straw School Bottle Dustproof with Marking",
						new BigDecimal(14), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product activeEra = new Product("Active Era® V2 Waterproof 2", "Active Era® V2 Waterproof 2 Person Pop-Up Tent – 100% Storm Tested with",
						new BigDecimal(54), 10, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product amazonBasicTent = new Product("AmazonBasicsTent", "Dome-style, free-standing tent accommodates up to 4 people; works well for 3-season camping",
						new BigDecimal(59), 0, 25, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product pavillo = new Product("Pavillo Airbed Quick Inflation Outdoor Camping Air Mattress", "Double airbed: Ideal for camping in comfort",
						new BigDecimal(15), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product backpack = new Product("G&X Tactical Backpack", "G&X Tactical Backpack, Military Backpack 25L Army Rucksack MOLLE",
						new BigDecimal(18), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product backpack2 = new Product("AmazonBasics Internal Frame Hiking Backpack", "AmazonBasics Internal Frame Hiking Backpack with Rainfly",
						new BigDecimal(11), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product chainsaw = new Product("Pocket Chainsaw with Paracord Handle", "Pocket Chainsaw with Paracord Handle (24inch-11teeth) / (36inch-16teeth) Folding Chain Hand Saw Fast Wood & Tree Cutting Emergency Outdoor Survival Gear Best for Camping Backpacking Hiking Hunting",
						new BigDecimal(60), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


				Product camillus = new Product("Camillus Ravenous", "Camillus Ravenous Tomahawk, with Sheath, 2.75\" / 7 cm Titanium",
						new BigDecimal(34), 0, 20, ProductStatus.AVAILABLE, 1, campingCat, "", "", "", "");


			}

			//**** END Camping

			}


		}




	}

